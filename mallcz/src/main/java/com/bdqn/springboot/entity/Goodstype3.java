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
@TableName("goodstype3")
public class Goodstype3 implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "goodstype3_id", type = IdType.AUTO)
    private Long goodstype3Id;

    private String goodstype3Name;

    private Long goodstype2Id;

    private Integer goodstype3State;

    /**
     * 3级分类有图片
     */
    private String goodstype3Picture;

/*一对多的物品*/
@TableField(exist = false)
    private List<Goods> goodsList;


    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public Long getGoodstype3Id() {
        return goodstype3Id;
    }

    public void setGoodstype3Id(Long goodstype3Id) {
        this.goodstype3Id = goodstype3Id;
    }

    public String getGoodstype3Name() {
        return goodstype3Name;
    }

    public void setGoodstype3Name(String goodstype3Name) {
        this.goodstype3Name = goodstype3Name;
    }

    public Long getGoodstype2Id() {
        return goodstype2Id;
    }

    public void setGoodstype2Id(Long goodstype2Id) {
        this.goodstype2Id = goodstype2Id;
    }

    public Integer getGoodstype3State() {
        return goodstype3State;
    }

    public void setGoodstype3State(Integer goodstype3State) {
        this.goodstype3State = goodstype3State;
    }

    public String getGoodstype3Picture() {
        return goodstype3Picture;
    }

    public void setGoodstype3Picture(String goodstype3Picture) {
        this.goodstype3Picture = goodstype3Picture;
    }

    @Override
    public String toString() {
        return "Goodstype3{" +
        "goodstype3Id=" + goodstype3Id +
        ", goodstype3Name=" + goodstype3Name +
        ", goodstype2Id=" + goodstype2Id +
        ", goodstype3State=" + goodstype3State +
        ", goodstype3Picture=" + goodstype3Picture +
        "}";
    }
}
