package com.zero.mytime.dao.impl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.zero.mytime.damain.User;
import com.zero.mytime.dao.UserDao;
@Repository("UserDao")
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Autowired(required = false)
    @Qualifier("sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
	
	@Override
	public void addUser(User user) {
		this.getSqlSession().insert("com.zero.mytime.dao.UserMapper.addUser",user);
	}

//	@Override
//	public void findUserByNameAndPwd(String name, String password) {
//		// TODO Auto-generated method stub
//		
//	}

}
