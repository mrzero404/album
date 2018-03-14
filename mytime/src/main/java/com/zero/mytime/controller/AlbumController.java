package com.zero.mytime.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zero.mytime.damain.Album;
import com.zero.mytime.dao.AlbumDao;

@Controller
public class AlbumController {

	@Autowired
	private AlbumDao albumDao;
	
	@ResponseBody  
	@RequestMapping(value="/addAlbum", method = RequestMethod.POST)
	public ResponseEntity<?> addAlbum(@RequestBody Album album){
		Map retMap = new HashMap();
		System.out.println("进入相册控制");
		albumDao.addAlbum(album);
		return new ResponseEntity<Map<String, Object>>(retMap, HttpStatus.OK);
	}
}
