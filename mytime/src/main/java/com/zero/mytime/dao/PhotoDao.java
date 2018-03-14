package com.zero.mytime.dao;

import com.zero.mytime.damain.Photo;

public interface PhotoDao {

	public void addPhoto(Photo photo);
	
	public void removePhoto(Integer id);
}
