package com.bdqn.springboot.service.impl;

import com.bdqn.springboot.entity.OrderAddress;
import com.bdqn.springboot.dao.OrderAddressMapper;
import com.bdqn.springboot.service.OrderAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zh
 * @since 2020-02-14
 */
@Service
public class OrderAddressServiceImpl extends ServiceImpl<OrderAddressMapper, OrderAddress> implements OrderAddressService {

    @Resource
    private OrderAddressMapper orderAddressMapper;

    @Override
    public int deleteOrderAddress() throws Exception {
        return orderAddressMapper.deleteOrderAddress();
    }

    @Override
    public int insertAddress() throws Exception {
        return orderAddressMapper.insertAddress();
    }
}
