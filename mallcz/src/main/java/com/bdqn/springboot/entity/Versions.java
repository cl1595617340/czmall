package com.bdqn.springboot.entity;

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
@TableName("versions")
public class Versions implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "versions_id", type = IdType.AUTO)
    private Long versionsId;

    /**
     * 关联的物品和手机id
     */
    private Long goodsId;

    /**
     * 物品版本名字如：6GB+128GB,如衣服的x，xxl，数据线的几米
     */
    private String versionsName;

    /**
     * 版本对应的价钱
     */
    private Integer versionsPrice;


    public Long getVersionsId() {
        return versionsId;
    }

    public void setVersionsId(Long versionsId) {
        this.versionsId = versionsId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getVersionsName() {
        return versionsName;
    }

    public void setVersionsName(String versionsName) {
        this.versionsName = versionsName;
    }

    public Integer getVersionsPrice() {
        return versionsPrice;
    }

    public void setVersionsPrice(Integer versionsPrice) {
        this.versionsPrice = versionsPrice;
    }

    @Override
    public String toString() {
        return "Versions{" +
        "versionsId=" + versionsId +
        ", goodsId=" + goodsId +
        ", versionsName=" + versionsName +
        ", versionsPrice=" + versionsPrice +
        "}";
    }
}
