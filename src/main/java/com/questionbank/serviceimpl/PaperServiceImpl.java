package com.questionbank.serviceimpl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questionbank.dao.ChoiceMapper;
import com.questionbank.dao.FullBlankMapper;
import com.questionbank.dao.PaperAnswerMapper;
import com.questionbank.dao.PaperMapper;
import com.questionbank.dao.QuestionTypeMapper;
import com.questionbank.dao.ScheduleInfoMapper;
import com.questionbank.dao.ScheduleMapper;
import com.questionbank.dao.SetMarkMapper;
import com.questionbank.dao.ShortAnswerMapper;
import com.questionbank.dao.SolvingMapper;
import com.questionbank.dao.SubjectMapper;
import com.questionbank.domain.Choice;
import com.questionbank.domain.FullBlank;
import com.questionbank.domain.Paper;
import com.questionbank.domain.PaperAnswer;
import com.questionbank.domain.QuestionType;
import com.questionbank.domain.Schedule;
import com.questionbank.domain.ScheduleInfo;
import com.questionbank.domain.SetMark;
import com.questionbank.domain.ShortAnswer;
import com.questionbank.domain.SolvingWithBLOBs;
import com.questionbank.domain.Subject;
import com.questionbank.dto.PaperInfo;
import com.questionbank.service.PaperService;
import com.questionbank.util.Paper_Word;
import com.questionbank.util.ReSort;

@Service
public class PaperServiceImpl implements PaperService{

	@Autowired
	private ScheduleMapper scheduleDao;
	
	@Autowired 
	private SubjectMapper subjectDao;
	
	@Autowired
	private ScheduleInfoMapper scheduleInfoDao;
	
	@Autowired
	private SetMarkMapper setMarkDao;
	
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
	
	@Autowired
	private PaperMapper paperDao;
	
	@Autowired
	private PaperAnswerMapper paperAnswerDao;
	
	public Paper addNewPaperByScheduleId(Integer scheduleId) {
		// TODO Auto-generated method stub
		Paper paper=null;
		if((paper=generatePaperByScheduleId(scheduleId))!=null){
			return paper;
		}else{
			return paper;
		}
		
	}

