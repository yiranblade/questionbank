package com.questionbank.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.questionbank.domain.User;
import com.questionbank.util.MD5Utils;
import com.questionbank.util.ResultInfo;

@RestController
public class UserController extends BaseController{
	
	@RequestMapping(value="/user",method=RequestMethod.POST,consumes="application/json")
	public ResultInfo addNewUser(@RequestBody User user){
		ResultInfo resultInfo=new ResultInfo();
		if(user!=null){
			String password=user.getUserpassword();
			user.setUserpassword(MD5Utils.MD5Encode(password));
			userService.AddNewUser(user);
			resultInfo.setCode(200);
			resultInfo.setData("请求成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
	}
	
	@RequestMapping(value="/user/{userName}",method=RequestMethod.DELETE)
	public ResultInfo deleteUser(@PathVariable("userName") String userName){
		ResultInfo resultInfo=new ResultInfo();
		if(userName!=null){
			userService.deleteUser(userName);
			resultInfo.setCode(200);
			resultInfo.setData("请求成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
	}
	
	@RequestMapping(value="/user",method=RequestMethod.PUT,consumes="application/json")
	public ResultInfo updateUser(@RequestBody User user){
		ResultInfo resultInfo=new ResultInfo();
		if(user!=null){
			userService.updateUser(user);
			resultInfo.setCode(200);
			resultInfo.setData("请求成功");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("请求失败");
		}
		return resultInfo;
	}
	@RequestMapping(value="/user/login",method=RequestMethod.POST)
	public ResultInfo login(@RequestParam("userName")String userName,@RequestParam("userPassword")String userPassword){
		ResultInfo resultInfo=new ResultInfo();
		if(userName!=null&&userPassword!=null){
			String password=MD5Utils.MD5Encode(userPassword);
			if(userService.login(userName, password)){
				resultInfo.setCode(200);
				resultInfo.setData("请求成功");
				return resultInfo;
				}
		}
		
		
		resultInfo.setCode(500);
		resultInfo.setData("请求失败");
			
		
		return resultInfo;
		
	}
	
}
