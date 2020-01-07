package com.bdqn.springboot.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bdqn.springboot.entity.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author KazuGin
 * @since 2020-01-02
 */
public interface OrderMapper extends BaseMapper<Order> {


    /*根据订单编号查询订单，做添加订单编号用*/
    Order f_getOrderIdBynum(String num)throws Exception;

    /*前端查询会员的订单，7表联查*/
    List<Order> f_memOrderList(Map<String,Object> map)throws Exception;

    /*根基订单id查询订单详细数据*/
    Order f_getOrderInfo(Long id)throws Exception;

    /*修改订单状态*/
    int f_updateOrderState(@Param("id")Long id,@Param("state")Long state)throws Exception;

    /*用户确实收货，修改完成时间 */
    int f_updatePayOkDate(@Param("id")Long id,@Param("dates")String dates)throws Exception;


    /*用户成功支付后，修改他订单的支付时间 */
    int f_updatePayok(@Param("id")Long id,@Param("dateok")String dateok)throws Exception;

    /*修改订单的支付方式（花呗，支付宝）*/
    int f_updatePayType(@Param("id")Long id,@Param("type")Integer type)throws Exception;
    /*-0-------------------------------------------------------后台方法--*/
    /**
     * 询查订单列表有一对多分页
     * @return
     * @throws Exception
     */
    IPage<Order> getOrderList(@Param("page") Page<Order> page, @Param("orders") Order order)throws Exception;

    /**/
    List<OrderRelation> getOrderRelationList(Integer id);

    /*修改状态位待收货，就是1，的发货状态为发货*/
    int updateOrderSend(Integer id)throws Exception;
}
