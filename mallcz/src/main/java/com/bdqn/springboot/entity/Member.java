package com.bdqn.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

@TableName("member")
public class Member {

    @TableId(value = "memberId", type = IdType.AUTO)
    private Integer memberId;
    @TableField("memberName")
    private String memberName;
    @TableField("sex")
    private String sex;
    @TableField("email")
    private String email;
    @TableField("birthday")
    private String birthday;
    @TableField("memberProvince")
    private String memberProvince;
    @TableField("membercity")
    private String membercity;
    @TableField("memberState")
    private Integer memberState;
    @TableField("memberipone")
    private String memberipone;
    @TableField("memberpwd")
    private String memberpwd;
    @TableField("avatar")
    private String avatar;

    //1对多的用户地址
    @TableField(exist = false)
    private List<Address> addressList;

    public Member(Integer memberId, String memberName, String sex, String email, String birthday, String memberProvince, String membercity, Integer memberState, String memberipone, String memberpwd, String avatar) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.sex = sex;
        this.email = email;
        this.birthday = birthday;
        this.memberProvince = memberProvince;
        this.membercity = membercity;
        this.memberState = memberState;
        this.memberipone = memberipone;
        this.memberpwd = memberpwd;
        this.avatar = avatar;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMemberpwd() {
        return memberpwd;
    }

    public void setMemberpwd(String memberpwd) {
        this.memberpwd = memberpwd;
    }

    public String getMemberipone() {
        return memberipone;
    }

    public void setMemberipone(String memberipone) {
        this.memberipone = memberipone;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMemberProvince() {
        return memberProvince;
    }

    public void setMemberProvince(String memberProvince) {
        this.memberProvince = memberProvince;
    }

    public String getMembercity() {
        return membercity;
    }

    public void setMembercity(String membercity) {
        this.membercity = membercity;
    }

    public Integer getMemberState() {
        return memberState;
    }

    public void setMemberState(Integer memberState) {
        this.memberState = memberState;
    }
}
