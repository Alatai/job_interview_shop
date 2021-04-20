package com.saihou.query;

import org.springframework.stereotype.Component;

/**
 * 商品写真検索オブジェクト
 *
 * @author saihou
 * @date 2021/04/20
 */
@Component
public class ProductImageQuery extends BaseQuery {

    private Integer pid;
    private String type;

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
        this.type = type;
    }
}
