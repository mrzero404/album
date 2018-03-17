package com.zero.mytime.photo.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.zero.mytime.photo.damain.Photo;
import com.zero.mytime.photo.dao.PhotoDao;

@Repository("PhotoDao")
public class PhotoDaoImpl extends SqlSessionDaoSupport implements PhotoDao {

	@Autowired(required = false)
    @Qualifier("sqlSessionFactory")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
	
	@Override
	public void addPhoto(Photo photo) {
		this.getSqlSession().insert("com.zero.mytime.photo.dao.PhotoMapper.insertPhoto",photo);
	}

	@Override
	public void removePhoto(Integer id) {

	}

	@Override
	public List<Photo> getPhotoByAlbumId(Integer albumId) {
		return this.getSqlSession().selectList("com.zero.mytime.photo.dao.PhotoMapper.selectByAlbumId",albumId);
	}

	@Override
	public int editPhotoOrder(Photo photo) {
		return this.getSqlSession().update("com.zero.mytime.photo.dao.PhotoMapper.updateOrderById", photo);
	}

	@Override
	public void deletePhotoById(Integer id) {
		this.getSqlSession().delete("com.zero.mytime.photo.dao.PhotoMapper.deletePhotoById", id);
	}

	


}
