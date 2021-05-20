package com.saihou.jishop.entity;

import java.io.Serializable;

/**
 * 属性値
 *
 * @author saihou
 * @date 2021/04/20
 */
public class PropertyValue implements Serializable {

    private Integer id;

    private Integer pid; // 商品id

    private Integer ptid; // 属性id

    private String value;

    private Property property;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getPtid() {
        return ptid;
    }

    public void setPtid(Integer ptid) {
        this.ptid = ptid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}