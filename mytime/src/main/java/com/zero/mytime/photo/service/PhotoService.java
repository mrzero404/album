package com.zero.mytime.photo.service;

import java.util.HashMap;
import java.util.List;

import com.zero.mytime.photo.damain.Photo;

public interface PhotoService {
	
	public boolean insertUserPhoto();

	boolean insertUserPhoto(String userId, byte[] photo);
	
	public List<Photo> getPhotoByAlbumId(Integer albumId);
	
	public int editPhotoOrder(Photo[] photos);
}
