package com.questionbank.domain;

public class QuestionType {
    private Integer questiontypeId;

    private Integer type;

    private Integer level;

    private Integer subjectId;

    private String teacherId;

    private String createtime;

    private String indicator;

    private String lastuseTime;

    public Integer getQuestiontypeId() {
        return questiontypeId;
    }

    public void setQuestiontypeId(Integer questiontypeId) {
        this.questiontypeId = questiontypeId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public String getLastuseTime() {
        return lastuseTime;
    }

    public void setLastuseTime(String lastuseTime) {
        this.lastuseTime = lastuseTime;
    }
}