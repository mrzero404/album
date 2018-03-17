package com.zero.mytime.album.service;

import com.zero.mytime.album.damain.Album;
import com.zero.mytime.util.PageBean;

public interface AlbumService {

	public int selectCount();
	
	public PageBean<Album> findByPage(int currentPage, String time);
}
