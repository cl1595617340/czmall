package com.bdqn.springboot.controller.admin.order;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bdqn.springboot.entity.Member;
import com.bdqn.springboot.entity.Order;
import com.bdqn.springboot.entity.inputSearch.InputSearch;
import com.bdqn.springboot.service.OrderRelationService;
import com.bdqn.springboot.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/admin/order/order")
public class OrderControllers {

    @Resource
    private OrderService orderService;

    @Resource
    private OrderRelationService orderRelationService;


    @RequestMapping(value = "/getorderlist", method = RequestMethod.POST)
    public String productList(String newobj,
                              @RequestParam(value = "page",defaultValue = "1")Long current,
                              @RequestParam(value = "size",defaultValue = "5")Long size
    ){
        Map<String,Object> map = new HashMap<String, Object>();

        //调用方法
        try {
            /*吧前台传来的json对象解析成*/
            Order order = JSON.parseObject(newobj,Order.class);

            //创建分页对象，指定当前页码及每页显示数量
            Page<Order> page = new Page<Order>(current,size);

            //分页查询
            IPage<Order> blogIPage = orderService.getOrderList(page,order);

            //获取数据列表
            List<Order> orderList = blogIPage.getRecords();

            for (Order order1 : orderList) {
                if (order1.getOrderPaydate()==null||order1.getOrderPaydate().equals("")){
                    order1.setOrderPaydate("暂无");
                }
                if (order1.getOrderPayok()==null||order1.getOrderPayok().equals("")){
                    order1.setOrderPayok("暂无");
                }
            }

            map.put("data", orderList);
            map.put("page", page);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);
    }

    /*修改状态位待收货，就是1，的发货状态为发货*/
    @RequestMapping("/updateOrderSend")
    public String updateOrderSend(Integer id){
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            int res = orderService.updateOrderSend(id);
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
