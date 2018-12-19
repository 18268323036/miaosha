package com.yss.domain;

import java.io.Serializable;
import java.util.Date;

public class SuccessKilledInfo implements Serializable {
    private static final long serialVersionUID = -692334722708293518L;

    private Long secKillId;

    private String userPhone;

    private int state;

    private Date createTime;

    public Long getSecKillId() {
        return secKillId;
    }

    public void setSecKillId(Long secKillId) {
        this.secKillId = secKillId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
