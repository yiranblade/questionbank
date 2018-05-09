package com.questionbank.domain;

import java.util.Date;

public class SchedulePaper {
    private Integer schedulePaperid;

    private Integer scheduleid;

    private String content;

    private Date createtime;

    public Integer getSchedulePaperid() {
        return schedulePaperid;
    }

    public void setSchedulePaperid(Integer schedulePaperid) {
        this.schedulePaperid = schedulePaperid;
    }

    public Integer getScheduleid() {
        return scheduleid;
    }

    public void setScheduleid(Integer scheduleid) {
        this.scheduleid = scheduleid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}