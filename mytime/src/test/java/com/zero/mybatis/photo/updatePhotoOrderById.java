package com.zero.mybatis.photo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zero.mytime.damain.Photo;
import com.zero.mytime.dao.PhotoDao;
import com.zero.mytime.service.PhotoService;
import com.zero.test.SpringTestBase;

public class updatePhotoOrderById extends SpringTestBase{

	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private PhotoDao photoDao;
	
	@Test
	public void updatePhotoOrderById() {
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		
	}
	
}
