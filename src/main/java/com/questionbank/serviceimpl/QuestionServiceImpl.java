package com.questionbank.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questionbank.dao.ChoiceMapper;
import com.questionbank.dao.FullBlankMapper;
import com.questionbank.dao.QuestionTypeMapper;
import com.questionbank.dao.ShortAnswerMapper;
import com.questionbank.dao.SolvingMapper;
import com.questionbank.domain.Choice;
import com.questionbank.domain.FullBlank;
import com.questionbank.domain.QuestionType;
import com.questionbank.domain.ShortAnswer;
import com.questionbank.domain.SolvingWithBLOBs;
import com.questionbank.dto.ChoiceDto;
import com.questionbank.dto.FullBlankDto;
import com.questionbank.dto.ShortAnswerDto;
import com.questionbank.dto.SolvingDto;
import com.questionbank.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionTypeMapper questionTypeDao;
	
	@Autowired
	private ChoiceMapper choiceDao;
	
	@Autowired
	private FullBlankMapper fullBlankDao;
	
	@Autowired
	private ShortAnswerMapper shortAnswerDao;
	
	@Autowired
	private SolvingMapper solvingDao;

	public boolean addChoice(ChoiceDto choiceDto) {
		// TODO Auto-generated method stub
		if(choiceDto!=null){
			QuestionType questionType=new QuestionType();
			Choice choice=new Choice();
			int questionTypeId=-1;
			questionType.setIndicator(choiceDto.getIndicator());
			questionType.setLevel(choiceDto.getLevel());
			questionType.setType(choiceDto.getType());
			questionType.setSubjectId(choiceDto.getSubjectId());
			questionType.setType(choiceDto.getType());
			questionType.setTeacherId(choiceDto.getTeacherId());
			questionTypeDao.insertSelective(questionType);
			questionTypeId=questionTypeDao.selectLastId();
			choice.setContent(choiceDto.getContent());
			choice.setChoiceOne(choiceDto.getChoiceOne());
			choice.setChoiceTwo(choiceDto.getChoiceTwo());
			choice.setChoiceThree(choiceDto.getChoiceThree());
			choice.setChoiceFour(choiceDto.getChoiceFour());
			choice.setAnswer(choiceDto.getAnswer());
			choice.setQuestiontypeId(questionTypeId);
			choiceDao.insertSelective(choice);
			return true;
		}else{
			return false;
		}
	}

	public boolean addFullBlank(FullBlankDto fullBlankDto) {
		// TODO Auto-generated method stub
		if(fullBlankDto!=null){
			QuestionType questionType=new QuestionType();
			FullBlank fullBlank=new FullBlank();
			int questionTypeId=-1;
			questionType.setIndicator(fullBlankDto.getIndicator());
			questionType.setLevel(fullBlankDto.getLevel());
			questionType.setType(fullBlankDto.getType());
			questionType.setSubjectId(fullBlankDto.getSubjectId());
			questionType.setType(fullBlankDto.getType());
			questionType.setTeacherId(fullBlankDto.getTeacherId());
			questionTypeDao.insertSelective(questionType);
			questionTypeId=questionTypeDao.selectLastId();
			fullBlank.setContent(fullBlankDto.getContent());
			fullBlank.setAnswer(fullBlankDto.getAnswer());
			fullBlank.setQuestiontypeId(questionTypeId);
			fullBlankDao.insertSelective(fullBlank);
			return true;
		}else{
			return false;
		}
	}

	public boolean addShortAnswer(ShortAnswerDto shortAnswerDto) {
		// TODO Auto-generated method stub
		if(shortAnswerDto!=null){
			QuestionType questionType=new QuestionType();
			ShortAnswer shortAnswer=new ShortAnswer();
			int questionTypeId=-1;
			questionType.setIndicator(shortAnswerDto.getIndicator());
			questionType.setLevel(shortAnswerDto.getLevel());
			questionType.setType(shortAnswerDto.getType());
			questionType.setSubjectId(shortAnswerDto.getSubjectId());
			questionType.setType(shortAnswerDto.getType());
			questionType.setTeacherId(shortAnswerDto.getTeacherId());
			questionTypeDao.insertSelective(questionType);
			questionTypeId=questionTypeDao.selectLastId();
			shortAnswer.setContent(shortAnswerDto.getContent());
			shortAnswer.setAnswer(shortAnswerDto.getAnswer());
			shortAnswer.setQuestiontypeId(questionTypeId);
			shortAnswerDao.insertSelective(shortAnswer);
			return true;
		}else{
			return false;
		}
	}

	public boolean addSolving(SolvingDto solvingDto) {
		// TODO Auto-generated method stub
		if(solvingDto!=null){
			QuestionType questionType=new QuestionType();
			SolvingWithBLOBs solving=new SolvingWithBLOBs();
			int questionTypeId=-1;
			questionType.setIndicator(solvingDto.getIndicator());
			questionType.setLevel(solvingDto.getLevel());
			questionType.setType(solvingDto.getType());
			questionType.setSubjectId(solvingDto.getSubjectId());
			questionType.setType(solvingDto.getType());
			questionType.setTeacherId(solvingDto.getTeacherId());
			questionTypeDao.insertSelective(questionType);
			questionTypeId=questionTypeDao.selectLastId();
			solving.setContent(solvingDto.getContent());
			solving.setAnswer(solvingDto.getAnswer());
			solving.setQuestiontypeId(questionTypeId);
			solvingDao.insertSelective(solving);
			return true;
		}else{
			return false;
		}
	}

	public boolean deleteQuestion(Integer[] questionTypeId) {
		// TODO Auto-generated method stub
		for(int i=0;i<questionTypeId.length;i++){
			QuestionType questionType=questionTypeDao.selectByPrimaryKey(questionTypeId[i]);
			questionTypeDao.deleteByPrimaryKey(questionTypeId[i]);
			Integer type=questionType.getType();
			switch(type){
				case 1:choiceDao.deleteByQuestionTypeId(questionTypeId[i]);break;
				case 2:fullBlankDao.deleteByQuestionTypeId(questionTypeId[i]);break;
				case 3:shortAnswerDao.deleteByQuestionTypeId(questionTypeId[i]);break;
				case 4:solvingDao.deleteByQuestionTypeId(questionTypeId[i]);break;
				default:return false;
			}
		}
		return true;
	}

	@Override
	public List<ChoiceDto> getAllChoice() {
		// TODO Auto-generated method stub
		List<ChoiceDto> choiceDtos=new ArrayList<ChoiceDto>();
		List<QuestionType> questionTypes=questionTypeDao.selectQuestionTypeByType(1);
		for(int i=0;i<questionTypes.size();i++){
			ChoiceDto choiceDto=new ChoiceDto();
			QuestionType questionType=questionTypes.get(i);
			Choice choice=choiceDao.selectChoiceByQuestionTypeId(questionType.getQuestiontypeId());
			choiceDto.setType(questionType.getType());
			choiceDto.setTeacherId(questionType.getTeacherId());
			choiceDto.setSubjectId(questionType.getSubjectId());
			choiceDto.setLevel(questionType.getLevel());
			choiceDto.setIndicator(questionType.getIndicator());
			choiceDto.setContent(choice.getContent());
			choiceDto.setChoiceOne(choice.getChoiceOne());
			choiceDto.setChoiceTwo(choice.getChoiceTwo());
			choiceDto.setChoiceThree(choice.getChoiceThree());
			choiceDto.setChoiceFour(choice.getChoiceFour());
			choiceDto.setAnswer(choice.getAnswer());
			choiceDto.setChoiceId(choice.getChoiceId());
			choiceDto.setQuestionTypeId(choice.getQuestiontypeId());
			choiceDtos.add(choiceDto);
			
		}
		return choiceDtos;
	}

	@Override
	public List<FullBlankDto> getAllFullBlank() {
		// TODO Auto-generated method stub
		List<FullBlankDto> fullBlankDtos=new ArrayList<FullBlankDto>();
		List<QuestionType> questionTypes=questionTypeDao.selectQuestionTypeByType(2);
		for(int i=0;i<questionTypes.size();i++){
			FullBlankDto fullBlankDto=new FullBlankDto();
			QuestionType questionType=questionTypes.get(i);
			FullBlank fullBlank=fullBlankDao.selectFullBlankByQuestionTypeId(questionType.getQuestiontypeId());
			fullBlankDto.setType(questionType.getType());
			fullBlankDto.setTeacherId(questionType.getTeacherId());
			fullBlankDto.setSubjectId(questionType.getSubjectId());
			fullBlankDto.setLevel(questionType.getLevel());
			fullBlankDto.setIndicator(questionType.getIndicator());
			fullBlankDto.setContent(fullBlank.getContent());
			fullBlankDto.setAnswer(fullBlank.getAnswer());
			fullBlankDto.setFullBlankId(fullBlank.getFullblankId());
			fullBlankDto.setQuestionTypeId(fullBlank.getQuestiontypeId());
			fullBlankDtos.add(fullBlankDto);
			
		}
		return fullBlankDtos;
	}

	@Override
	public List<SolvingDto> getAllSolving() {
		// TODO Auto-generated method stub
		List<SolvingDto> solvingDtos=new ArrayList<SolvingDto>();
		List<QuestionType> questionTypes=questionTypeDao.selectQuestionTypeByType(4);
		for(int i=0;i<questionTypes.size();i++){
			SolvingDto solvingDto=new SolvingDto();
			QuestionType questionType=questionTypes.get(i);
			SolvingWithBLOBs solving=solvingDao.selectByQuestionTypeId(questionType.getQuestiontypeId());
			solvingDto.setType(questionType.getType());
			solvingDto.setTeacherId(questionType.getTeacherId());
			solvingDto.setSubjectId(questionType.getSubjectId());
			solvingDto.setLevel(questionType.getLevel());
			solvingDto.setIndicator(questionType.getIndicator());
			solvingDto.setContent(solving.getContent());
			solvingDto.setAnswer(solving.getAnswer());
			solvingDto.setQuestionTypeId(solving.getQuestiontypeId());
			solvingDto.setSolvingId(solving.getSolvingId());
			solvingDtos.add(solvingDto);
			
		}
		return solvingDtos;
	}

	@Override
	public List<ShortAnswerDto> getAllShortAnswer() {
		// TODO Auto-generated method stub
		List<ShortAnswerDto> shortAnswerDtos=new ArrayList<ShortAnswerDto>();
		List<QuestionType> questionTypes=questionTypeDao.selectQuestionTypeByType(3);
		for(int i=0;i<questionTypes.size();i++){
			ShortAnswerDto shortAnswerDto=new ShortAnswerDto();
			QuestionType questionType=questionTypes.get(i);
			ShortAnswer shortAnswer=shortAnswerDao.selectShortAnswerByQuestionTypeId(questionType.getQuestiontypeId());
			shortAnswerDto.setType(questionType.getType());
			shortAnswerDto.setTeacherId(questionType.getTeacherId());
			shortAnswerDto.setSubjectId(questionType.getSubjectId());
			shortAnswerDto.setLevel(questionType.getLevel());
			shortAnswerDto.setIndicator(questionType.getIndicator());
			shortAnswerDto.setContent(shortAnswer.getContent());
			shortAnswerDto.setAnswer(shortAnswer.getAnswer());
			shortAnswerDto.setQuestionTypeId(shortAnswer.getQuestiontypeId());
			shortAnswerDto.setShortAnswerId(shortAnswer.getShortanswerid());
			shortAnswerDtos.add(shortAnswerDto);
			
		}
		return shortAnswerDtos;
	}

	@Override
	public boolean updateChoice(ChoiceDto choiceDto) {
		// TODO Auto-generated method stub
		if(choiceDto!=null){
			QuestionType questionType=new QuestionType();
			Choice choice=new Choice();
			questionType.setQuestiontypeId(choiceDto.getQuestionTypeId());
			questionType.setIndicator(choiceDto.getIndicator());
			questionType.setLevel(choiceDto.getLevel());
			questionType.setType(choiceDto.getType());
			questionType.setSubjectId(choiceDto.getSubjectId());
			questionType.setType(choiceDto.getType());
			questionType.setTeacherId(choiceDto.getTeacherId());
			questionTypeDao.updateByPrimaryKeySelective(questionType);
			choice.setContent(choiceDto.getContent());
			choice.setChoiceOne(choiceDto.getChoiceOne());
			choice.setChoiceTwo(choiceDto.getChoiceTwo());
			choice.setChoiceThree(choiceDto.getChoiceThree());
			choice.setChoiceFour(choiceDto.getChoiceFour());
			choice.setAnswer(choiceDto.getAnswer());
			choice.setChoiceId(choiceDto.getChoiceId());
			choiceDao.updateByPrimaryKeySelective(choice);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateFullBlank(FullBlankDto fullBlankDto) {
		// TODO Auto-generated method stub
		if(fullBlankDto!=null){
			QuestionType questionType=new QuestionType();
			FullBlank fullBlank=new FullBlank();
			questionType.setQuestiontypeId(fullBlankDto.getQuestionTypeId());
			questionType.setIndicator(fullBlankDto.getIndicator());
			questionType.setLevel(fullBlankDto.getLevel());
			questionType.setType(fullBlankDto.getType());
			questionType.setSubjectId(fullBlankDto.getSubjectId());
			questionType.setType(fullBlankDto.getType());
			questionType.setTeacherId(fullBlankDto.getTeacherId());
			questionTypeDao.updateByPrimaryKeySelective(questionType);
			fullBlank.setContent(fullBlankDto.getContent());
			fullBlank.setAnswer(fullBlankDto.getAnswer());
			fullBlank.setFullblankId(fullBlankDto.getFullBlankId());
			fullBlankDao.updateByPrimaryKeySelective(fullBlank);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateShortAnswer(ShortAnswerDto shortAnswerDto) {
		// TODO Auto-generated method stub
		if(shortAnswerDto!=null){
			QuestionType questionType=new QuestionType();
			ShortAnswer shortAnswer=new ShortAnswer();
			questionType.setQuestiontypeId(shortAnswerDto.getQuestionTypeId());
			questionType.setIndicator(shortAnswerDto.getIndicator());
			questionType.setLevel(shortAnswerDto.getLevel());
			questionType.setType(shortAnswerDto.getType());
			questionType.setSubjectId(shortAnswerDto.getSubjectId());
			questionType.setType(shortAnswerDto.getType());
			questionType.setTeacherId(shortAnswerDto.getTeacherId());
			questionTypeDao.updateByPrimaryKeySelective(questionType);
			shortAnswer.setContent(shortAnswerDto.getContent());
			shortAnswer.setAnswer(shortAnswerDto.getAnswer());
			shortAnswer.setShortanswerid(shortAnswerDto.getShortAnswerId());
			shortAnswerDao.updateByPrimaryKeySelective(shortAnswer);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateSolving(SolvingDto solvingDto) {
		// TODO Auto-generated method stub
		if(solvingDto!=null){
			QuestionType questionType=new QuestionType();
			SolvingWithBLOBs solving=new SolvingWithBLOBs();
			questionType.setQuestiontypeId(solvingDto.getQuestionTypeId());
			questionType.setIndicator(solvingDto.getIndicator());
			questionType.setLevel(solvingDto.getLevel());
			questionType.setType(solvingDto.getType());
			questionType.setSubjectId(solvingDto.getSubjectId());
			questionType.setType(solvingDto.getType());
			questionType.setTeacherId(solvingDto.getTeacherId());
			questionTypeDao.updateByPrimaryKeySelective(questionType);
			solving.setContent(solvingDto.getContent());
			solving.setAnswer(solvingDto.getAnswer());
			solving.setSolvingId(solvingDto.getSolvingId());
			solvingDao.updateByPrimaryKeySelective(solving);
			return true;
		}else{
			return false;
		}
	}

	
	
	
	

}
