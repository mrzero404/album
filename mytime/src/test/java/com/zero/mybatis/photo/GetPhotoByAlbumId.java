package com.zero.mybatis.photo;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zero.mytime.photo.damain.Photo;
import com.zero.mytime.photo.dao.PhotoDao;
import com.zero.mytime.photo.service.PhotoService;
import com.zero.test.SpringTestBase;

public class GetPhotoByAlbumId extends SpringTestBase{

	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private PhotoDao photoDao;
	
	@Test
	public void getPhotoByAlbumId() {
		List<Photo> list = photoService.getPhotoByAlbumId(1);
		Iterator<Photo> it = list.iterator();
		while (it.hasNext()) {
			Photo user = it.next();
			System.out.println(user.toString());
		}
	}
	
	
}
