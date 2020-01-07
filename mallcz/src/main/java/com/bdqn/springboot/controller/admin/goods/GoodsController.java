package com.bdqn.springboot.controller.admin.goods;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bdqn.springboot.entity.*;
import com.bdqn.springboot.entity.inputSearch.InputSearch;
import com.bdqn.springboot.service.*;
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


    @Resource
    private ParameterService parameterService;

    /*上传的文件名字，放在全局是因为一个文件要上传4次（前台和后台），文件名字不能变*/
    private String uploadPicturename;


    /*询查主列表有分页*/
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



    public String upload(MultipartFile file){
        String newFileName="";
        try {
            System.out.println("1");

            String path = "D:\\nginx\\nginx-1.12.2\\html\\static\\static\\images\\goods\\";
            String oldFileName = file.getOriginalFilename();


            String suffix = FilenameUtils.getExtension(oldFileName);
            //加密后的文件新名字
            newFileName = UUID.randomUUID() + "." + suffix;


            //文件名字赋值给全局
            uploadPicturename = newFileName;

            File file2 = new File(path + newFileName);
            file.transferTo(file2);

            String imgurl = file2.toString();
            System.out.println(imgurl);


        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFileName;
    }



    /*添加颜色展示图*/
    @RequestMapping("/addGoodsColor")
    public String addGoodsColor(String obj,MultipartFile file){
        Map<String, Object> map = new HashMap<String, Object>();
        /*吧前台传来的json对象解析成*/
        Goodscolor goodscolor = JSON.parseObject(obj,Goodscolor.class);

        String newFileName =  upload(file);
        goodscolor.setGoodscolorPicture("http://localhost:8070/static/images/goods/"+newFileName);
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
            String removerstr = "http://localhost:8070/";
            String imgstr = delete.replace(removerstr,"");
            File file=new File("D:\\nginx\\nginx-1.12.2\\html\\static\\"+ imgstr);
            if(file.exists() && file.isFile()){
                file.delete();
            }

        } catch (Exception e) {
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
            String newFileName =  upload(file);
            goodscolor.setGoodscolorPicture("http://localhost:8070/static/images/goods/"+newFileName);
        }else {

        }

        Boolean res = goodscolorService.updateById(goodscolor);
        map.put("res",res);
        return JSON.toJSONString(map);
    }

    /*----------------------------------------------------------------参数操作-----*/
    /*修改参数*/
    @RequestMapping("/updateParameter")
    public String updateParameter(String obj){
        Map<String, Object> map = new HashMap<String, Object>();
        /*吧前台传来的json对象解析成*/
        Parameter parameter = JSON.parseObject(obj,Parameter.class);

        try {
            Boolean res = parameterService.updateById(parameter);
            map.put("res",res);
        } catch (Exception e) {
            map.put("res",false);
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }

    /*添加参数*/
    @RequestMapping("/addParameter")
    public String addParameter(String obj){
        Map<String, Object> map = new HashMap<String, Object>();
        /*吧前台传来的json对象解析成*/
        Parameter parameter = JSON.parseObject(obj,Parameter.class);

        try {
            Boolean res = parameterService.save(parameter);
            map.put("res",res);
        } catch (Exception e) {
            map.put("res",false);
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }




    //这个是前台（第二个重新写个控制器，因为MultipartFile文件对象，好像不能用2次）
    @RequestMapping(value = "/mdupload02",method = RequestMethod.POST)
    public String mdupload02(MultipartFile file,String name){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            System.out.println("1");

            String path = "D:\\nginx\\nginx-1.12.2\\html\\static\\static\\images\\goodsinfo\\";
            String oldFileName = file.getOriginalFilename();

            File file2 = new File(path + oldFileName);
            file.transferTo(file2);

            String imgurl = file2.toString();
            System.out.println(imgurl);

            map.put("oldFileName",oldFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }




    /*---------------------------------------修改商品的基本信息--*/
    @RequestMapping("/updateGoods")
    public String updateGoods(String obj){
        Map<String, Object> map = new HashMap<String, Object>();
        /*吧前台传来的json对象解析成*/
        Goods goods = JSON.parseObject(obj,Goods.class);
        try {
            Boolean res = goodsService.updateById(goods);
            map.put("res",res);
        } catch (Exception e) {
            map.put("res",false);
            e.printStackTrace();
        }

        return JSON.toJSONString(map);

    }

    /*---------------------------------------添加商品的基本信息--*/
    @RequestMapping("/addGoods")
    public String addGoods(String obj){
        Map<String, Object> map = new HashMap<String, Object>();
        /*吧前台传来的json对象解析成*/
        Goods goods = JSON.parseObject(obj,Goods.class);
        goods.setGoods_create(new Date());
        try {
            Boolean res = goodsService.save(goods);
            map.put("res",res);
        } catch (Exception e) {
            map.put("res",false);
            e.printStackTrace();
        }

        return JSON.toJSONString(map);
    }
}
