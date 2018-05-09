package com.questionbank.domain;

import java.util.Date;

public class PaperAnswer {
    private Integer paperAnswerid;

    private Integer paperid;

    private String content;

    private Date createtime;

    public Integer getPaperAnswerid() {
        return paperAnswerid;
    }

    public void setPaperAnswerid(Integer paperAnswerid) {
        this.paperAnswerid = paperAnswerid;
    }

    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
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