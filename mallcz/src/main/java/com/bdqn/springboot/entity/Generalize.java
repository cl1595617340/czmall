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
@TableName("generalize")
public class Generalize implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "generalize_id", type = IdType.AUTO)
    private Long generalizeId;

    /**
     * 推广专区名字
     */
    private String generalizeName;

    private Integer generalizeStatesb;


    /*一对多的推广*/
    @TableField(exist = false)
    private List<GeneralizeRelation> generalizeRelationList;


    public Integer getGeneralizeStatesb() {
        return generalizeStatesb;
    }

    public void setGeneralizeStatesb(Integer generalizeStatesb) {
        this.generalizeStatesb = generalizeStatesb;
    }

    public List<GeneralizeRelation> getGeneralizeRelationList() {
        return generalizeRelationList;
    }

    public void setGeneralizeRelationList(List<GeneralizeRelation> generalizeRelationList) {
        this.generalizeRelationList = generalizeRelationList;
    }

    public Long getGeneralizeId() {
        return generalizeId;
    }

    public void setGeneralizeId(Long generalizeId) {
        this.generalizeId = generalizeId;
    }

    public String getGeneralizeName() {
        return generalizeName;
    }

    public void setGeneralizeName(String generalizeName) {
        this.generalizeName = generalizeName;
    }

    public Generalize() {
    }
}
