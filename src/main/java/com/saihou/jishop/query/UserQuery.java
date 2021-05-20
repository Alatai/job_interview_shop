package com.saihou.jishop.query;

import org.springframework.stereotype.Component;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/04/22 16:38
 */
@Component
public class UserQuery extends BaseQuery {

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
