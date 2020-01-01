package com.bdqn.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("address")
public class Address {

    @TableId(value = "addressId", type = IdType.AUTO)
    private Integer addressId;
    @TableField("memberId")
    private Integer memberId;
    @TableField("addressName")
    private String addressName;
    @TableField("addressIpone")
    private String addressIpone;
    @TableField("addressProvince")
    private String addressProvince;
    @TableField("addressCity")
    private String addressCity;
    @TableField("addressCounty")
    private String addressCounty;
    @TableField("addressDefault")
    private Integer addressDefault;

    @TableField("addressinfo")
    private String addressinfo;

    /*前端回显修改的地区id*/
    @TableField("provinceId")
    private Integer provinceId;
    @TableField("cityId")
    private Integer cityId;
    @TableField("countyId")
    private Integer countyId;

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getCountyId() {
        return countyId;
    }

    public void setCountyId(Integer countyId) {
        this.countyId = countyId;
    }

    public Address(Integer addressId, Integer memberId, String addressName, String addressIpone, String addressProvince, String addressCity, String addressCounty, Integer addressDefault, String addressinfo) {
        this.addressId = addressId;
        this.memberId = memberId;
        this.addressName = addressName;
        this.addressIpone = addressIpone;
        this.addressProvince = addressProvince;
        this.addressCity = addressCity;
        this.addressCounty = addressCounty;
        this.addressDefault = addressDefault;
        this.addressinfo = addressinfo;
    }


    public Address() {
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
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

    public String getAddressProvince() {
        return addressProvince;
    }

    public void setAddressProvince(String addressProvince) {
        this.addressProvince = addressProvince;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressCounty() {
        return addressCounty;
    }

    public void setAddressCounty(String addressCounty) {
        this.addressCounty = addressCounty;
    }

    public Integer getAddressDefault() {
        return addressDefault;
    }

    public void setAddressDefault(Integer addressDefault) {
        this.addressDefault = addressDefault;
    }

    public String getAddressinfo() {
        return addressinfo;
    }

    public void setAddressinfo(String addressinfo) {
        this.addressinfo = addressinfo;
    }
}
