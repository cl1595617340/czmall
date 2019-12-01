package com.bdqn.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author KazuGin
 * @since 2019-11-28
 */
@TableName("goods")
public class Goods implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "goods_id", type = IdType.AUTO)
    private Long goodsId;

    /**
     * 关联的3级分类
     */
    private Long goodsType3Id;

    /**
     * 产品名字
     */
    private String goodsName;

    /**
     * 产品标题下面简单的简介
     */
    private String goodsDescribe;

    /**
     * (物品库存
     */
    private String goodsRepertory;

    /**
     * 详细信息
     */
    private String goodsInfo;

    /**
     * 说明
     */
    private String goodsExplain;

    //1对多的物品版本
    @TableField(exist = false)
    private List<Versions> versionsList;


    //1对多的
    @TableField(exist = false)
    private List<Goodscolor> goodscolorList;



    //多对1的3及分类
    @TableField(exist = false)
    private Goodstype3 goodstype3;


    /*创建时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date goods_create;

    //根据新建日期查询的2个属性
    private String strartDate;//开始
    private String endDate;//结束

    /*0在，1下架*/
    @TableField("goods_state")
    private Integer goods_state;

    public Integer getGoods_state() {
        return goods_state;
    }

    public void setGoods_state(Integer goods_state) {
        this.goods_state = goods_state;
    }

    public String getStrartDate() {
        return strartDate;
    }

    public void setStrartDate(String strartDate) {
        this.strartDate = strartDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Date getGoods_create() {
        return goods_create;
    }

    public void setGoods_create(Date goods_create) {
        this.goods_create = goods_create;
    }

    public List<Goodscolor> getGoodscolorList() {
        return goodscolorList;
    }

    public void setGoodscolorList(List<Goodscolor> goodscolorList) {
        this.goodscolorList = goodscolorList;
    }

    public Goodstype3 getGoodstype3() {
        return goodstype3;
    }

    public void setGoodstype3(Goodstype3 goodstype3) {
        this.goodstype3 = goodstype3;
    }

    public List<Versions> getVersionsList() {
        return versionsList;
    }

    public void setVersionsList(List<Versions> versionsList) {
        this.versionsList = versionsList;
    }


    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getGoodsType3Id() {
        return goodsType3Id;
    }

    public void setGoodsType3Id(Long goodsType3Id) {
        this.goodsType3Id = goodsType3Id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsDescribe() {
        return goodsDescribe;
    }

    public void setGoodsDescribe(String goodsDescribe) {
        this.goodsDescribe = goodsDescribe;
    }

    public String getGoodsRepertory() {
        return goodsRepertory;
    }

    public void setGoodsRepertory(String goodsRepertory) {
        this.goodsRepertory = goodsRepertory;
    }

    public String getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(String goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public String getGoodsExplain() {
        return goodsExplain;
    }

    public void setGoodsExplain(String goodsExplain) {
        this.goodsExplain = goodsExplain;
    }

    @Override
    public String toString() {
        return "Goods{" +
        "goodsId=" + goodsId +
        ", goodsType3Id=" + goodsType3Id +
        ", goodsName=" + goodsName +
        ", goodsDescribe=" + goodsDescribe +
        ", goodsRepertory=" + goodsRepertory +
        ", goodsInfo=" + goodsInfo +
        ", goodsExplain=" + goodsExplain +
        "}";
    }
}
