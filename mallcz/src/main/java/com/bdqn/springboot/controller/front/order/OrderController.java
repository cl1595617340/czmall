package com.bdqn.springboot.controller.front.order;


import com.alibaba.fastjson.JSON;
import com.bdqn.springboot.entity.Address;
import com.bdqn.springboot.entity.Order;
import com.bdqn.springboot.entity.OrderRelation;
import com.bdqn.springboot.service.OrderRelationService;
import com.bdqn.springboot.service.OrderService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author KazuGin
 * @since 2020-01-02
 */
@CrossOrigin
@RestController
@RequestMapping("/front/order/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private OrderRelationService orderRelationService;

    /*添加订单*/
    @RequestMapping("/addOrder")
    public String addOrder(String obj){
        Map<String, Object> map = new HashMap<String, Object>();
        /*吧前台传来的json对象解析成*/
        Order order = JSON.parseObject(obj,Order.class);
        //添加订单
        Boolean res = orderService.save(order);
        //添加订单关系
        map.put("res",res);
        return JSON.toJSONString(map);
    }

    /*添加订单关系*/
    @RequestMapping("/addOrderRelation")
    public String addOrderRelation(String obj){
        Map<String, Object> map = new HashMap<String, Object>();
        /*吧前台传来的json对象解析成*/
        OrderRelation orderRelation = JSON.parseObject(obj,OrderRelation.class);
        Boolean res = orderRelationService.save(orderRelation);
        map.put("res",res);
        return JSON.toJSONString(map);
    }

    /*根据订单编号查询订单，做添加订单编号用*/
    @RequestMapping("/f_getOrderIdBynum")
    public String f_getOrderIdBynum(String num){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Order order = orderService.f_getOrderIdBynum(num);
            map.put("res",order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }

    /*前端查询会员的订单，7表联查*/
    @RequestMapping("/f_memOrderList")
    public String f_memOrderList(Long id,Long state){
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("memberId",id);
        map2.put("state",state);
        try {
            List<Order> orderList = orderService.f_memOrderList(map2);
            map.put("res",orderList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }


    /*根基订单id查询订单详细数据*/
    @RequestMapping("/f_getOrderInfo")
    public String f_getOrderInfo(Long id){
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            Order order = orderService.f_getOrderInfo(id);
            map.put("res",order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }

    /*修改订单状态*/
    @RequestMapping("/f_updateOrderState")
    public String f_updateOrderState(Long id,Long state){
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            int res = orderService.f_updateOrderState(id,state);
            if (res!=0){
                map.put("res",true);
            }else{
                map.put("res",false);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }

    /*用户确实收货，修改完成时间*/
    @RequestMapping("/f_updatePayOkDate")
    public String f_updatePayOkDate(Long id,String dates){
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            int res = orderService.f_updatePayOkDate(id,dates);
            if (res!=0){
                map.put("res",true);
            }else{
                map.put("res",false);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }


    /*用户成功支付后，修改他订单的支付时间*/
    @RequestMapping("/f_updatePayok")
    public String f_updatePayok(Long id,String dateok){
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            int res = orderService.f_updatePayok(id,dateok);
            if (res!=0){
                map.put("res",true);
            }else{
                map.put("res",false);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }



    /*修改订单的支付方式（花呗，支付宝）*/
    @RequestMapping("/f_updatePayType")
    public String f_updatePayType(Long id,Integer type){
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            int res = orderService.f_updatePayType(id,type);
            if (res!=0){
                map.put("res",true);
            }else{
                map.put("res",false);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }
}

