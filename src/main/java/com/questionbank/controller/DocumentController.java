package com.questionbank.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.questionbank.domain.Paper;
import com.questionbank.domain.PaperAnswer;
import com.questionbank.domain.SchedulePaper;
import com.questionbank.util.ResultInfo;

@RestController
public class DocumentController extends BaseController{

	@RequestMapping(value="/paper/{scheduleId}",method=RequestMethod.GET)
	public ResultInfo generateNewPaper(@PathVariable("scheduleId")Integer scheduleId){
		ResultInfo resultInfo=new ResultInfo();
		if(scheduleId!=null){
			Paper paper=paperService.addNewPaperByScheduleId(scheduleId);
			if(paper.getContent()==null){
				resultInfo.setCode(200);
				resultInfo.setData("题库中可能不存在该计划相关的试题");
			}else{
				resultInfo.setCode(200);
				resultInfo.setData(paper);}
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
		
	}
	
	@RequestMapping(value="/paperanswer/{paperId}",method=RequestMethod.GET)
	public ResultInfo getPaperAnswerByPaperId(@PathVariable("paperId")Integer paperId){
		ResultInfo resultInfo=new ResultInfo();
		if(paperId!=null){
			PaperAnswer paperAnswer=paperService.getPaperAnswerByPaperId(paperId);
			resultInfo.setCode(200);
			resultInfo.setData(paperAnswer);
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
	}
	@RequestMapping(value="/schedulepaper/{scheduleId}",method=RequestMethod.GET)
	public ResultInfo getSchedulePaperById(@PathVariable("scheduleId")Integer scheduleId){
		ResultInfo resultInfo=new ResultInfo();
		if(scheduleId!=null){
			SchedulePaper schedulePaper=scheduleService.generateSchedulePaperByScheduleId(scheduleId);
			resultInfo.setCode(200);
			resultInfo.setData(schedulePaper);
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
	}
	
}
