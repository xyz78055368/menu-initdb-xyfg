package com.groupshop.entity;

import java.util.Date;

public class Userlogin {
	public Userlogin(){
		
	}
	public Userlogin(String uname){
		this.setUname(uname);
		Date date = new Date();
		this.setLogTime(date);
	}
	
	private String uname;
	private Date logTime;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Date getLogTime() {
		return logTime;
	}
	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}
}
