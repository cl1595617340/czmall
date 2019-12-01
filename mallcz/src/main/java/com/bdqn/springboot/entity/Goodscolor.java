package com.bdqn.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author KazuGin
 * @since 2019-11-28
 */
@TableName("goodscolor")
public class Goodscolor implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "goodscolor_id", type = IdType.AUTO)
    private Long goodscolorId;

    /**
     * 关联的物品和手机id
     */
    private Long goodsId;

    /**
     * 物品颜色名字：如：红蓝黄
     */
    @TableField("goodscolor_name")
    private String goodscolorName;

    /**
     * 物品颜色所对应的图片
     */
    @TableField("goodscolor_picture")
    private String goodscolorPicture;


    public Long getGoodscolorId() {
        return goodscolorId;
    }

    public void setGoodscolorId(Long goodscolorId) {
        this.goodscolorId = goodscolorId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodscolorName() {
        return goodscolorName;
    }

    public void setGoodscolorName(String goodscolorName) {
        this.goodscolorName = goodscolorName;
    }

    public String getGoodscolorPicture() {
        return goodscolorPicture;
    }

    public void setGoodscolorPicture(String goodscolorPicture) {
        this.goodscolorPicture = goodscolorPicture;
    }

    @Override
    public String toString() {
        return "Goodscolor{" +
        "goodscolorId=" + goodscolorId +
        ", goodsId=" + goodsId +
        ", goodscolorName=" + goodscolorName +
        ", goodscolorPicture=" + goodscolorPicture +
        "}";
    }
}
