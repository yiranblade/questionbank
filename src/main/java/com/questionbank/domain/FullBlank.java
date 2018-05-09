package com.questionbank.domain;

public class FullBlank {
    private Integer fullblankId;

    private String answer;

    private Integer questiontypeId;

    private String content;

    public Integer getFullblankId() {
        return fullblankId;
    }

    public void setFullblankId(Integer fullblankId) {
        this.fullblankId = fullblankId;
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