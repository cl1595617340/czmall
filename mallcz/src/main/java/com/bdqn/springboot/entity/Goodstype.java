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
@TableName("goodstype")
public class Goodstype implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "goodstype_id", type = IdType.AUTO)
    private Long goodstypeId;

    /**
     * 1级大分类名字
     */
    private String goodstypeName;

    /**
     * 是否禁用(默认0启用。1禁用)
     */
    private Integer goodstypeState;

    /*1对多的2级分类*/
    @TableField(exist = false)
    private List<Goodstype2> goodstype2;


    public List<Goodstype2> getGoodstype2() {
        return goodstype2;
    }

    public void setGoodstype2(List<Goodstype2> goodstype2) {
        this.goodstype2 = goodstype2;
    }

    public Long getGoodstypeId() {
        return goodstypeId;
    }

    public void setGoodstypeId(Long goodstypeId) {
        this.goodstypeId = goodstypeId;
    }

    public String getGoodstypeName() {
        return goodstypeName;
    }

    public void setGoodstypeName(String goodstypeName) {
        this.goodstypeName = goodstypeName;
    }

    public Integer getGoodstypeState() {
        return goodstypeState;
    }

    public void setGoodstypeState(Integer goodstypeState) {
        this.goodstypeState = goodstypeState;
    }

    @Override
    public String toString() {
        return "Goodstype{" +
        "goodstypeId=" + goodstypeId +
        ", goodstypeName=" + goodstypeName +
        ", goodstypeState=" + goodstypeState +
        "}";
    }
}
