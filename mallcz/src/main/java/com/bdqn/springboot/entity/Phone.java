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
@TableName("phone")
public class Phone implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "phone_id", type = IdType.AUTO)
    private Long phoneId;

    /**
     * 关联的1级分类
     */
    private Long phoneTypeId;

    /**
     * 手机标题，也是手机名字
     */
    private String phoneName;

    /**
     * 手机标题下面简单的简介
     */
    private String phoneDescribe;

    /**
     * 手机库存
     */
    private Integer phoneRepertory;

    /**
     * 详细信息)11.28:要富文本域
     */
    private String phoneInfo;

    /**
     * 说明)
     */
    private String phoneExplain;


    public Long getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Long phoneId) {
        this.phoneId = phoneId;
    }

    public Long getPhoneTypeId() {
        return phoneTypeId;
    }

    public void setPhoneTypeId(Long phoneTypeId) {
        this.phoneTypeId = phoneTypeId;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getPhoneDescribe() {
        return phoneDescribe;
    }

    public void setPhoneDescribe(String phoneDescribe) {
        this.phoneDescribe = phoneDescribe;
    }

    public Integer getPhoneRepertory() {
        return phoneRepertory;
    }

    public void setPhoneRepertory(Integer phoneRepertory) {
        this.phoneRepertory = phoneRepertory;
    }

    public String getPhoneInfo() {
        return phoneInfo;
    }

    public void setPhoneInfo(String phoneInfo) {
        this.phoneInfo = phoneInfo;
    }

    public String getPhoneExplain() {
        return phoneExplain;
    }

    public void setPhoneExplain(String phoneExplain) {
        this.phoneExplain = phoneExplain;
    }

    @Override
    public String toString() {
        return "Phone{" +
        "phoneId=" + phoneId +
        ", phoneTypeId=" + phoneTypeId +
        ", phoneName=" + phoneName +
        ", phoneDescribe=" + phoneDescribe +
        ", phoneRepertory=" + phoneRepertory +
        ", phoneInfo=" + phoneInfo +
        ", phoneExplain=" + phoneExplain +
        "}";
    }
}
