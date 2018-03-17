package com.zero.mytime.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zero.mytime.user.damain.User;
import com.zero.mytime.user.dao.UserDao;

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
