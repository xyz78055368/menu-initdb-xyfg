package com.groupshop.entity;


import java.sql.Date;


/**
* 通过数据库内表的字段动态生成 javabean
**/
public class Communication 
{	
	private int id;
	private String url;
	private int status;

	public Communication()
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
	public void setUrl(String url)
	{
		this.url = url;
	}
	public String getUrl()
	{
		return this.url;
	}
	public void setStatus(int status)
	{
		this.status = status;
	}
	public int getStatus()
	{
		return this.status;
	}
}
