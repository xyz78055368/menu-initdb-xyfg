package com.groupshop.entity;


import java.sql.Date;


/**
* ͨ�����ݿ��ڱ���ֶζ�̬���� javabean
**/
public class Dpic 
{	
	private int id;
	private String picname;
	private Date time;

	public Dpic()
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
	public void setPicname(String picname)
	{
		this.picname = picname;
	}
	public String getPicname()
	{
		return this.picname;
	}
	public void setTime(Date time)
	{
		this.time = time;
	}
	public Date getTime()
	{
		return this.time;
	}
}
