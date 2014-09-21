package com.groupshop.entity;


import java.sql.Date;


/**
* 通过数据库内表的字段动态生成 javabean
**/
public class Dtablecate 
{	
	private int id;
	private String cate;
	private String cateno;
	private String remark;

	public Dtablecate()
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
	public void setCate(String cate)
	{
		this.cate = cate;
	}
	public String getCate()
	{
		return this.cate;
	}
	public void setCateno(String cateno)
	{
		this.cateno = cateno;
	}
	public String getCateno()
	{
		return this.cateno;
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
