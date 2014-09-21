package com.groupshop.entity;


import java.sql.Date;


/**
* 通过数据库内表的字段动态生成 javabean
**/
public class Transdish 
{	
	private String dishbh;
	private String cmbh;
	private String cmmc;

	public Transdish()
	{

	}

	public void setDishbh(String dishbh)
	{
		this.dishbh = dishbh;
	}
	public String getDishbh()
	{
		return this.dishbh;
	}
	public void setCmbh(String cmbh)
	{
		this.cmbh = cmbh;
	}
	public String getCmbh()
	{
		return this.cmbh;
	}
	public void setCmmc(String cmmc)
	{
		this.cmmc = cmmc;
	}
	public String getCmmc()
	{
		return this.cmmc;
	}
}
