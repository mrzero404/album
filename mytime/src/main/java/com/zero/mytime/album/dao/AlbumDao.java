package com.zero.mytime.album.dao;


import java.util.HashMap;
import java.util.List;

import com.zero.mytime.album.damain.Album;

public interface AlbumDao {

	public void addAlbum(Album album);
	
	public void removeAlbum(Integer id);
	
	public List<Album> getAlbumForId(Integer userId);
	
	public List<Album> getAlbumForTime();
	
	/**
	 * 查询用户记录总数
	 * @return
	 */
	public int selectCount();
	
	/**
	 * 查询用户查询后新增记录总数
	 * @return
	 */
	public int selectNewCount(String time);
	
	/**
     * 分页操作，调用findByPage limit分页方法
     * @param map
     * @return
     */
	public List<Album> findByPage(HashMap<String,Object> map);


}
