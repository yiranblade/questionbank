package com.questionbank.service;

import java.util.List;

import com.questionbank.dto.ChoiceDto;
import com.questionbank.dto.FullBlankDto;
import com.questionbank.dto.ShortAnswerDto;
import com.questionbank.dto.SolvingDto;

public interface QuestionService {

	public boolean addChoice(ChoiceDto choiceDto);
	public boolean addFullBlank(FullBlankDto fullBlankDto);
	public boolean addShortAnswer(ShortAnswerDto shortAnswerDto);
	public boolean addSolving(SolvingDto solvingDto);
	public boolean deleteQuestion(Integer[] questionTypeId);
	public List<ChoiceDto> getAllChoice();
	public List<FullBlankDto> getAllFullBlank();
	public List<SolvingDto> getAllSolving();
	public List<ShortAnswerDto> getAllShortAnswer();
	
	public boolean updateChoice(ChoiceDto choiceDto);
	public boolean updateFullBlank(FullBlankDto fullBlankDto);
	public boolean updateShortAnswer(ShortAnswerDto shortAnswerDto);
	public boolean updateSolving(SolvingDto solvingDto);
}
