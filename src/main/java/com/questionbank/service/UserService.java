package com.questionbank.service;

import com.questionbank.domain.User;

public interface UserService {
	
	public boolean AddNewUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(String userName);
	public boolean login(String userName,String passWord);

}
