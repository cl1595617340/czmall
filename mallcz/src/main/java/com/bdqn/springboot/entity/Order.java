package com.bdqn.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author KazuGin
 * @since 2020-01-02
 */
@TableName("orders")
public class Order implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "order_id", type = IdType.AUTO)
    private Long orderId;

    /**
     * 后台分页要的用户名字
     */
    @TableField("memberName")
    private String memberName;

    /**
     * 订单号
     */
    private String orderNum;

    /**
     * 订单金额
     */
    private Integer orderPrice;

    /**
     * 物流号
     */
    private String orderLogistics;

    /**
     * 创建时间
     */
    private String orderFound;

    /**
     * 支付时间
     */
    private String orderPaydate;

    /**
     * 支付完成时间
     */
    private String orderPayok;

    /**
     *
     */
    private Integer orderState;

    /**
     * 发票信息，默认0是个人，1是公司
     */
    private Integer orderInvoicetype;

    /**
     * 抬头
     */
    private String orderCompany;

    /**
     * 支付方法，0是支付宝，1是花呗
     */
    private Integer orderPaytype;

    /**
     * 订单的商品数量
     */
    private Integer orderCount;

    /**
     * 用户支付后处于待收货状态，默认0就是未发货，1就是已发货
     */
    private Integer order_send;

    /**
     *
     */
    @TableField("orderpayok2")
    private String orderpayok2;

    /*订单一对多的订单关系（正常情况下是一对一的关系，但是如果订单里有相同商品，颜色不同的话就查不出来）*/
    private List<OrderRelation> orderRelationList;



    public String getOrderpayok2() {
        return orderpayok2;
    }

    public void setOrderpayok2(String orderpayok2) {
        this.orderpayok2 = orderpayok2;
    }

    public Integer getOrder_send() {
        return order_send;
    }

    public void setOrder_send(Integer order_send) {
        this.order_send = order_send;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public List<OrderRelation> getOrderRelationList() {
        return orderRelationList;
    }

    public void setOrderRelationList(List<OrderRelation> orderRelationList) {
        this.orderRelationList = orderRelationList;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderLogistics() {
        return orderLogistics;
    }

    public void setOrderLogistics(String orderLogistics) {
        this.orderLogistics = orderLogistics;
    }

    public String getOrderFound() {
        return orderFound;
    }

    public void setOrderFound(String orderFound) {
        this.orderFound = orderFound;
    }

    public String getOrderPaydate() {
        return orderPaydate;
    }

    public void setOrderPaydate(String orderPaydate) {
        this.orderPaydate = orderPaydate;
    }

    public String getOrderPayok() {
        return orderPayok;
    }

    public void setOrderPayok(String orderPayok) {
        this.orderPayok = orderPayok;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Integer getOrderInvoicetype() {
        return orderInvoicetype;
    }

    public void setOrderInvoicetype(Integer orderInvoicetype) {
        this.orderInvoicetype = orderInvoicetype;
    }

    public String getOrderCompany() {
        return orderCompany;
    }

    public void setOrderCompany(String orderCompany) {
        this.orderCompany = orderCompany;
    }

    public Integer getOrderPaytype() {
        return orderPaytype;
    }

    public void setOrderPaytype(Integer orderPaytype) {
        this.orderPaytype = orderPaytype;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Order() {
    }


    public Order(Long orderId, String memberName, String orderNum, Integer orderPrice, String orderLogistics, String orderFound, String orderPaydate, String orderPayok, Integer orderState, Integer orderInvoicetype, String orderCompany, Integer orderPaytype, Integer orderCount, Integer order_send, String orderpayok2, List<OrderRelation> orderRelationList) {
        this.orderId = orderId;
        this.memberName = memberName;
        this.orderNum = orderNum;
        this.orderPrice = orderPrice;
        this.orderLogistics = orderLogistics;
        this.orderFound = orderFound;
        this.orderPaydate = orderPaydate;
        this.orderPayok = orderPayok;
        this.orderState = orderState;
        this.orderInvoicetype = orderInvoicetype;
        this.orderCompany = orderCompany;
        this.orderPaytype = orderPaytype;
        this.orderCount = orderCount;
        this.order_send = order_send;
        this.orderpayok2 = orderpayok2;
        this.orderRelationList = orderRelationList;
    }
}
