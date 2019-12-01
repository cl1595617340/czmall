package com.bdqn.springboot.controller.admin.type;


import com.alibaba.fastjson.JSON;
import com.bdqn.springboot.entity.AtreeGoods;
import com.bdqn.springboot.entity.Goodstype;
import com.bdqn.springboot.entity.Goodstype2;
import com.bdqn.springboot.entity.Goodstype3;
import com.bdqn.springboot.service.Goodstype2Service;
import com.bdqn.springboot.service.Goodstype3Service;
import com.bdqn.springboot.service.GoodstypeService;
import org.apache.commons.io.FilenameUtils;
import org.apache.lucene.util.NamedThreadFactory;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpRequest;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author KazuGin
 * @since 2019-11-24
 */

@CrossOrigin
@RestController
@RequestMapping("/admin/type/goodstype")
public class GoodstypeController {



    @Resource
    private GoodstypeService goodstypeService;

    @Resource
    private Goodstype2Service goodstype2Service;

    @Resource
    private Goodstype3Service goodstype3Service;

    /*上传的文件名字，放在全局是因为一个文件要上传2次（前台和后台），文件名字不能变*/
    private String uploadPicturename;

    @RequestMapping("/test")
    public String test(){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            List<Goodstype> goodstypes = goodstypeService.getGoodstype();
            map.put("ss",goodstypes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }


    /*3表查询分类信息*/
    @RequestMapping("/getGoodsType")
    public String getGoodsType(){
        Map<String,Object> map = new HashMap<String, Object>();
        List<AtreeGoods> atreeGoodsList = new ArrayList<AtreeGoods>();//树形数据集合

        try {
            List<Goodstype> goodstypeList = goodstypeService.getGoodstype();

            /*1级分类*/
            for (Goodstype goodstype : goodstypeList) {
                List<AtreeGoods> atreeGoodsList2 = new ArrayList<AtreeGoods>();//树形数据集合02


                AtreeGoods atreeGoods = new AtreeGoods();
                atreeGoods.setId(goodstype.getGoodstypeId());
                atreeGoods.setName(goodstype.getGoodstypeName());
                atreeGoods.setState(goodstype.getGoodstypeState());
                atreeGoods.setTypename("1级类目");

                /*2级分类*/
                for (Goodstype2 goodstype2 : goodstype.getGoodstype2()) {
                    List<AtreeGoods> atreeGoodsList3 = new ArrayList<AtreeGoods>();//树形数据集合03

                    AtreeGoods atreeGoods2 = new AtreeGoods();
                    atreeGoods2.setId(goodstype2.getGoodstype2Id());
                    atreeGoods2.setName(goodstype2.getGoodstype2Name());
                    atreeGoods2.setState(goodstype2.getGoodstype2State());
                    atreeGoods2.setTypename("2级类目");

                    atreeGoodsList2.add(atreeGoods2);//吧2级分类装进1级树形数据集合
                    atreeGoods.setChildrensb(atreeGoodsList2);

                    /*3级分类*/
                    for (Goodstype3 goodstype3 : goodstype2.getGoodstype3()) {

                        AtreeGoods atreeGoods3 = new AtreeGoods();
                        atreeGoods3.setId(goodstype3.getGoodstype3Id());
                        atreeGoods3.setName(goodstype3.getGoodstype3Name());
                        atreeGoods3.setState(goodstype3.getGoodstype3State());
                        atreeGoods3.setPicture(goodstype3.getGoodstype3Picture());
                        atreeGoods3.setTypename("3级类目");

                        atreeGoodsList3.add(atreeGoods3);//吧3级分类装进2级树形数据集合
                        atreeGoods2.setChildrensb(atreeGoodsList3);

                    }
                }

                atreeGoodsList.add(atreeGoods);//吧1级分类装进树形数据集合（最后一步）
            }

            map.put("atreeGoodsList",atreeGoodsList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }


    /*修改分类状态*/
    @RequestMapping("/updateTypestate")
    public String updateTypestate(Integer type,Long id,Integer state,String idss){
        Map<String,Object> map = new HashMap<String, Object>();
        Boolean res = null;
        try {
            if (type==1){
                Goodstype goodstype = new Goodstype();
                goodstype.setGoodstypeId(id);
                goodstype.setGoodstypeState(state);
                res = goodstypeService.updateById(goodstype);
                //1级分类修改分类状态，他下面所有状态修改
                goodstypeService.updateDescendantBy2(id,state);

                /*修改1级分类下所有的3级分类状态，要拿他所有2级分类的id，所以要用数组批量修改*/
                String[] ids = idss.split(",");//把数组里的值逗号隔开
                for (String s : ids) {
                   /* System.out.println(s);*/
                }

                Map<String,Object> map2 = new HashMap<String, Object>();
                map2.put("ids",ids);
                map2.put("state",state);
                goodstypeService.updateType3AllDescendant(map2);
            }else if (type==2){
                Goodstype2 goodstype2 = new Goodstype2();
                goodstype2.setGoodstype2Id(id);
                goodstype2.setGoodstype2State(state);
                res = goodstype2Service.updateById(goodstype2);
                //2级分类修改分类状态，他下面所有状态修改
                goodstypeService.updateDescendantBy3(id,state);
            }else {
                Goodstype3 goodstype3 = new Goodstype3();
                goodstype3.setGoodstype3Id(id);
                goodstype3.setGoodstype3State(state);
                res = goodstype3Service.updateById(goodstype3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        map.put("res",res);
        return JSON.toJSONString(map);
    }


    /*根据1级分类动态加载2级分类*/
    @RequestMapping("/getGoodsType2Byid")
    public String getGoodsType2Byid(Integer id,HttpServletRequest request){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            map.put("Goodstype2List",goodstypeService.getGoodstype2List(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }



//    ---------------------------------------------------------------------------------4次文件上传开始------------------
    /*z这里写2个上传文件的方法是因为要上传到前端项目和后端项目，方便项目开发和打包后使用（路径问题）
    * ,还有一个方法里的MultipartFile文件对象，好像不能用2次，不然会报错（找不到第二个文件上传路径）
    * */
    //这个是后台
    public void upload(MultipartFile file){
        System.out.println("2");
        try {
            // 获取项目根路径
            final File basePath = new File(ResourceUtils.getURL("classpath:").getPath());
            String str = basePath.toString();
            String str1 = str.substring(0, str.indexOf("target\\classes"));//截取target\classes之前的字符串


            String path = str1+"\\src\\main\\resources\\static\\static\\images\\goodstype3\\";

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
            // 获取项目根路径
            final File basePath = new File(ResourceUtils.getURL("classpath:").getPath());
            String str = basePath.toString();
            String str1 = str.substring(0, str.indexOf("target\\classes"));//截取target\classes之前的字符串


            String path = "D:\\web\\js\\vue-manage-system-master\\public\\static\\images\\goodstype3\\";
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


            String path = str1+"target\\classes\\static\\static\\images\\goodstype3\\";

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

            String path = "D:\\web\\js\\project-master\\vue\\vue_smart_project\\vue_smart_black\\static\\images\\goodstype3\\";

            File file2 = new File(path + uploadPicturename);
            file.transferTo(file2);

            String imgurl = file2.toString();
            System.out.println(imgurl);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 添加类目（）
     * @param file 3级分类上传图片
     * @param type 判断新增的类目级别
     * @param name 新增的类目名字
     * @param sid 新增的类目外键
     * @return
     */
    @RequestMapping(value = "/addType",method = RequestMethod.POST)
    public String addType(MultipartFile file,Integer type,String name,Long sid){
        Map<String,Object> map = new HashMap<String, Object>();
        Boolean res=null;

        if (type==1) {
            Goodstype goodstype = new Goodstype();
            goodstype.setGoodstypeName(name);
            res = goodstypeService.save(goodstype);
        }else if (type==2){
            Goodstype2 goodstype2 = new Goodstype2();
            goodstype2.setGoodstype2Name(name);
            goodstype2.setGoodstypeId(sid);
            res = goodstype2Service.save(goodstype2);
        }else {
            Goodstype3 goodstype3 = new Goodstype3();
            goodstype3.setGoodstype3Name(name);
            goodstype3.setGoodstype2Id(sid);

            goodstype3.setGoodstype3Picture("static/images/goodstype3/"+uploadPicturename);//存到数据库的路径
            upload(file);
            res = goodstype3Service.save(goodstype3);
        }
        map.put("res",res);
        return JSON.toJSONString(map);
    }


    /*根基2级分类id查询1级分类信息*/
    @RequestMapping("/getGoodstypeBy2")
    public String getGoodstypeBy2(Integer id){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            Goodstype goodstype = goodstypeService.getGoodstypeBy2(id);
            map.put("goodstype",goodstype);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }


    /*根基3级分类id查询2级分类信息*/
    @RequestMapping("/getGoodstype2By3")
    public String getGoodstype2By3(Integer id){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
           Goodstype2 goodstype2 = goodstypeService.getGoodstype2By3(id);
            map.put("goodstype2",goodstype2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }

    /*修改分类信息*/
    @RequestMapping(value = "/updateType",method = RequestMethod.POST)
    public String updateType(Integer type,String name,Long id,MultipartFile file,Long sid){
        Map<String,Object> map = new HashMap<String, Object>();
        Boolean res=null;

        if (type==1) {
            Goodstype goodstype = new Goodstype();
            goodstype.setGoodstypeName(name);
            goodstype.setGoodstypeId(id);
            res = goodstypeService.updateById(goodstype);

        }else if (type==2){
            Goodstype2 goodstype2 = new Goodstype2();
            goodstype2.setGoodstype2Name(name);
            goodstype2.setGoodstype2Id(id);//主键id
            goodstype2.setGoodstypeId(sid);//外键id
            res = goodstype2Service.updateById(goodstype2);
        }else {
            Goodstype3 goodstype3 = new Goodstype3();
            goodstype3.setGoodstype3Name(name);
            goodstype3.setGoodstype3Id(id);
            goodstype3.setGoodstype2Id(sid);

            if (file!=null){
                goodstype3.setGoodstype3Picture("static/images/goodstype3/"+uploadPicturename);//存到数据库的路径
                upload(file);
            }else {
                /*goodstype3.setGoodstype3Picture("");//存到数据库的路径*/
            }
            res = goodstype3Service.updateById(goodstype3);

        }
        map.put("res",res);
        return JSON.toJSONString(map);
    }



    //修改图片前要先删除他的上一个图片
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
}

