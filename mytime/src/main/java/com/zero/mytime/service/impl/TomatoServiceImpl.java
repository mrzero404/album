package com.zero.mytime.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zero.mytime.damain.Tomato;
import com.zero.mytime.dao.TomatoDao;
import com.zero.mytime.service.TomatoService;
@Service("tomatoService")
public class TomatoServiceImpl implements TomatoService{
	@Autowired
	private TomatoDao tomatoDao;
	@Override
	public List<Tomato> getTodayTomatos() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String today = df.format(new Date());// new Date()为获取当前系统时间
		return tomatoDao.getTomatos(today);
	}
	@Override
	public void addTomato(Tomato tomato) {
		tomatoDao.addTomato(tomato);
	}
	@Override
	public void removeTomato(Integer id) {
		tomatoDao.removeTomato(id);
	}

}
