package com.groupshop.entity;


import java.sql.Date;


/**
* 通过数据库内表的字段动态生成 javabean
**/
public class Dishhits 
{	
	private int id;
	private String machineno;
	private int tableid;
	public int getTableid() {
		return tableid;
	}

	public void setTableid(int tableid) {
		this.tableid = tableid;
	}
	private int dishid;
	private String time;


	public Dishhits()
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
	public void setMachineno(String machineno)
	{
		this.machineno = machineno;
	}
	public String getMachineno()
	{
		return this.machineno;
	}
	
	public void setDishid(int dishid)
	{
		this.dishid = dishid;
	}
	public int getDishid()
	{
		return this.dishid;
	}
	public void setTime(String time)
	{
		this.time = time;
	}
	public String getTime()
	{
		return this.time;
	}
	
}


