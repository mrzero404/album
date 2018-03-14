package com.zero.mytime.service;

import java.util.List;

import com.zero.mytime.damain.Tomato;

public interface TomatoService {
	/*
	 * 获取今天完成的任务
	 */
	public List<Tomato> getTodayTomatos();
	
	/*
	 * 添加完成的任务
	 */
	public void addTomato(Tomato tomato);

	public void removeTomato(Integer id);
	
}
