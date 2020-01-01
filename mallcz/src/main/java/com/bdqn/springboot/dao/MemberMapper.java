package com.bdqn.springboot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bdqn.springboot.entity.Address;
import com.bdqn.springboot.entity.Goods;
import com.bdqn.springboot.entity.Member;
import com.bdqn.springboot.entity.Versions;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberMapper extends BaseMapper<Member> {


    /*根基名字查询用户是否已经支付宝注册过了*/
    Member f_getMemByName(String name)throws Exception;

    /*登录*/
    Member f_loginmem(String ipone)throws Exception;

    /*根基用户头像查询用户id，做添加地址用（因为只有前端avater一致）*/
    Member f_getMemIdByavatar(String avater)throws Exception;

    /*查询用户的地址*/
    Member f_memAddressBuId(Integer id)throws Exception;

    /**/
    List<Address> getaddressList(Integer id);

    /*------------------------------------------------------后端的接口------------*/
    /**
     * 询查主会员列表有一对多分页
     * @return
     * @throws Exception
     */
    IPage<Member> getMemberList(@Param("page") Page<Member> page, @Param("member") Member member)throws Exception;

    /*停用和启用会员*/
    int updateMemberState(@Param("id") Long id,@Param("state") Integer state)throws Exception;
}
