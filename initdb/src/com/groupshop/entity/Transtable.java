package com.groupshop.entity;


import java.sql.Date;


/**
* 通过数据库内表的字段动态生成 javabean
**/
public class Transtable 
{	
	private String ipadbh;
	private String zwbh;
	private String zwmc;

	public Transtable()
	{

	}

	public void setIpadbh(String ipadbh)
	{
		this.ipadbh = ipadbh;
	}
	public String getIpadbh()
	{
		return this.ipadbh;
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
