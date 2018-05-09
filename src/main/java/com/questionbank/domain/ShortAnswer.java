package com.questionbank.domain;

public class ShortAnswer {
    private Integer shortanswerid;

    private String answer;

    private Integer questiontypeId;

    private String content;

    public Integer getShortanswerid() {
        return shortanswerid;
    }

    public void setShortanswerid(Integer shortanswerid) {
        this.shortanswerid = shortanswerid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getQuestiontypeId() {
        return questiontypeId;
    }

    public void setQuestiontypeId(Integer questiontypeId) {
        this.questiontypeId = questiontypeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}