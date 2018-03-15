package com.zero.mytime.dao;


import java.util.List;

import com.zero.mytime.damain.Album;

public interface AlbumDao {

	public void addAlbum(Album album);
	
	public void removeAlbum(Integer id);
	
	public List<Album> getAlbumForId(Integer userId);

}
