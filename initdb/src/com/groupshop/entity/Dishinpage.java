package com.groupshop.entity;


import java.sql.Date;


/**
* 通过数据库内表的字段动态生成 javabean
**/
public class Dishinpage 
{	
	private int id;
	private String name;
	private int dishid;
	private int tag2;

	public Dishinpage()
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
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	public void setDishid(int dishid)
	{
		this.dishid = dishid;
	}
	public int getDishid()
	{
		return this.dishid;
	}
	public void setTag2(int tag2)
	{
		this.tag2 = tag2;
	}
	public int getTag2()
	{
		return this.tag2;
	}
}
