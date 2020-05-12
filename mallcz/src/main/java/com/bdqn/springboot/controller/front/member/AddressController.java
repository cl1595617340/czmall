package com.bdqn.springboot.controller.front.member;


import com.alibaba.fastjson.JSON;
import com.bdqn.springboot.entity.Address;
import com.bdqn.springboot.entity.Member;
import com.bdqn.springboot.service.AddressService;
import com.bdqn.springboot.service.MemberService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/front/goods/address")
public class AddressController {

    @Resource
    private AddressService addressService;

    @Resource
    private MemberService memberService;

    /*添加会员地址*/
    @RequestMapping("/addAddress")
    public String addAddress(String obj){
        Map<String, Object> map = new HashMap<String, Object>();
        /*吧前台传来的json对象解析成*/
        Address address = JSON.parseObject(obj,Address.class);
        try {
            Boolean res = addressService.save(address);
            map.put("res",res);
        } catch (Exception e) {
            map.put("res",false);
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }

    /*根基用户头像查询用户id，做添加地址用（因为只有前端avater一致）*/
    @RequestMapping("/f_getMemIdByavatar")
    public String f_getMemIdByavatar(String avater){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Member member = memberService.f_getMemIdByavatar(avater);
            if (member!=null){
                map.put("res",member);
            }else {
                map.put("res",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }


    /*用户点击默认地址，其他地址默认都修改为1*/
    @RequestMapping("/f_updateOtherdef")
    public String f_updateOtherdef(Integer id){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            int res = addressService.f_updateOtherdef(id);
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


    /*删除地址*/
    @RequestMapping("/delAddress")
    public String delAddress(Integer state,Integer id){
        Map<String, Object> map = new HashMap<String, Object>();
        int res = 0;
        try {
            res = addressService.delAddress(state,id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("res",res);
        return JSON.toJSONString(map);
    }

    /*修改地址*/
    @RequestMapping("/updateAddress")
    public String updateAddress(String obj){
        Map<String, Object> map = new HashMap<String, Object>();
        /*吧前台传来的json对象解析成*/
        Address address = JSON.parseObject(obj,Address.class);

        Boolean res = addressService.updateById(address);
        map.put("res",res);
        return JSON.toJSONString(map);
    }
}
