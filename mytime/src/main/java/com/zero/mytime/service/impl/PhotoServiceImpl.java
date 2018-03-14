package com.zero.mytime.service.impl;

import org.springframework.stereotype.Service;

import com.zero.mytime.service.PhotoService;

@Service("photoService")
public class PhotoServiceImpl implements PhotoService{

	@Override
	public boolean insertUserPhoto(String userId, byte[] photo) {
	
		return false;
	}

	@Override
	public boolean insertUserPhoto() {
		// TODO Auto-generated method stub
		return false;
	}

}
