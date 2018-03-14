package com.zero.mytime.damain;



public class Tomato  {
	
	private Integer id;	
	private String name;	
	private String startTime;
	private String finishTime;
	private String take;
	private String record;

	public Tomato(){
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String starttime) {
		this.startTime = starttime;
	}


	public String getFinishTime() {
		return finishTime;
	}


	public void setFinishTime(String finishtime) {
		this.finishTime = finishtime;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTake() {
		return take;
	}


	public void setTake(String take) {
		this.take = take;
	}	
	
	public String getRecord() {
		return record;
	}


	public void setRecord(String record) {
		this.record = record;
	}
	
}
