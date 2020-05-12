package com.bdqn.springboot.realm;


import com.bdqn.springboot.entity.TAdmin;
import com.bdqn.springboot.service.TAdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;


public class UserRealm extends AuthorizingRealm {


    @Resource
    private TAdminService tAdminService;

    //权限验证
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
       /* String name = (String) principals.getPrimaryPrincipal();//得到用户名


        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        try {
            //赋予角色
            simpleAuthorizationInfo.setRoles(userService.getUserRole(name));
            //赋予角色权限
            simpleAuthorizationInfo.setStringPermissions(userService.getUserRolePer(name));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return simpleAuthorizationInfo;*/
        return null;
    }



    //角色验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String name = (String) token.getPrincipal();//得到用户名

        //调用登录的方法
        try {
            TAdmin admin = tAdminService.getAdminByName(name);
            if (admin!=null){
                //验证用户名和密码
                AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(admin.getAdminName(),admin.getAdminPwd(),"");
                return authenticationInfo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
