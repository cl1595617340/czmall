package com.bdqn.springboot.config;



import com.bdqn.springboot.realm.UserRealm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    /*创建DefaultWebSecurityManager对象，关联realm*/
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(UserRealm realm){
        //创建DefaultWebSecurityManager对象
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }

    /*创建ShiroFilterFactoryBean对象，设置安全设置器*/
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager){
        //创建ShiroFilterFactoryBean对象
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String,String> filterChainDefinitonMap = new LinkedHashMap<>();

        /*------放行请求----*/
        filterChainDefinitonMap.put("/admin/getAdmin","anon");

        /*------验证身份请求(必须登录才能访问的请求)----*/
      /*  filterChainDefinitonMap.put("/admin/goods/goods/**","authc");*/
       /* filterChainDefinitonMap.put("/users/sb","authc");*/

        //授予权限
        filterChainDefinitonMap.put("/users/sb","authc,perms[user:update]");
        /*==========所有请求必须经过身份验证，必须放到最后=========*/
        filterChainDefinitonMap.put("http://localhost:8080/**","authc");
        /*--设置过滤链-*/
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitonMap);

        //如果不设置会自动寻找login。jsp
        shiroFilterFactoryBean.setLoginUrl("http://localhost:8080/#/login");

        //设置无权访问后的页面
        shiroFilterFactoryBean.setUnauthorizedUrl("http://localhost:8080/#/login");
        return shiroFilterFactoryBean;

    }


    //自定义sessionManager
    @Bean
    public SessionManager sessionManager() {
        MySessionManager mySessionManager = new MySessionManager();
        return mySessionManager;
    }



    @Bean
    public UserRealm getUserRealm(){
        return new UserRealm();
    }
}
