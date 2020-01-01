package com.bdqn.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bdqn.springboot.dao.AddressMapper;
import com.bdqn.springboot.dao.MemberMapper;
import com.bdqn.springboot.entity.Address;
import com.bdqn.springboot.entity.Member;
import com.bdqn.springboot.service.AddressService;
import com.bdqn.springboot.service.MemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {


    @Resource
    private AddressMapper addressMapper;


    @Override
    public Integer f_updateOtherdef(Integer id) throws Exception {
        return addressMapper.f_updateOtherdef(id);
    }
}
