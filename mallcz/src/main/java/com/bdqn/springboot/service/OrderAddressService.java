package com.bdqn.springboot.service;

import com.bdqn.springboot.entity.OrderAddress;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zh
 * @since 2020-02-14
 */
public interface OrderAddressService extends IService<OrderAddress> {
    //先删除订单地址表里的1所有数据,再从地址表里复制全部数据
    int deleteOrderAddress()throws Exception;


    int insertAddress()throws Exception;
}
