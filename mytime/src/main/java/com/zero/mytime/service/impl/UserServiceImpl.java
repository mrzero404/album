package com.zero.mytime.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zero.mytime.damain.User;
import com.zero.mytime.dao.UserDao;
import com.zero.mytime.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired  
    private UserDao userDao;  
	
	@Override
	public void regist(User user) {
		userDao.addUser(user);
	}

//	@Override
//	public void login(String name, String password) {
//		userDao.findUserByNameAndPwd(name, password);
//	}
}
