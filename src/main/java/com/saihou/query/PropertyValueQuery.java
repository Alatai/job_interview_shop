package com.saihou.query;

import org.springframework.stereotype.Component;

/**
 * @author saihou
 * @date 2021/04/20
 */
@Component
public class PropertyValueQuery extends BaseQuery {

    private Integer pid;
    private Integer ptid;

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
}
