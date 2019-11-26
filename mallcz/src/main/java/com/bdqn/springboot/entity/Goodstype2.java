package com.bdqn.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author KazuGin
 * @since 2019-11-24
 */
@TableName("goodstype2")
public class Goodstype2 implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "goodstype2_id", type = IdType.AUTO)
    private Long goodstype2Id;

    private String goodstype2Name;

    /**
     * 关联1级分类的外键
     */
    private Long goodstypeId;

    /**
     * 是否禁用(默认0启用。1禁用)
     */
    private Integer goodstype2State;


    /*1对多的3级分类*/
    @TableField(exist = false)
    private List<Goodstype3> goodstype3;


    public List<Goodstype3> getGoodstype3() {
        return goodstype3;
    }

    public void setGoodstype3(List<Goodstype3> goodstype3) {
        this.goodstype3 = goodstype3;
    }

    public Long getGoodstype2Id() {
        return goodstype2Id;
    }

    public void setGoodstype2Id(Long goodstype2Id) {
        this.goodstype2Id = goodstype2Id;
    }

    public String getGoodstype2Name() {
        return goodstype2Name;
    }

    public void setGoodstype2Name(String goodstype2Name) {
        this.goodstype2Name = goodstype2Name;
    }

    public Long getGoodstypeId() {
        return goodstypeId;
    }

    public void setGoodstypeId(Long goodstypeId) {
        this.goodstypeId = goodstypeId;
    }

    public Integer getGoodstype2State() {
        return goodstype2State;
    }

    public void setGoodstype2State(Integer goodstype2State) {
        this.goodstype2State = goodstype2State;
    }

    @Override
    public String toString() {
        return "Goodstype2{" +
        "goodstype2Id=" + goodstype2Id +
        ", goodstype2Name=" + goodstype2Name +
        ", goodstypeId=" + goodstypeId +
        ", goodstype2State=" + goodstype2State +
        "}";
    }
}
