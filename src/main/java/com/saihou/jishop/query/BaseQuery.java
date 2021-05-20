package com.saihou.jishop.query;

import org.springframework.stereotype.Component;

/**
 * ベース検索オブジェクト
 *
 * @author saihou
 * @date 2021/04/20
 */
@Component
public class BaseQuery {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
