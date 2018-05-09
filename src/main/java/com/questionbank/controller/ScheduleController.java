package com.questionbank.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.questionbank.dto.ScheduleDto;
import com.questionbank.util.ResultInfo;

@RestController
public class ScheduleController extends BaseController{

	@RequestMapping(value="/schedule",method=RequestMethod.POST,consumes="application/json")
	public ResultInfo addSchedule(@RequestBody ScheduleDto scheduleDto){
		ResultInfo resultInfo=new ResultInfo();
		if(scheduleDto!=null){
			scheduleService.addSchedule(scheduleDto);
			resultInfo.setCode(200);
			resultInfo.setData("请求成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
		
	}
	
	@RequestMapping(value="/schedule/{scheduleId}",method=RequestMethod.DELETE)
	public ResultInfo deleteSchedule(@PathVariable("scheduleId")Integer scheduleId){
		ResultInfo resultInfo=new ResultInfo();
		if(scheduleId!=null){
			scheduleService.deleteScheduleByScheduleId(scheduleId);
			resultInfo.setCode(200);
			resultInfo.setData("请求成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
	}
	
	@RequestMapping(value="/schedule",method=RequestMethod.PUT,consumes="application/json")
	public ResultInfo updateSchedule(@RequestBody ScheduleDto scheduleDto){
		ResultInfo resultInfo=new ResultInfo();
		if(scheduleDto!=null){
			scheduleService.updateSchedule(scheduleDto);
			resultInfo.setCode(200);
			resultInfo.setData("请求成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
	}
	
	@RequestMapping(value="/schedule",method=RequestMethod.GET)
	public ResultInfo getAllSchedule(){
		ResultInfo resultInfo=new ResultInfo();
		List<ScheduleDto> scheduleDto=null;
		if((scheduleDto=scheduleService.getAllScheduleDto())!=null){
			resultInfo.setCode(200);
			resultInfo.setData(scheduleDto);
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
	}
	
	
	
}
