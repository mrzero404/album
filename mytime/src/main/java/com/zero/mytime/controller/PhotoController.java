package com.zero.mytime.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zero.mytime.damain.Photo;
import com.zero.mytime.damain.Test;
import com.zero.mytime.damain.User;
import com.zero.mytime.dao.PhotoDao;
import com.zero.mytime.dao.UserDao;
import com.zero.mytime.service.PhotoService;
@Controller
public class PhotoController {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private PhotoDao photoDao;
	
	@RequestMapping(value = "/addPhoto", method = RequestMethod.POST)
	public String addPhoto(User user,HttpServletRequest request,Model model) throws Exception, IOException {
		// 保存数据库的路径
		String sqlPath = null;
		// 定义文件保存的本地路径
		String localPath = "D:\\File\\";
		// 定义 文件名
		String filename = null;
		if (!user.getFile().isEmpty()) {
			// 生成uuid作为文件名称
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			// 获得文件类型（可以判断如果不是图片，禁止上传）
			String contentType = user.getFile().getContentType();
			// 获得文件后缀名
			String suffixName = contentType.substring(contentType.indexOf("/") + 1);
			// 得到 文件名
			filename = uuid + "." + suffixName;
			// 文件保存路径
			user.getFile().transferTo(new File(localPath + filename));
		}
		// 把图片的相对路径保存至数据库
		sqlPath = "/images/" + filename;
		user.setImage(sqlPath);
		userDao.addUser(user);
		Photo photo = new Photo();
		photo.setPath(sqlPath);
		photo.setAlbumId(1);
		photo.setOrders(1);
		photoDao.addPhoto(photo);
		model.addAttribute("user", user);
		return "MyJsp2"; 
	}
	
	@RequestMapping(value = "/UserPhoto")
	public String UserPhoto(User user,HttpServletRequest request,Model model) throws Exception, IOException {
		System.out.println("进入myjsp");
		return "MyJsp";
	}
	
	/*
	 * 获取图片
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/getPhoto", method = RequestMethod.POST)
	public ResponseEntity<?> getPhoto(@RequestBody Map<String, Object> map) {
		System.out.println("进入获取图片Controller");
		Integer albumId =Integer.valueOf( map.get("albumId").toString());
		HashMap retMap = new HashMap();
		retMap.put("photoList", photoService.getPhotoByAlbumId(albumId));
		return new ResponseEntity<Map<String, Object>>(retMap, HttpStatus.OK);
	}
	
	/*
	 * 根据传入的数组来更新图片顺序
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/editPhotoOrder", method = RequestMethod.POST)
	public ResponseEntity<?> editPhotoOrder(@RequestBody Photo[] photos) {
		System.out.println("进入更改图片顺序Controller");
		photoService.editPhotoOrder(photos);
		HashMap retMap = new HashMap();
		retMap.put("code", 10000);
		return new ResponseEntity<Map<String, Object>>(retMap, HttpStatus.OK);
	}
}
