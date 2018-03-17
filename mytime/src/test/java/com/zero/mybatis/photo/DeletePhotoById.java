package com.zero.mybatis.photo;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zero.mytime.photo.damain.Photo;
import com.zero.mytime.photo.dao.PhotoDao;
import com.zero.mytime.photo.service.PhotoService;
import com.zero.test.SpringTestBase;

public class DeletePhotoById extends SpringTestBase{

	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private PhotoDao photoDao;
	
	@Test
	public void deletePhotoById() {
		photoDao.deletePhotoById(3);
	}
	
}
