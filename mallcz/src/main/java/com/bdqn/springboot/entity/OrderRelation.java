package com.bdqn.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("order_relation")
public class OrderRelation implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "relation_id", type = IdType.AUTO)
    private Long relationId;

    /**
     * 关联的订单id
     */
    private Long relationOrderId;

    /**
     * 关联的会员id
     */
    @TableField("relation_member_id")
    private Long relation_member_id;

    /**
     * 关联的商品id
     */
    private Long relationGoodsId;

    /**
     * 关联的地址id
     */
    private Long relationAddressId;

    /**
     * 关联的商品颜色图片id
     */
    private Long relationColorId;

    /**
     * 关联的商品版本id
     */
    private Long relationVersionsId;

    /**
     * 关联的赠品名字
     */
   /* @TableField("relation_compName")*/
    private String relationCompname;

    /**
     * 关联的赠品图片
     */
    private String relationCompimg;

    /**
     * 关联的
     */
    @TableField("relation_count")
    private Integer relation_count;



    /*订单一对一的会员*/
    private Member member;

    /*订单一对一的商品*/
    private Goods goods;

    /*订单一对一的地址*/
    private Address address;

    /*订单一对一的商品颜色图片*/
    private Goodscolor goodscolor;

    /*订单一对一的版本*/
    private Versions versions;

    public Integer getRelation_count() {
        return relation_count;
    }

    public void setRelation_count(Integer relation_count) {
        this.relation_count = relation_count;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Goodscolor getGoodscolor() {
        return goodscolor;
    }

    public void setGoodscolor(Goodscolor goodscolor) {
        this.goodscolor = goodscolor;
    }

    public Versions getVersions() {
        return versions;
    }

    public void setVersions(Versions versions) {
        this.versions = versions;
    }

    public Long getRelation_member_id() {
        return relation_member_id;
    }

    public void setRelation_member_id(Long relation_member_id) {
        this.relation_member_id = relation_member_id;
    }

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public Long getRelationOrderId() {
        return relationOrderId;
    }

    public void setRelationOrderId(Long relationOrderId) {
        this.relationOrderId = relationOrderId;
    }

    public Long getRelationGoodsId() {
        return relationGoodsId;
    }

    public void setRelationGoodsId(Long relationGoodsId) {
        this.relationGoodsId = relationGoodsId;
    }

    public Long getRelationAddressId() {
        return relationAddressId;
    }

    public void setRelationAddressId(Long relationAddressId) {
        this.relationAddressId = relationAddressId;
    }

    public Long getRelationColorId() {
        return relationColorId;
    }

    public void setRelationColorId(Long relationColorId) {
        this.relationColorId = relationColorId;
    }

    public Long getRelationVersionsId() {
        return relationVersionsId;
    }

    public void setRelationVersionsId(Long relationVersionsId) {
        this.relationVersionsId = relationVersionsId;
    }

    public String getRelationCompname() {
        return relationCompname;
    }

    public void setRelationCompname(String relationCompname) {
        this.relationCompname = relationCompname;
    }

    public String getRelationCompimg() {
        return relationCompimg;
    }

    public void setRelationCompimg(String relationCompimg) {
        this.relationCompimg = relationCompimg;
    }

    @Override
    public String toString() {
        return "OrderRelation{" +
        "relationId=" + relationId +
        ", relationOrderId=" + relationOrderId +
        ", relationGoodsId=" + relationGoodsId +
        ", relationAddressId=" + relationAddressId +
        ", relationColorId=" + relationColorId +
        ", relationVersionsId=" + relationVersionsId +
        ", relationCompname=" + relationCompname +
        ", relationCompimg=" + relationCompimg +
        "}";
    }

    public OrderRelation() {
    }
}
