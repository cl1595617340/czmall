package com.bdqn.springboot.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bdqn.springboot.entity.Member;
import com.bdqn.springboot.entity.Order;
import com.bdqn.springboot.dao.OrderMapper;
import com.bdqn.springboot.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author KazuGin
 * @since 2020-01-02
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public Order f_getOrderIdBynum(String num) throws Exception {
        return orderMapper.f_getOrderIdBynum(num);
    }

    @Override
    public List<Order> f_memOrderList(Map<String, Object> map) throws Exception {
        return orderMapper.f_memOrderList(map);
    }

    @Override
    public Order f_getOrderInfo(Long id) throws Exception {
        return orderMapper.f_getOrderInfo(id);
    }

    @Override
    public int f_updateOrderState(Long id,Long state) throws Exception {
        return orderMapper.f_updateOrderState(id,state);
    }

    @Override
    public int f_updatePayOkDate(Long id, String dates) throws Exception {
        return orderMapper.f_updatePayOkDate(id,dates);
    }

    @Override
    public int f_updatePayok(Long id, String dateok) throws Exception {
        return orderMapper.f_updatePayok(id,dateok);
    }

    @Override
    public int f_updatePayType(Long id, Integer type) throws Exception {
        return orderMapper.f_updatePayType(id,type);
    }

    /**
     * 询查订单列表有一对多分页
     *
     * @param page
     * @param order
     * @return
     * @throws Exception
     */
    @Override
    public IPage<Order> getOrderList(Page<Order> page, Order order) throws Exception {
        return orderMapper.getOrderList(page,order);
    }

    @Override
    public int updateOrderSend(Integer id) throws Exception {
        return orderMapper.updateOrderSend(id);
    }
}