	private Paper generatePaperByScheduleId(Integer scheduleId) {
		// TODO Auto-generated method stub
		Map<String,Object> paperMap=new HashMap<String,Object>();
		Map<String,Object> answerMap=new HashMap<String,Object>();
		PaperInfo paperInfo=generatePaperInfoByScheduleId(scheduleId);
		Schedule schedule=scheduleDao.selectByPrimaryKey(scheduleId);
		paperMap.put("page",paperInfo.getPage());
		paperMap.put("totalpage",paperInfo.getTotalpage());
		paperMap.put("term", paperInfo.getTerm());
		paperMap.put("subject", paperInfo.getSubject());
		paperMap.put("type", paperInfo.getType());
		paperMap.put("grade", paperInfo.getGrade());
		
		answerMap.put("term",paperInfo.getTerm());
		answerMap.put("subject",paperInfo.getSubject());
		answerMap.put("type", paperInfo.getType());
		answerMap.put("grade",paperInfo.getGrade());
		
		
		paperMap.put("questiontype1", paperInfo.getQuestiontype1());
		paperMap.put("everymark1", paperInfo.getEverymark1());
		paperMap.put("totalmark1", paperInfo.getTotalmark1());
		paperMap.put("question1", paperInfo.getQuestion1());
		
		answerMap.put("questiontype1", paperInfo.getQuestiontype1());
		answerMap.put("question1", paperInfo.getAnswer1());
		
		paperMap.put("questiontype2", paperInfo.getQuestiontype2());
		paperMap.put("everymark2", paperInfo.getEverymark2());
		paperMap.put("totalmark2", paperInfo.getTotalmark2());
		paperMap.put("question2", paperInfo.getQuestion2());
		
		answerMap.put("questiontype2", paperInfo.getQuestiontype2());
		answerMap.put("question2", paperInfo.getAnswer2());
		
		paperMap.put("questiontype3", paperInfo.getQuestiontype3());
		paperMap.put("everymark3", paperInfo.getEverymark3());
		paperMap.put("totalmark3", paperInfo.getTotalmark3());
		paperMap.put("question3", paperInfo.getQuestion3());
		
		answerMap.put("questiontype3", paperInfo.getQuestiontype3());
		answerMap.put("question3", paperInfo.getAnswer3());
		
		paperMap.put("questiontype4", paperInfo.getQuestiontype4());
		paperMap.put("everymark4", paperInfo.getEverymark4());
		paperMap.put("totalmark4", paperInfo.getTotalmark4());
		paperMap.put("question4", paperInfo.getQuestion4());
		
		answerMap.put("questiontype4", paperInfo.getQuestiontype4());
		answerMap.put("question4", paperInfo.getAnswer4());
		
		File file=null;
		File file2=null;
		Paper paper=new Paper();
		PaperAnswer paperAnswer=new PaperAnswer();
		try{
			file=Paper_Word.createDoc(paperMap, "test");
			file2=Paper_Word.createDoc(answerMap, "testA");
			String filePath=file.getAbsolutePath();
			String filePath2=file2.getAbsolutePath();
			paper.setContent(filePath);
			paper.setScheduleId(scheduleId);
			paper.setSubjectId(schedule.getSubjectId());
			paper.setTeacherId(schedule.getTeacherId());
			paperDao.insertSelective(paper);
			Integer paperId=paperDao.selectLastId();
			paper.setPaperId(paperId);
			paperAnswer.setPaperid(paperId);
			paperAnswer.setContent(filePath2);
			paperAnswerDao.insertSelective(paperAnswer);
			
		}catch(Exception e){
			
		}
		return paper;
	}
	private PaperInfo generatePaperInfoByScheduleId(Integer scheduleId){
		Schedule schedule=scheduleDao.selectByPrimaryKey(scheduleId);
		Subject subject=subjectDao.selectByPrimaryKey(schedule.getSubjectId());
		List<SetMark> setMarks=setMarkDao.selectByScheduleId(scheduleId);
		List<ScheduleInfo> scheduleInfos=scheduleInfoDao.selectByScheduleId(scheduleId);
		List<ScheduleInfo> scheduleInfosA=null;//用来存储每种题型的详细计划
		PaperInfo paperInfo=new PaperInfo();
		paperInfo.setPage(1);
		paperInfo.setTotalpage(3);
		paperInfo.setTerm(schedule.getTerm());
		paperInfo.setSubject(subject.getSubjectName());
		paperInfo.setType(schedule.getAbType()==0?"A":"B");
		paperInfo.setGrade(schedule.getGrade());
		paperInfo.setQuestiontype1(getTypeByNumber(1));
		SetMark setMark=getQuestionMark(1, setMarks);
		scheduleInfosA=getScheduleInfoByType(1, scheduleInfos);
		paperInfo.setEverymark1(setMark.getMark());
		paperInfo.setTotalmark1(setMark.getMark()*setMark.getCount());
		List<StringBuilder> question1=getQuestionByType(1,scheduleInfosA);
		paperInfo.setQuestion1(question1.get(0).toString());
		paperInfo.setAnswer1(question1.get(1).toString());
		
		paperInfo.setQuestiontype2(getTypeByNumber(2));
		setMark=getQuestionMark(2, setMarks);
		scheduleInfosA=getScheduleInfoByType(2, scheduleInfos);
		paperInfo.setEverymark2(setMark.getMark());
		paperInfo.setTotalmark2(setMark.getMark()*setMark.getCount());
		List<StringBuilder> question2=getQuestionByType(2,scheduleInfosA);
		paperInfo.setQuestion2(question2.get(0).toString());
		paperInfo.setAnswer2(question2.get(1).toString());
		
		
		paperInfo.setQuestiontype3(getTypeByNumber(3));
		setMark=getQuestionMark(3, setMarks);
		scheduleInfosA=getScheduleInfoByType(3, scheduleInfos);
		paperInfo.setEverymark3(setMark.getMark());
		paperInfo.setTotalmark3(setMark.getMark()*setMark.getCount());
		List<StringBuilder> question3=getQuestionByType(3,scheduleInfosA);
		paperInfo.setQuestion3(question3.get(0).toString());
		paperInfo.setAnswer3(question3.get(1).toString());
		
		paperInfo.setQuestiontype4(getTypeByNumber(4));
		setMark=getQuestionMark(4, setMarks);
		scheduleInfosA=getScheduleInfoByType(4, scheduleInfos);
		paperInfo.setEverymark4(setMark.getMark());
		paperInfo.setTotalmark4(setMark.getMark()*setMark.getCount());
		List<StringBuilder> question4=getQuestionByType(4,scheduleInfosA);
		paperInfo.setQuestion4(question4.get(0).toString());
		paperInfo.setAnswer4(question4.get(1).toString());
		
		return paperInfo;
	}
	
