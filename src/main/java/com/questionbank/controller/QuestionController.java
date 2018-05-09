package com.questionbank.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.questionbank.dto.ChoiceDto;
import com.questionbank.dto.FullBlankDto;
import com.questionbank.dto.ShortAnswerDto;
import com.questionbank.dto.SolvingDto;
import com.questionbank.util.ResultInfo;

@RestController
public class QuestionController extends BaseController{
	
	@RequestMapping(value="/question/choice",method=RequestMethod.POST,consumes="application/json")
	public ResultInfo addChoice(@RequestBody ChoiceDto choiceDto){
		ResultInfo resultInfo=new ResultInfo();
		if(choiceDto!=null){
			questionService.addChoice(choiceDto);
			resultInfo.setCode(200);
			resultInfo.setData("请求成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
		
	}
	
	@RequestMapping(value="/question/fullblank",method=RequestMethod.POST,consumes="application/json")
	public ResultInfo addFullBlank(@RequestBody FullBlankDto fullBlankDto){
		ResultInfo resultInfo=new ResultInfo();
		if(fullBlankDto!=null){
			questionService.addFullBlank(fullBlankDto);
			resultInfo.setCode(200);
			resultInfo.setData("请求成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
		
	}
	@RequestMapping(value="/question/shortanswer",method=RequestMethod.POST,consumes="application/json")
	public ResultInfo addShortAnswer(@RequestBody ShortAnswerDto shortAnswerDto){
		ResultInfo resultInfo=new ResultInfo();
		if(shortAnswerDto!=null){
			questionService.addShortAnswer(shortAnswerDto);
			resultInfo.setCode(200);
			resultInfo.setData("请求成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
		
	}
	
	@RequestMapping(value="/question/solving",method=RequestMethod.POST,consumes="application/json")
	public ResultInfo addSolving(@RequestBody SolvingDto solvingDto){
		ResultInfo resultInfo=new ResultInfo();
		if(solvingDto!=null){
			questionService.addSolving(solvingDto);
			resultInfo.setCode(200);
			resultInfo.setData("请求成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
		
	}
	
	@RequestMapping(value="/question",method=RequestMethod.DELETE,consumes="application/json")
	public ResultInfo deleteQuestionByQuestionId(@RequestBody Integer[] questionId){
		ResultInfo resultInfo=new ResultInfo();
		if(questionId!=null){
			questionService.deleteQuestion(questionId);
			resultInfo.setCode(200);
			resultInfo.setData("请求成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
	}
	
	@RequestMapping(value="/question/{type}",method=RequestMethod.GET)
	public ResultInfo getAllQuestionByType(@PathVariable("type")Integer type){
		ResultInfo resultInfo=new ResultInfo();
		if(type!=null){
			resultInfo.setCode(200);
			switch(type){
				case 1:resultInfo.setData(questionService.getAllChoice());break;
				case 2:resultInfo.setData(questionService.getAllFullBlank());break;
				case 3:resultInfo.setData(questionService.getAllShortAnswer());break;
				case 4:resultInfo.setData(questionService.getAllSolving());break;
				default:resultInfo.setData("请求失败");
			}
		}
		return resultInfo;
	}
	
	@RequestMapping(value="/question/choice",method=RequestMethod.PUT,consumes="application/json")
	public ResultInfo updateChoice(@RequestBody ChoiceDto choiceDto){
		ResultInfo resultInfo=new ResultInfo();
		if(choiceDto!=null){
			questionService.updateChoice(choiceDto);
			resultInfo.setCode(200);
			resultInfo.setData("请求成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		
		return resultInfo;
		
	}
	
	@RequestMapping(value="/question/fullblank",method=RequestMethod.PUT,consumes="application/json")
	public ResultInfo updatefullBlank(@RequestBody FullBlankDto fullBlankDto){
		ResultInfo resultInfo=new ResultInfo();
		if(fullBlankDto!=null){
			questionService.updateFullBlank(fullBlankDto);
			resultInfo.setCode(200);
			resultInfo.setData("请求成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		
		return resultInfo;
		
	}
	
	@RequestMapping(value="/question/shortanswer",method=RequestMethod.PUT,consumes="application/json")
	public ResultInfo updateShortAnswer(@RequestBody ShortAnswerDto shortAnswerDto){
		ResultInfo resultInfo=new ResultInfo();
		if(shortAnswerDto!=null){
			questionService.updateShortAnswer(shortAnswerDto);
			resultInfo.setCode(200);
			resultInfo.setData("请求成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		
		return resultInfo;
		
	}
	@RequestMapping(value="/question/solving",method=RequestMethod.PUT,consumes="application/json")
	public ResultInfo updatesolving(@RequestBody SolvingDto solvingDto){
		ResultInfo resultInfo=new ResultInfo();
		if(solvingDto!=null){
			questionService.updateSolving(solvingDto);
			resultInfo.setCode(200);
			resultInfo.setData("请求成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		
		return resultInfo;
		
	}
	
}
