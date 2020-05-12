package com.bdqn.springboot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bdqn.springboot.entity.Address;
import com.bdqn.springboot.entity.Goodscolor;
import com.bdqn.springboot.entity.Member;
import org.apache.ibatis.annotations.Param;

public interface AddressMapper extends BaseMapper<Address> {


    /*用户点击默认地址，其他地址默认都修改为1*/
    Integer f_updateOtherdef(@Param("id") Integer id)throws Exception;

    /*用户删除地址修改状态为1*/
    int delAddress(@Param("state")Integer state,@Param("id")Integer id)throws Exception;
}
