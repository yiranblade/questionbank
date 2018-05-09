package com.questionbank.service;

import com.questionbank.domain.Paper;
import com.questionbank.domain.PaperAnswer;

public interface PaperService {
	public Paper addNewPaperByScheduleId(Integer scheduleId);
	public PaperAnswer getPaperAnswerByPaperId(Integer paperId);
	
}
