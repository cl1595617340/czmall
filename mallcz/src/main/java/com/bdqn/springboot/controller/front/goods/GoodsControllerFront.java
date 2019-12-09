package com.bdqn.springboot.controller.front.goods;


import com.alibaba.fastjson.JSON;
import com.bdqn.springboot.entity.Goods;
import com.bdqn.springboot.entity.Goodstype3;
import com.bdqn.springboot.entity.Versions;
import com.bdqn.springboot.entity.queryList.QueryList;
import com.bdqn.springboot.service.GoodsService;
import com.bdqn.springboot.service.Goodstype3Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin
@RestController
@RequestMapping("/front/goods/goods")
public class GoodsControllerFront {

    @Resource
    private GoodsService goodsService;


    @Resource
    private Goodstype3Service goodstype3Service;

    /*主页分类显示所有手机*/
    @RequestMapping("/f_getGoodsListToType")
    public String f_getGoodsListToType(String obj,Integer endGoodsid){
        Map<String,Object> map = new HashMap<String, Object>();

        QueryList queryList = null;
        if (obj!=null){
            /*吧前台传来的json对象解析成*/
            queryList = JSON.parseObject(obj,QueryList.class);
        }

        try {
            //装物品id的集合,发送给前台的数据数量是由物品id数量决定的(endGoodsid),相当于分页的分页数量
            List<Integer> integerList = new ArrayList<>();
            List<Goods> goodsListid = goodsService.page_getGoodsID(0,endGoodsid);

            for (Goods goods : goodsListid) {
                integerList.add(goods.getGoodsId().intValue());
            }

            int sum = 0;//分页的总数
            //根据物品的id得到记录数并且像加
            for (Integer integer : integerList) {
                sum+=goodsService.page_getGoodsSum(integer);
            }

            /*System.out.println(sum);*/

            queryList.setStatrPage(0);
            queryList.setEndPage(sum);
            List<Goods> goodsList = goodsService.f_getGoodsListToType(queryList);
            map.put("goodsList",goodsList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return JSON.toJSONString(map);
    }

    /*主页的搜索框模糊查询*/
    @RequestMapping("/getType3AndGoods")
    public String f_getType3AndGoods(String name){
        Map<String,Object> map = new HashMap<String, Object>();

        try {
            List<Goodstype3> goodstype3List = goodstype3Service.f_getType3AndGoods(name);
            map.put("goodstype3List",goodstype3List);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return JSON.toJSONString(map);
    }


    /*主页的模糊查询*/
    @RequestMapping("/f_likeGetGoods")
    public String f_likeGetGoods(String name,String type){
        Map<String,Object> map = new HashMap<String, Object>();

        try {
            List<Goods> goodsList = goodsService.f_likeGetGoods(name,type);
            map.put("goodsList",goodsList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }

    /*主页的大模糊查询取反，主要查询除了手机分类的数据*/
    @RequestMapping("/f_likeGetGoodsNot")
    public String f_likeGetGoodsNot(String name,String type){
        Map<String,Object> map = new HashMap<String, Object>();

        try {
            List<Goods> goodsList = goodsService.f_likeGetGoodsNot(name,type);
            map.put("goodsList",goodsList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }
}
