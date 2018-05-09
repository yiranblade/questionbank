package com.questionbank.domain;

public class SetMark {
    private Integer setmarkId;

    private Integer type;

    private Integer count;

    private Integer mark;

    private String createtime;

    private Integer scheduleId;

    public Integer getSetmarkId() {
        return setmarkId;
    }

    public void setSetmarkId(Integer setmarkId) {
        this.setmarkId = setmarkId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }
}