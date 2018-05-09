package com.questionbank.domain;

public class Schedule {
    private Integer scheduleId;

    private Integer professionId;

    private Integer subjectId;

    private String teacherId;

    private String grade;

    private String testTime;

    private Byte abType;

    private Integer testType;

    private Integer avgRecord;

    private String createtime;

    private String term;

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Integer professionId) {
        this.professionId = professionId;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTestTime() {
        return testTime;
    }

    public void setTestTime(String testTime) {
        this.testTime = testTime;
    }

    public Byte getAbType() {
        return abType;
    }

    public void setAbType(Byte abType) {
        this.abType = abType;
    }

    public Integer getTestType() {
        return testType;
    }

    public void setTestType(Integer testType) {
        this.testType = testType;
    }

    public Integer getAvgRecord() {
        return avgRecord;
    }

    public void setAvgRecord(Integer avgRecord) {
        this.avgRecord = avgRecord;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}