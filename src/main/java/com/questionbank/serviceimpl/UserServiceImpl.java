package com.questionbank.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questionbank.dao.UserMapper;
import com.questionbank.domain.User;
import com.questionbank.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userDao;
	
	@Override
	public boolean AddNewUser(User user) {
		// TODO Auto-generated method stub
		if(user!=null){
			userDao.insertSelective(user);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		if(user!=null){
			userDao.updateByPrimaryKeySelective(user);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteUser(String userName) {
		// TODO Auto-generated method stub
		if(userName!=null){
			userDao.deleteByPrimaryKey(userName);
		}
		return false;
	}

	@Override
	public boolean login(String userName, String passWord) {
		// TODO Auto-generated method stub
		if(userName!=null&&passWord!=null){
			User user=userDao.selectByUserName(userName);
			if(user.getUserpassword().equals(passWord)){
				return true;
			}
		}
		return false;
	}
	
	

}
