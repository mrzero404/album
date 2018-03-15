package com.zero.mybatis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zero.mytime.service.AlbumService;
import com.zero.test.SpringTestBase;

public class TestMybatis extends SpringTestBase{

	@Autowired
    private AlbumService albumService;
	
	@Test
	public void testselectUserList() {
		
		System.out.println("总记录数：" + albumService.selectCount());
//		PageBean<Album> lists = new PageBean<Album>();
//		lists = albumService.findByPage(1);
//		List<Album> list = lists.getLists();
//		Iterator<Album> it = list.iterator();
//		while (it.hasNext()) {
//			Album user = it.next();
//			System.out.println(user.toString());
//		}
	}
}
