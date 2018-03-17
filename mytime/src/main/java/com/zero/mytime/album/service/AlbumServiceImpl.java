package com.zero.mytime.album.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zero.mytime.album.damain.Album;
import com.zero.mytime.album.dao.AlbumDao;
import com.zero.mytime.util.PageBean;

/**
 * Album类业务层实现类
 * @author LWY
 * @Date2018年3月15日下午
 */
@Service("AlbumService")
public class AlbumServiceImpl implements AlbumService{

	@Autowired
	private AlbumDao albumDao;
	
	@Override
	public int selectCount() {
		return albumDao.selectCount();
	}
	
	@Override
	public PageBean<Album> findByPage(int currentPage, String time) {
		HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<Album> pageBean = new PageBean<Album>();

        //封装当前页数
        pageBean.setCurrPage(currentPage);

        //每页显示的数据
        int pageSize=5;
        pageBean.setPageSize(pageSize);

        //封装总记录数
        int totalCount = albumDao.selectCount();
        pageBean.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());

        map.put("start",(currentPage-1) * pageSize + albumDao.selectNewCount(time));
        map.put("size", pageBean.getPageSize());
        //封装每页显示的数据
        List<Album> lists = albumDao.findByPage(map);
        pageBean.setLists(lists);

        return pageBean;
	}

	

}
