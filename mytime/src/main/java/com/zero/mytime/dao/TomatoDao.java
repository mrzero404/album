package com.zero.mytime.dao;

import java.util.List;

import com.zero.mytime.damain.Tomato;

public interface TomatoDao {
	//获取今天的完成的任务
	public List<Tomato> getTomatos(String today);
	
	//插入现在完成的任务
	public void addTomato(Tomato tomato);
	
	public void removeTomato(Integer id);
}
