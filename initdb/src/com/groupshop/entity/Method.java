package com.groupshop.entity;


import java.sql.Date;


/**
* 通过数据库内表的字段动态生成 javabean
**/
public class Method 
{	
	private int id;
	private String method;
	private int dishid;
	private double meprice;
	private String mecaption;
	private String remark;

	public Method()
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
	public void setMethod(String method)
	{
		this.method = method;
	}
	public String getMethod()
	{
		return this.method;
	}
	public void setDishid(int dishid)
	{
		this.dishid = dishid;
	}
	public int getDishid()
	{
		return this.dishid;
	}
	public void setMeprice(double meprice)
	{
		this.meprice = meprice;
	}
	public double getMeprice()
	{
		return this.meprice;
	}
	public void setMecaption(String mecaption)
	{
		this.mecaption = mecaption;
	}
	public String getMecaption()
	{
		return this.mecaption;
	}
	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	public String getRemark()
	{
		return this.remark;
	}
}
