package com.zero.mytime.dao;

import java.util.List;

import com.zero.mytime.damain.Photo;

public interface PhotoDao {

	public void addPhoto(Photo photo);
	
	public void removePhoto(Integer id);
	
	public List<Photo> getPhotoByAlbumId(Integer albumId);
	
	public int editPhotoOrder(Photo photo);
	
	public void deletePhotoById(Integer id);
}
