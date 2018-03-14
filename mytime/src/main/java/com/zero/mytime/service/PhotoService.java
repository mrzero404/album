package com.zero.mytime.service;

public interface PhotoService {
	
	public boolean insertUserPhoto();

	boolean insertUserPhoto(String userId, byte[] photo);
}
