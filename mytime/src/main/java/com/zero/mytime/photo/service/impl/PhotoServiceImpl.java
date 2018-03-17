package com.zero.mytime.photo.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zero.mytime.photo.damain.Photo;
import com.zero.mytime.photo.dao.PhotoDao;
import com.zero.mytime.photo.service.PhotoService;

@Service("photoService")
public class PhotoServiceImpl implements PhotoService{
	
	@Autowired
	private PhotoDao photoDao;

	@Override
	public boolean insertUserPhoto(String userId, byte[] photo) {
	
		return false;
	}

	@Override
	public boolean insertUserPhoto() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Photo> getPhotoByAlbumId(Integer albumId) {
		return photoDao.getPhotoByAlbumId(albumId);
	}

	@Override
	public int editPhotoOrder(Photo[] photos) {
		for(Photo photo : photos) {
			photoDao.editPhotoOrder(photo);
		}
		return 0;
	}

}
