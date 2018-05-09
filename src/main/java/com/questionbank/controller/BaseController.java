package com.questionbank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.questionbank.service.InformationService;
import com.questionbank.service.PaperService;
import com.questionbank.service.QuestionService;
import com.questionbank.service.ScheduleService;
import com.questionbank.service.UserService;

public class BaseController {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	
	@Autowired
	protected QuestionService questionService;
	@Autowired
	protected ScheduleService scheduleService;
	
	@Autowired
	protected UserService userService;
	
	@Autowired
	protected PaperService paperService;
	
	@Autowired
	protected InformationService informationService;
	
	

	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		this.request = request;
		this.response = response;
		this.session = request.getSession();
			
	}

}
