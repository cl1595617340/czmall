package com.bdqn.springboot.controller.front.member;


import com.alibaba.fastjson.JSON;
import com.bdqn.springboot.entity.Member;
import com.bdqn.springboot.entity.Parameter;
import com.bdqn.springboot.service.MemberService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/front/goods/member")
public class MemberController {

    @Resource
    private MemberService memberService;

    /*添加会员*/
    @RequestMapping("/saveMember")
    public String saveMember(String obj){
        Map<String, Object> map = new HashMap<String, Object>();
        /*吧前台传来的json对象解析成*/
        Member member = JSON.parseObject(obj,Member.class);
        try {
            Boolean res = memberService.save(member);
            map.put("res",res);
        } catch (Exception e) {
            map.put("res",false);
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }

    /*根基名字查询用户是否已经支付宝注册过了*/
    @RequestMapping("/f_getMemByName")
    public String f_getMemByName(String name){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Member member = memberService.f_getMemByName(name);
            if (member!=null){
                map.put("member",member);
                map.put("res",true);
            }else {
                map.put("res",false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }

    /*用户登录*/
    @RequestMapping("/f_memlogin")
    public String f_memlogin(String ipone,String pwd){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Member member = memberService.f_loginmem(ipone,pwd);
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


    /*查询用户的地址*/
    @RequestMapping("/f_memAddressBuId")
    public String f_memAddressBuId(Integer id){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Member memberList = memberService.f_memAddressBuId(id);
            map.put("res",memberList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }
}
