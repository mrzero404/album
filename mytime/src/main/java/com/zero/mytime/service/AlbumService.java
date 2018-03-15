package com.zero.mytime.service;

import com.zero.mytime.damain.Album;
import com.zero.mytime.util.PageBean;

public interface AlbumService {

	public int selectCount();
	
	public PageBean<Album> findByPage(int currentPage);
}
