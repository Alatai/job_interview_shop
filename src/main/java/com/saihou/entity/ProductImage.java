package com.saihou.entity;

import java.io.Serializable;

/**
 * 商品写真
 *
 * @author saihou
 * @date 2021/04/19
 */
public class ProductImage implements Serializable {

    private Integer id;

    private Integer pid; // 商品id

    private String type;

    private String name;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}