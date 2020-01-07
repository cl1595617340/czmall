package com.bdqn.springboot.controller.admin.generalize;


import com.alibaba.fastjson.JSON;
import com.bdqn.springboot.entity.Generalize;
import com.bdqn.springboot.entity.GeneralizeRelation;
import com.bdqn.springboot.entity.Goods;
import com.bdqn.springboot.entity.Member;
import com.bdqn.springboot.service.GeneralizeRelationService;
import com.bdqn.springboot.service.GeneralizeService;
import com.bdqn.springboot.service.GoodsService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/admin/generalize/generalize")
public class GeneralizeControllers {

    @Resource
    private GeneralizeService generalizeService;

    @Resource
    private GeneralizeRelationService generalizeRelationService;

    @Resource
    private GoodsService goodsService;

    /*得到所有的专区*/
    @RequestMapping("/getAllgeneralize")
    public String getAllgeneralize(){
        Map<String, Object> map = new HashMap<String, Object>();
        List<Generalize> generalizeList = generalizeService.list();

        //得到所有的商品名字
        List<Goods> goodsList = goodsService.list();
        map.put("res",generalizeList);
        map.put("goodsList",goodsList);
        return JSON.toJSONString(map);
    }

    /*根基专区id得到旗下的商品*/
    @RequestMapping("/getGeneralizeById")
    public String getGeneralizeById(Long ID){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Generalize generalize = generalizeService.getGeneralizeById(ID);
            if (generalize!=null){
                map.put("res",generalize);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }

    public String upload(MultipartFile file){
        String newFileName="";
        try {
            System.out.println("1");

            String path = "D:\\nginx\\nginx-1.12.2\\html\\static\\static\\images\\generalize\\";
            String oldFileName = file.getOriginalFilename();


            String suffix = FilenameUtils.getExtension(oldFileName);
            //加密后的文件新名字
            newFileName = UUID.randomUUID() + "." + suffix;



            File file2 = new File(path + newFileName);
            file.transferTo(file2);

            String imgurl = file2.toString();
            System.out.println(imgurl);


        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFileName;
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

    /*修改专区关系的大小图*/
    @RequestMapping("/updateGeneralizerelation")
    public String updateGeneralizerelation(String obj,MultipartFile file,Integer type){
        Map<String, Object> map = new HashMap<String, Object>();
        /*吧前台传来的json对象解析成*/
        GeneralizeRelation generalizeRelation = JSON.parseObject(obj,GeneralizeRelation.class);

        /*没有修改图片，就只发送一条修改语句，不做图片的上传操作*/
        if (type==1){
            String newFileName =  upload(file);
            generalizeRelation.setGeneralizeGoodsImg("http://localhost:8070/static/images/generalize/"+newFileName);

        }else {

        }

        Boolean res = generalizeRelationService.updateById(generalizeRelation);
        map.put("res",res);
        return JSON.toJSONString(map);
    }



    /*添加专区的关系*/
    @RequestMapping("/addGeneralizerelation")
    public String addGeneralizerelation(String obj,MultipartFile file,Integer type){
        Map<String, Object> map = new HashMap<String, Object>();
        /*吧前台传来的json对象解析成*/
        GeneralizeRelation generalizeRelation = JSON.parseObject(obj,GeneralizeRelation.class);

        //type==1就是有大图
        if (type==1){
            String newFileName =  upload(file);
            generalizeRelation.setGeneralizeGoodsImg("http://localhost:8070/static/images/generalize/"+newFileName);
            generalizeRelation.setGeneralize_type(1);
        }else {
            generalizeRelation.setGeneralize_type(0);
        }
        Boolean res = generalizeRelationService.save(generalizeRelation);
        map.put("res",res);
        return JSON.toJSONString(map);
    }


    /*删除专区旗下的商品*/
    @RequestMapping("/delGeneralizeGoods")
    public String delGeneralizeGoods(Long id){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Boolean res = generalizeRelationService.removeById(id);
            map.put("res",res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }



    /*添加专区*/
    @RequestMapping("/addGeneralize")
    public String addGeneralize(String obj){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            /*吧前台传来的json对象解析成*/
            Generalize generalize = JSON.parseObject(obj,Generalize.class);
            Boolean res = generalizeService.save(generalize);
            map.put("res",res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }

    /*修改专区*/
    @RequestMapping("/updateGeneralize")
    public String updateGeneralize(String obj){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            /*吧前台传来的json对象解析成*/
            Generalize generalize = JSON.parseObject(obj,Generalize.class);
            Boolean res = generalizeService.updateById(generalize);
            map.put("res",res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }

    /*停用和启用专区*/
    @RequestMapping("/updateGeneralizeState")
    public String updateGeneralizeState(Long id,Integer state){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            int res = generalizeService.updateGeneralizeState(id,state);
            if (res!=0){
                map.put("res", true);
            }else{
                map.put("res", false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }

}
