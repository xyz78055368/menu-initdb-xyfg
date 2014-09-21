package com.groupshop.entity;


import java.sql.Date;


/**
* 通过数据库内表的字段动态生成 javabean
**/
public class Billitemstatus 
{	
	private int id;
	private String statusname;

	public Billitemstatus()
	{

	}

	public void setId(int id)
	{
		this.id = id;
	}
	public int getId()
	{
		return this.id;
	}
	public void setStatusname(String statusname)
	{
		this.statusname = statusname;
	}
	public String getStatusname()
	{
		return this.statusname;
	}
}
