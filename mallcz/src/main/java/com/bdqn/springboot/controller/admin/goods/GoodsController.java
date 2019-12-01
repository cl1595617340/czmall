package com.bdqn.springboot.controller.admin.goods;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bdqn.springboot.entity.*;
import com.bdqn.springboot.entity.inputSearch.InputSearch;
import com.bdqn.springboot.service.GoodsService;
import com.bdqn.springboot.service.GoodscolorService;
import com.bdqn.springboot.service.Goodstype3Service;
import com.bdqn.springboot.service.VersionsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import javafx.scene.control.Tab;
import org.apache.commons.io.FilenameUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/admin/goods/goods")
public class GoodsController {


    @Resource
    private GoodsService goodsService;

    @Resource
    private Goodstype3Service goodstype3Service;

    @Resource
    private VersionsService versionsService;

    @Resource
    private GoodscolorService goodscolorService;

    /*上传的文件名字，放在全局是因为一个文件要上传4次（前台和后台），文件名字不能变*/
    private String uploadPicturename;

    /*询查员工主列表有分页*/
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public String productList(String newobj,
                              @RequestParam(value = "page",defaultValue = "1")Long current,
                              @RequestParam(value = "size",defaultValue = "2")Long size
        ) {
        Map<String, Object> map = new HashMap<String, Object>();

        /*吧前台传来的json对象解析成goods*/
        Goods goods = JSON.parseObject(newobj,Goods.class);

        if (!goods.getStrartDate().equals("")){

            System.out.println(goods.getStrartDate());
            String sb = goods.getStrartDate();

            String[] ids = sb.split(",");//把数组里的值逗号隔开

            /*吧前台传过来乱七八糟的时间解析成正确的时间*/
            String regEx="[\n`~!@#$%^&*()|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？]";
            String aa = "";

            int i = 0;
             for (String  s: ids) {
                 i++;
                    String newString = s.replaceAll(regEx,aa);
                    String str =newString .replace("\"", "");
                     String res = str.substring(0, str.indexOf("T"));
                     if (i==1){
                         goods.setStrartDate(res);
                     }else {
                         goods.setEndDate(res);
                     }
             }
        }
        try {
            //创建分页对象，指定当前页码及每页显示数量
            Page<Goods> page = new Page<Goods>(current,size);

            //分页查询
            IPage<Goods> blogIPage = goodsService.getGoodsList(page,goods);

            //获取数据列表
            List<Goods> goodsList = blogIPage.getRecords();

            //输入建议
            List<InputSearch> inputSearcheslist = new ArrayList<>();
            for (Goods goods1 : goodsList) {
                InputSearch inputSearch = new InputSearch();
                inputSearch.setValue(goods1.getGoodsName());
                inputSearcheslist.add(inputSearch);
            }

            //所有3级分类
            List<Goodstype3> goodstype3List = goodstype3Service.list();
            Goodstype3 goodstype3 = new Goodstype3();
            goodstype3.setGoodstype3Name("请选择");

            goodstype3List.add(0,goodstype3);
            map.put("data", goodsList);
            map.put("page", page);

            map.put("goodstype3List", goodstype3List);
            //输入建议
            map.put("inputSearcheslist", inputSearcheslist);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return JSON.toJSONString(map);

    }


    /*批量下架商品*/
    @RequestMapping("/updateGodosState")
    public String updateGodosState(Integer state,String idss){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            String[] ids = idss.split(",");//把数组里的值逗号隔开
            for (String s : ids) {
                /* System.out.println(s);*/
            }
            Map<String,Object> map2 = new HashMap<String, Object>();
            map2.put("ids",ids);
            map2.put("state",state);
            int res = goodsService.updateGodosState(map2);
            if (res!=0){
                map.put("res",true);
            }else {
                map.put("res",false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }

    /*修改手机的版本信息*/
    @RequestMapping("/updateVersions")
    public String updateVersions(String obj){
        Map<String, Object> map = new HashMap<String, Object>();

        /*吧前台传来的json对象解析成*/
        Versions versions = JSON.parseObject(obj,Versions.class);

        Boolean res = versionsService.updateById(versions);
        map.put("res",res);
        return JSON.toJSONString(map);
    }

    /*添加手机的版本信息*/
    @RequestMapping("/addVersions")
    public String addVersions(String obj){
        Map<String, Object> map = new HashMap<String, Object>();

        /*吧前台传来的json对象解析成*/
        Versions versions = JSON.parseObject(obj,Versions.class);

        Boolean res = versionsService.save(versions);

        map.put("res",res);
        return JSON.toJSONString(map);
    }

    /*子组件版本添加后根基goodsId刷新用的*/
    @RequestMapping("/Versionslist")
    public String Versionslist(Long goodsId){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Versions> versionsList = goodsService.Versionslist(goodsId);
            map.put("versionsList",versionsList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }

    /*删除手机版本*/
    @RequestMapping("/deleteVersions")
    public String deleteVersions(Long versionsId){
        Map<String, Object> map = new HashMap<String, Object>();
        Boolean res = versionsService.removeById(versionsId);
        map.put("res",res);
        return JSON.toJSONString(map);
    }

    /*---------------------------------------------------------------展示图的4个文件上传方法-----------*/
    //这个是后台
    public void upload(MultipartFile file){
        System.out.println("2");
        try {
            // 获取项目根路径
            final File basePath = new File(ResourceUtils.getURL("classpath:").getPath());
            String str = basePath.toString();
            String str1 = str.substring(0, str.indexOf("target\\classes"));//截取target\classes之前的字符串


            String path = str1+"\\src\\main\\resources\\static\\static\\images\\goods\\";

            File file2 = new File(path + uploadPicturename);
            file.transferTo(file2);

            String imgurl = file2.toString();
            System.out.println(imgurl);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //这个是前台（第二个重新写个控制器，因为MultipartFile文件对象，好像不能用2次）
    @RequestMapping(value = "/upload02",method = RequestMethod.POST)
    public void upload02(MultipartFile file){
        try {
            System.out.println("1");

            String path = "D:\\web\\js\\vue-manage-system-master\\public\\static\\images\\goods\\";
            String oldFileName = file.getOriginalFilename();


            String suffix = FilenameUtils.getExtension(oldFileName);
            //加密后的文件新名字
            String newFileName = UUID.randomUUID() + "." + suffix;


            //文件名字赋值给全局
            uploadPicturename = newFileName;

            File file2 = new File(path + newFileName);
            file.transferTo(file2);

            String imgurl = file2.toString();
            System.out.println(imgurl);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //在这里上传第三次图片，是因为vue整合spring后，修改图片无法及时回显，所以上传到Totarge编译文件里
    @RequestMapping(value = "/upload03Totarget",method = RequestMethod.POST)
    public void upload03Totarget(MultipartFile file){
        System.out.println("3");
        try {
            // 获取项目根路径
            final File basePath = new File(ResourceUtils.getURL("classpath:").getPath());
            String str = basePath.toString();
            String str1 = str.substring(0, str.indexOf("target\\classes"));//截取target\classes之前的字符串


            String path = str1+"target\\classes\\static\\static\\images\\goods\\";

            File file2 = new File(path + uploadPicturename);
            file.transferTo(file2);

            String imgurl = file2.toString();
            System.out.println(imgurl);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //第4次上传文件，这个是项目前台
    @RequestMapping(value = "/upload04Tofront",method = RequestMethod.POST)
    public void upload04Tofront(MultipartFile file){
        try {
            System.out.println("4");
            // 获取项目根路径

            String path = "D:\\web\\js\\project-master\\vue\\vue_smart_project\\vue_smart_black\\static\\images\\goods\\";

            File file2 = new File(path + uploadPicturename);
            file.transferTo(file2);

            String imgurl = file2.toString();
            System.out.println(imgurl);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /*添加颜色展示图*/
    @RequestMapping("/addGoodsColor")
    public String addGoodsColor(String obj,MultipartFile file){
        Map<String, Object> map = new HashMap<String, Object>();
        /*吧前台传来的json对象解析成*/
        Goodscolor goodscolor = JSON.parseObject(obj,Goodscolor.class);

        goodscolor.setGoodscolorPicture("static/images/goods/"+uploadPicturename);
        upload(file);
        Boolean res = goodscolorService.save(goodscolor);
        map.put("res",res);
        return JSON.toJSONString(map);
    }

    /*子组件展示图添加后根基goodsId刷新用的*/
    @RequestMapping("/GoodscolorlistById")
    public String GoodscolorlistById(Long goodsId){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Goodscolor> goodscolorList = goodsService.GoodscolorlistById(goodsId);
            map.put("goodscolorList",goodscolorList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }

    //---------------------------------------------------修改和删除图片前要先删除他的上一个图片
    @RequestMapping("/delete")
    public String delete(String delete){

        try {
            /*2个vue项目的图片*/
            File file=new File("D:\\web\\js\\vue-manage-system-master\\public\\"+ delete);
            if(file.exists() && file.isFile()){
                file.delete();
            }

            File file2 = new File("D:\\web\\js\\project-master\\vue\\vue_smart_project\\vue_smart_black\\"+ delete);
            if(file2.exists() && file2.isFile()){
                file2.delete();
            }

            // 获取项目根路径
            final File basePath = new File(ResourceUtils.getURL("classpath:").getPath());
            String str = basePath.toString();
            String str1 = str.substring(0, str.indexOf("target\\classes"));//截取target\classes之前的字符串

            String path = str1+"\\src\\main\\resources\\static\\";

            File file3 = new File(path+ delete);
            if(file3.exists() && file3.isFile()){
                file3.delete();
            }


            String path2 = str1+"target\\classes\\static\\";

            File file4 = new File(path2+ delete);
            if(file4.exists() && file4.isFile()){
                file4.delete();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return "";
    }


    /*删除展示图*/
    @RequestMapping("/delGoodsColor")
    public String delGoodsColor(Long goodscolorId){
        Map<String, Object> map = new HashMap<String, Object>();
        Boolean res = goodscolorService.removeById(goodscolorId);
        map.put("res",res);
        return JSON.toJSONString(map);
    }

    /*修改展示图*/
    @RequestMapping("/updateGoodsColor")
    public String updateGoodsColor(String obj,MultipartFile file,Integer type){
        Map<String, Object> map = new HashMap<String, Object>();
        /*吧前台传来的json对象解析成*/
        Goodscolor goodscolor = JSON.parseObject(obj,Goodscolor.class);

        /*没有修改图片，就只发送一条修改语句，不做图片的上传操作*/
        if (type==1){
            goodscolor.setGoodscolorPicture("static/images/goods/"+uploadPicturename);//存到数据库的路径
            upload(file);
        }else {

        }


        Boolean res = goodscolorService.updateById(goodscolor);
        map.put("res",res);
        return JSON.toJSONString(map);
    }
}
