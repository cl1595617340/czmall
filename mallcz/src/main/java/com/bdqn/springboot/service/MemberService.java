package com.bdqn.springboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bdqn.springboot.entity.Address;
import com.bdqn.springboot.entity.Goods;
import com.bdqn.springboot.entity.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface MemberService extends IService<Member> {

    /*根基名字查询用户是否已经支付宝注册过了*/
    Member f_getMemByName(String name)throws Exception;

    /*登录*/
    Member f_loginmem(String ipone,String pwd)throws Exception;

    /*根基用户头像查询用户id，做添加地址用（因为只有前端avater一致）*/
    Member f_getMemIdByavatar(String avater)throws Exception;

    /*查询用户的地址*/
    Member f_memAddressBuId(Integer id)throws Exception;

    /**
     * 询查主会员列表有一对多分页
     * @return
     * @throws Exception
     */
    IPage<Member> getMemberList(Page<Member> page,Member member)throws Exception;

    /*停用和启用会员*/
    int updateMemberState(@Param("id") Long id,@Param("state") Integer state)throws Exception;
}
