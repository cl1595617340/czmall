package com.bdqn.springboot.entity;

import java.util.List;

public class AtreeGoods {

    private Long id;
    private String name;
    private Integer state;
    private String picture;
    private String typename;//如是1级分类，2级分类

    private List<AtreeGoods> childrensb;


    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public List<AtreeGoods> getChildrensb() {
        return childrensb;
    }

    public void setChildrensb(List<AtreeGoods> childrensb) {
        this.childrensb = childrensb;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


}
