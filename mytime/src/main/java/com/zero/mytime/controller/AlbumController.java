package com.zero.mytime.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zero.mytime.damain.Album;
import com.zero.mytime.dao.AlbumDao;
import com.zero.mytime.service.AlbumService;

@Controller
public class AlbumController {

	private static final Log logger = LogFactory.getLog(AlbumController.class);
	
	@Autowired
	private AlbumDao albumDao;
	
	@Autowired
	private AlbumService albumService;
	
	/*
	 *添加相册 
	 */
	@ResponseBody  
	@RequestMapping(value="/addAlbum", method = RequestMethod.POST)
	public ResponseEntity<?> addAlbum(@RequestBody Album album){
		Map retMap = new HashMap();
		System.out.println("进入添加相册");
		albumDao.addAlbum(album);
		return new ResponseEntity<Map<String, Object>>(retMap, HttpStatus.OK);
	}
	
	
	/*
	 * 修改相册
	 */
	@ResponseBody  
	@RequestMapping(value="/editAlbum", method = RequestMethod.POST)
	public ResponseEntity<?> editAlbum(@RequestBody Album album){
		Map retMap = new HashMap();
		System.out.println("进入修改相册");
		albumDao.addAlbum(album);
		return new ResponseEntity<Map<String, Object>>(retMap, HttpStatus.OK);
	}
	
	/*
	 * 删除相册
	 */
	@ResponseBody  
	@RequestMapping(value="/removeAlbum/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> removeAlbum(@PathVariable Integer id){
		Map retMap = new HashMap();
		System.out.println("进入删除相册");
		albumDao.removeAlbum(id);
		return new ResponseEntity<Map<String, Object>>(retMap, HttpStatus.OK);
	}
	

	/*
	 *根据用户ID获取相册 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody  
	@RequestMapping(value="/getAlbumForUserId/{userId}", method = RequestMethod.POST)
	public ResponseEntity<?> getAlbumForId(@PathVariable Integer userId){
		Map retMap = new HashMap();
		System.out.println("进入获取相册ForId");
		retMap.put("AlbumForUserIdMap", albumDao.getAlbumForId(userId));
		retMap.put("code", "10000");
		return new ResponseEntity<Map<String, Object>>(retMap, HttpStatus.OK);
	}
	
	/*
	 *根据相册创建时间获取相册 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody  
	@RequestMapping(value="/getAlbumForTime", method = RequestMethod.POST)
	public ResponseEntity<?> getAlbumForTime(@RequestBody Album album){
		Map retMap = new HashMap();
		System.out.println("进入添加相册");
		retMap.put("code", "10000");
		retMap.put("getAlbumForTime", albumDao.getAlbumForTime());
		retMap.put("count", albumService.selectCount());
		retMap.put("page", albumService.findByPage(1));
		return new ResponseEntity<Map<String, Object>>(retMap, HttpStatus.OK);
	}
	
}
