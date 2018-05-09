package com.questionbank.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.questionbank.domain.Profession;
import com.questionbank.domain.Subject;
import com.questionbank.domain.Teacher;
import com.questionbank.util.ResultInfo;

@RestController
public class InformationController extends BaseController{

	@RequestMapping(value="/teacher",method=RequestMethod.POST,consumes="application/json")
	public ResultInfo addNewTeacher(@RequestBody Teacher teacher){
		ResultInfo resultInfo=new ResultInfo();
		if(teacher!=null){
			informationService.addNewTeacher(teacher);
			resultInfo.setCode(200);
			resultInfo.setData("请求成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		
		return resultInfo;
	}
	
	@RequestMapping(value="/teacher/{teacherId}",method=RequestMethod.DELETE)
	public ResultInfo deleteTeacher(@PathVariable("teacherId")String teacherId){
		ResultInfo resultInfo=new ResultInfo();
		if(teacherId!=null){
			informationService.deleteTeacher(teacherId);
			resultInfo.setCode(200);
			resultInfo.setData("请求成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
	}
	
	@RequestMapping(value="/teacher",method=RequestMethod.PUT,consumes="application/json")
	public ResultInfo updateTeacher(@RequestBody Teacher teacher){
		ResultInfo resultInfo=new ResultInfo();
		if(teacher!=null){
			informationService.updateTeacher(teacher);
			resultInfo.setCode(200);
			resultInfo.setData("请求成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
	}
	@RequestMapping(value="/teacher/all",method=RequestMethod.GET)
	public ResultInfo getAllTeacher(){
		ResultInfo resultInfo=new ResultInfo();
		List<Teacher> teachers=null;
		teachers=informationService.getAllTeacher();
		if(teachers!=null){
			resultInfo.setCode(200);
			resultInfo.setData(teachers);
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
	}
	   
	
	@RequestMapping(value="/profession",method=RequestMethod.POST,consumes="application/json")
	public ResultInfo addNewProfession(@RequestBody Profession profession){
		ResultInfo resultInfo=new ResultInfo();
		if(profession!=null){
			informationService.addNewProfession(profession);
			resultInfo.setCode(200);
			resultInfo.setData("请求成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		
		return resultInfo;
	}
	
	@RequestMapping(value="/profession/{professionId}",method=RequestMethod.DELETE)
	public ResultInfo deleteProfession(@PathVariable("professionId")Integer professionId){
		ResultInfo resultInfo=new ResultInfo();
		if(professionId!=null){
			informationService.deleteProfession(professionId);
			resultInfo.setCode(200);
			resultInfo.setData("请求成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
	}
	
	@RequestMapping(value="/profession",method=RequestMethod.PUT,consumes="application/json")
	public ResultInfo updateProfession(@RequestBody Profession profession){
		ResultInfo resultInfo=new ResultInfo();
		if(profession!=null){
			informationService.updateProfession(profession);
			resultInfo.setCode(200);
			resultInfo.setData("请求成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
	}
	@RequestMapping(value="/profession/all",method=RequestMethod.GET)
	public ResultInfo getAllprofession(){
		ResultInfo resultInfo=new ResultInfo();
		List<Profession> professions=null;
		professions=informationService.getAllProfession();
		if(professions!=null){
			resultInfo.setCode(200);
			resultInfo.setData(professions);
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
	}
	
	@RequestMapping(value="/subject",method=RequestMethod.POST,consumes="application/json")
	public ResultInfo addNewSubject(@RequestBody Subject subject){
		ResultInfo resultInfo=new ResultInfo();
		if(subject!=null){
			informationService.addNewSubject(subject);
			resultInfo.setCode(200);
			resultInfo.setData("请求成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		
		return resultInfo;
	}
	
	@RequestMapping(value="/subject/{subjectId}",method=RequestMethod.DELETE)
	public ResultInfo deleteSubject(@PathVariable("subjectId")Integer subjectId){
		ResultInfo resultInfo=new ResultInfo();
		if(subjectId!=null){
			informationService.deleteSubject(subjectId);
			resultInfo.setCode(200);
			resultInfo.setData("请求成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
	}
	
	@RequestMapping(value="/subject",method=RequestMethod.PUT,consumes="application/json")
	public ResultInfo updateSubject(@RequestBody Subject subject){
		ResultInfo resultInfo=new ResultInfo();
		if(subject!=null){
			informationService.updateSubject(subject);
			resultInfo.setCode(200);
			resultInfo.setData("请求成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
	}
	@RequestMapping(value="/subject/all",method=RequestMethod.GET)
	public ResultInfo getAllSubject(){
		ResultInfo resultInfo=new ResultInfo();
		List<Subject> subjects=null;
		subjects=informationService.getAllSubject();
		if(subjects!=null){
			resultInfo.setCode(200);
			resultInfo.setData(subjects);
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
	}
}
