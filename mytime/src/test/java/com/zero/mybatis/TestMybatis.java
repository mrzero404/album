package com.zero.mybatis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zero.mytime.album.damain.Album;
import com.zero.mytime.album.dao.AlbumDao;
import com.zero.mytime.album.service.AlbumService;
import com.zero.mytime.util.PageBean;
import com.zero.test.SpringTestBase;

public class TestMybatis extends SpringTestBase{

	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private AlbumDao albumDao;
	
	@Test
	public void testFindByPage() {
		System.out.println("总记录数：" + albumService.selectCount());
		PageBean<Album> lists = new PageBean<Album>();
		lists = albumService.findByPage(5,"2017-3-18 17:12");
		List<Album> list = lists.getLists();
		Iterator<Album> it = list.iterator();
		while (it.hasNext()) {
			Album user = it.next();
			System.out.println(user.toString());
		}
	}
	
	@Test
	public void testSelectNewCount() {
		System.out.println("新增总记录数：" + albumDao.selectNewCount("2017-3-18 17:12"));
	}
}