	private String getTypeByNumber(Integer number){
		switch(number){
			case 1:return "选择题";
			case 2:return "填空题";
			case 3:return "简答题";
			case 4:return "应用题";
			default:return null;
		}
	}
	//获取不同题型的赋分方案
	private SetMark getQuestionMark(Integer number,List<SetMark> setMarks){
		SetMark setMark=null;
		for(SetMark setMarkt:setMarks){
			if(setMarkt.getType()==number){
				setMark=setMarkt;
				break;
			}
		}
		return setMark;
	}
	//获取每种题型的详细指标方案
	private List<ScheduleInfo> getScheduleInfoByType(Integer type,List<ScheduleInfo> scheduleInfos){
		List<ScheduleInfo> scheduleInfosa=new ArrayList<ScheduleInfo>();
		for(ScheduleInfo scheduleInfo:scheduleInfos){
			if(type==scheduleInfo.getType()){
				scheduleInfosa.add(scheduleInfo);
			}
		}
		return scheduleInfosa;
	}
	
	//此处为用来从题库中抽取题目与答案的代码
	private List<StringBuilder> getQuestionByType(Integer type,List<ScheduleInfo> scheduleInfos){
		ReSort.sortIntMethod(scheduleInfos);
		List<QuestionType> questionTypes=null;
		List<StringBuilder> strings=null;
		StringBuilder question=null;
		StringBuilder answer=null;
		if(type==1){
			QuestionType questionType=null;
			question=new StringBuilder();
			answer=new StringBuilder();
			strings=new ArrayList<StringBuilder>();
			
			for(int i=0;i<scheduleInfos.size(); i++){
				questionTypes=questionTypeDao.selectQuestionTypeByScheduleInfo(scheduleInfos.get(i));
				if(questionTypes.size()>=1){
					questionType=questionTypes.get(i);
					Choice choice=choiceDao.selectChoiceByQuestionTypeId(questionType.getQuestiontypeId());
					question.append((i+1)+","+choice.getContent()+"<w:br />");
					question.append(choice.getChoiceOne()+"   "+choice.getChoiceTwo()+" "+choice.getChoiceThree()+"   "+choice.getChoiceFour()+"<w:br />");
					answer.append((i+1)+","+choice.getAnswer());
				}
			}
			strings.add(question);
			strings.add(answer);
		}else if(type==2){
			QuestionType questionType=null;
			question=new StringBuilder();
			answer=new StringBuilder();
			strings=new ArrayList<StringBuilder>();
			for(int i=0;i<scheduleInfos.size(); i++){
				questionTypes=questionTypeDao.selectQuestionTypeByScheduleInfo(scheduleInfos.get(i));
				if(questionTypes.size()>=1){
					questionType=questionTypes.get(i);
					FullBlank fullBlank=fullBlankDao.selectFullBlankByQuestionTypeId(questionType.getQuestiontypeId());
					question.append((i+1)+","+fullBlank.getContent()+"<w:br />");
					answer.append((i+1)+","+fullBlank.getAnswer()+"<w:br />");
				}
			}
			strings.add(question);
			strings.add(answer);
		}else if(type==3){
			QuestionType questionType=null;
			question=new StringBuilder();
			answer=new StringBuilder();
			strings=new ArrayList<StringBuilder>();
			for(int i=0;i<scheduleInfos.size(); i++){
				questionTypes=questionTypeDao.selectQuestionTypeByScheduleInfo(scheduleInfos.get(i));
				if(questionTypes.size()>=1){
					questionType=questionTypes.get(i);
					ShortAnswer shortAnswer=shortAnswerDao.selectShortAnswerByQuestionTypeId(questionType.getQuestiontypeId());
					question.append((i+1)+","+shortAnswer.getContent()+"<w:br />");
					answer.append((i+1)+","+shortAnswer.getAnswer()+"<w:br />");
				}
			}
			strings.add(question);
			strings.add(answer);
		}else if(type==4){
			QuestionType questionType=null;
			question=new StringBuilder();
			answer=new StringBuilder();
			strings=new ArrayList<StringBuilder>();
			for(int i=0;i<scheduleInfos.size(); i++){
				questionTypes=questionTypeDao.selectQuestionTypeByScheduleInfo(scheduleInfos.get(i));
				if(questionTypes.size()>=1){
					questionType=questionTypes.get(i);
					SolvingWithBLOBs solving=solvingDao.selectByQuestionTypeId(questionType.getQuestiontypeId());
					question.append((i+1)+","+solving.getContent()+"<w:br />");
					answer.append((i+1)+","+solving.getAnswer()+"<w:br />");
				}
			}
			strings.add(question);
			strings.add(answer);
		}
		
		return strings;
	}

	@Override
	public PaperAnswer getPaperAnswerByPaperId(Integer paperId) {
		// TODO Auto-generated method stub
		if(paperId!=null){
			PaperAnswer paperAnswer=paperAnswerDao.selectByPaperId(paperId);
			return paperAnswer;
		}
		return null;
	}

	
}
