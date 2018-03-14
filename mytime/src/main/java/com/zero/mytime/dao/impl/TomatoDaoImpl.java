package com.zero.mytime.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.zero.mytime.damain.Tomato;
import com.zero.mytime.dao.TomatoDao;
@Repository("tomatoDaoImpl")
public class TomatoDaoImpl extends SqlSessionDaoSupport implements TomatoDao {
	@Autowired(required = false)
    @Qualifier("sqlSessionFactory")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
	@Override
	public List<Tomato> getTomatos(String today) {
		return this.getSqlSession().selectList("com.zero.mytime.dao.TomatoMapper.selectTomato",today);
	}
	@Override
	public void addTomato(Tomato tomato) {
		this.getSqlSession().insert("com.zero.mytime.dao.TomatoMapper.insertTomato",tomato);
	}
	
	public void removeTomato(Integer id) {
		this.getSqlSession().delete("com.zero.mytime.dao.TomatoMapper.deleteTomato",id);
	}
	
	
}
