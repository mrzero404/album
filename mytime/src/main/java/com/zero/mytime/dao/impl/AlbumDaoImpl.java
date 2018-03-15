package com.zero.mytime.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.zero.mytime.damain.Album;
import com.zero.mytime.dao.AlbumDao;

@Repository("AlbumDao")
public class AlbumDaoImpl extends SqlSessionDaoSupport implements AlbumDao {

	@Autowired(required = false)
    @Qualifier("sqlSessionFactory")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
	
	@Override
	public void addAlbum(Album album) {
		this.getSqlSession().insert("com.zero.mytime.dao.AlbumMapper.insertAlbum",album);
	}

	@Override
	public void removeAlbum(Integer id) {
		this.getSqlSession().delete("com.zero.mytime.dao.AlbumMapper.removeAlbum",id);
	}

	@Override
	public List<Album> getAlbumForId(Integer userId) {
		return this.getSqlSession().selectList("com.zero.mytime.dao.AlbumMapper.selectAlbum",userId);
	}

}
