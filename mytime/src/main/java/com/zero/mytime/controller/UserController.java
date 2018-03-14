package com.zero.mytime.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zero.mytime.damain.User;
import com.zero.mytime.dao.UserDao;

@Controller
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@ResponseBody  
	@RequestMapping(value="/addUser", method = RequestMethod.POST)
	public ResponseEntity<?> addUser(HttpServletRequest request,Model model){
		Map retMap = new HashMap();
		System.out.println("进入用户控制");
		User user = new User();
		user.setName("hello");
		user.setPassWord("helloworld");
		userDao.addUser(user);
		return new ResponseEntity<Map<String, Object>>(retMap, HttpStatus.OK);
	}
}
