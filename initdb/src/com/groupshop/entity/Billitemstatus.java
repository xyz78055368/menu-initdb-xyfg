package com.groupshop.entity;


import java.sql.Date;


/**
* ͨ�����ݿ��ڱ���ֶζ�̬���� javabean
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
