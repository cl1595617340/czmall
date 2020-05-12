package com.bdqn.springboot.controller.admin;


import com.alibaba.fastjson.JSON;
import com.bdqn.springboot.entity.TAdmin;
import com.bdqn.springboot.service.TAdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {


    @Resource
    private TAdminService tAdminService;


   /* public static void sb(HttpSession session){
        session.setAttribute("admin", "adminsb");
    }


    @RequestMapping("/getUser")
    public String getUser(HttpSession session){
        AdminController.sb(session);
        Map<String,Object> map = new HashMap<String, Object>();
        String amidn = (String) session.getAttribute("admin");
        map.put("admin",amidn);
        return JSON.toJSONString(map);
    }*/


    @RequestMapping("/getAdmin")
    public String getAdmin(TAdmin admin){
        Map<String,Object> map = new HashMap<String, Object>();

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(admin.getAdminName(), admin.getAdminPwd());

        try {
            //登录
            subject.login(token);
          /*  String amidn = (String) session.getAttribute("admin");*/
            map.put("token", subject.getSession().getId());
            TAdmin admin1 = tAdminService.getAdminByName(admin.getAdminName());
          /*  //保存session
            Session session = subject.getSession();
            session.setAttribute("admin", admin1);*/

            map.put("res",admin1);
            return JSON.toJSONString(map);

        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString(map);
        }
    }
}
