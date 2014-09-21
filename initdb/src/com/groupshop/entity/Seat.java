package com.groupshop.entity;


import java.sql.Date;


/**
* 通过数据库内表的字段动态生成 javabean
**/
public class Seat 
{	
	private int id;
	private String cwbh;
	private String cwmc;
	private String zwbh;
	private String zwmc;

	public Seat()
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
	public void setCwbh(String cwbh)
	{
		this.cwbh = cwbh;
	}
	public String getCwbh()
	{
		return this.cwbh;
	}
	public void setCwmc(String cwmc)
	{
		this.cwmc = cwmc;
	}
	public String getCwmc()
	{
		return this.cwmc;
	}
	public void setZwbh(String zwbh)
	{
		this.zwbh = zwbh;
	}
	public String getZwbh()
	{
		return this.zwbh;
	}
	public void setZwmc(String zwmc)
	{
		this.zwmc = zwmc;
	}
	public String getZwmc()
	{
		return this.zwmc;
	}
}
