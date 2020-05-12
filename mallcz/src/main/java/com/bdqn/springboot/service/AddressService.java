package com.bdqn.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bdqn.springboot.entity.Address;
import com.bdqn.springboot.entity.Member;

public interface AddressService extends IService<Address> {

    /*用户点击默认地址，其他地址默认都修改为1*/
    Integer f_updateOtherdef(Integer id)throws Exception;

    /*用户删除地址修改状态为1*/
    int delAddress(Integer state,Integer id)throws Exception;
}
