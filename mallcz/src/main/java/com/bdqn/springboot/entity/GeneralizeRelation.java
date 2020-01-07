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
 * @since 2020-01-04
 */
@TableName("generalize_relation")
public class GeneralizeRelation implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "generalize_relation_id", type = IdType.AUTO)
    private Long generalizeRelationId;

    private Long generalizeId;

    private Long goodsId;

    /**
     * 专区大图的商品图片
     */
    private String generalizeGoodsImg;
    /**
     * 专区样式，默认0是没有大图，1有大图
     */
    private Integer generalize_type;

    /*一对1的商品*/
    @TableField(exist = false)
    private Goods goods;



    public Integer getGeneralize_type() {
        return generalize_type;
    }

    public void setGeneralize_type(Integer generalize_type) {
        this.generalize_type = generalize_type;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Long getGeneralizeRelationId() {
        return generalizeRelationId;
    }

    public void setGeneralizeRelationId(Long generalizeRelationId) {
        this.generalizeRelationId = generalizeRelationId;
    }

    public Long getGeneralizeId() {
        return generalizeId;
    }

    public void setGeneralizeId(Long generalizeId) {
        this.generalizeId = generalizeId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGeneralizeGoodsImg() {
        return generalizeGoodsImg;
    }

    public void setGeneralizeGoodsImg(String generalizeGoodsImg) {
        this.generalizeGoodsImg = generalizeGoodsImg;
    }

    @Override
    public String toString() {
        return "GeneralizeRelation{" +
        "generalizeRelationId=" + generalizeRelationId +
        ", generalizeId=" + generalizeId +
        ", goodsId=" + goodsId +
        ", generalizeGoodsImg=" + generalizeGoodsImg +
        "}";
    }
}
