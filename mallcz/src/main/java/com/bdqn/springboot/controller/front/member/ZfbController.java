package com.bdqn.springboot.controller.front.member;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.bdqn.springboot.config.AlipayConfig;
import com.bdqn.springboot.config.AlipaySubmit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600,allowCredentials = "true")
@Controller
public class ZfbController {


    Map<String,Object> mapzfb = new HashMap<String, Object>();
    /**
     *  跳转到授权界面
     */
    @RequestMapping(value = "zhifubao")
    public String save() {
        Map<String,String> maps = new HashMap<String ,String>();
        //页面回调地址 必须与应用中的设置一样
        String return_url = "http://169.254.63.227:8088/zfbLogin";
        //回调地址必须经encode
        return_url = java.net.URLEncoder.encode(return_url);
        //重定向到授权页面
        return "redirect:"+AlipayConfig.ALIPAY_URL+"?app_id=" + AlipayConfig.APP_ID + "&scope=auth_user&redirect_uri=" + return_url;

    }

    /**
     * 获取用户信息
     * @param request
     * @param response
     */

    /*@ResponseBody*/
    @RequestMapping(value = "zfbLogin")
    public String returnImf(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        //获取支付宝GET过来反馈信息
        Map<String,String> params = new HashMap<String,String>();


        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == (values.length-1)) ? valueStr + values[i]:valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }

        String accessToken= AlipaySubmit.buildRequest(params);
        AlipayUserInfoShareResponse imf = null;
        if(accessToken!=null && accessToken!=""){
            imf  =  AlipaySubmit.get(accessToken);

            System.out.println(imf);
        }
        mapzfb.put("sb",imf);
      /*  session.setAttribute("imf", imf);*/
        /*  model.addAttribute("zfb",JSON.toJSONString(mapzfb));*/
        return "redirect:http://localhost:8080/#/memUser";

    }


    @ResponseBody
    @RequestMapping(value = "/sbzfb")
    public String sbzfb(HttpSession session){

        return JSON.toJSONString(mapzfb);
    }





}
