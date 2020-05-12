package com.bdqn.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zh
 * @since 2020-02-14
 */
@TableName("order_address")
public class OrderAddress implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "order_address_id", type = IdType.AUTO)
    private Long orderAddressId;

    /**
     * 收货地址对应的会员
     */
    @TableField("memberId")
    private Long memberId;

    /**
     * 收货人名字
     */
    @TableField("addressName")
    private String addressName;

    /**
     * 收货人电话
     */
    @TableField("addressIpone")
    private String addressIpone;

    @TableField("provinceId")
    private Integer provinceId;

    /**
     * 收货地址-省份
     */
    @TableField("addressProvince")
    private String addressProvince;

    @TableField("cityId")
    private Integer cityId;

    /**
     * 收货地址-市
     */
    @TableField("addressCity")
    private String addressCity;

    @TableField("countyId")
    private Integer countyId;

    /**
     * 收货地址-县
     */
    @TableField("addressCounty")
    private String addressCounty;

    /**
     * 详细地址
     */
    private String addressinfo;

    /**
     * 收货地址是否默认，0默认，1不是
     */
    @TableField("addressDefault")
    private Integer addressDefault;


    public Long getOrderAddressId() {
        return orderAddressId;
    }

    public void setOrderAddressId(Long orderAddressId) {
        this.orderAddressId = orderAddressId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getAddressIpone() {
        return addressIpone;
    }

    public void setAddressIpone(String addressIpone) {
        this.addressIpone = addressIpone;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getAddressProvince() {
        return addressProvince;
    }

    public void setAddressProvince(String addressProvince) {
        this.addressProvince = addressProvince;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public Integer getCountyId() {
        return countyId;
    }

    public void setCountyId(Integer countyId) {
        this.countyId = countyId;
    }

    public String getAddressCounty() {
        return addressCounty;
    }

    public void setAddressCounty(String addressCounty) {
        this.addressCounty = addressCounty;
    }

    public String getAddressinfo() {
        return addressinfo;
    }

    public void setAddressinfo(String addressinfo) {
        this.addressinfo = addressinfo;
    }

    public Integer getAddressDefault() {
        return addressDefault;
    }

    public void setAddressDefault(Integer addressDefault) {
        this.addressDefault = addressDefault;
    }

    @Override
    public String toString() {
        return "OrderAddress{" +
        "orderAddressId=" + orderAddressId +
        ", memberId=" + memberId +
        ", addressName=" + addressName +
        ", addressIpone=" + addressIpone +
        ", provinceId=" + provinceId +
        ", addressProvince=" + addressProvince +
        ", cityId=" + cityId +
        ", addressCity=" + addressCity +
        ", countyId=" + countyId +
        ", addressCounty=" + addressCounty +
        ", addressinfo=" + addressinfo +
        ", addressDefault=" + addressDefault +
        "}";
    }
}
