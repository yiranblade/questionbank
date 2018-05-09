package com.questionbank.dto;

public class ShortAnswerDto {

	private Integer questionTypeId;
	
	private Integer shortAnswerId;
	
	private String answer;

    private String content;
    
    private Integer type;

    private Integer level;

    private Integer subjectId;

    private String teacherId;

    private String indicator;

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public String getIndicator() {
		return indicator;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public Integer getQuestionTypeId() {
		return questionTypeId;
	}

	public void setQuestionTypeId(Integer questionTypeId) {
		this.questionTypeId = questionTypeId;
	}

	public Integer getShortAnswerId() {
		return shortAnswerId;
	}

	public void setShortAnswerId(Integer shortAnswerId) {
		this.shortAnswerId = shortAnswerId;
	}

	
    
}
