package com.groupshop.entity;


import java.sql.Date;


/**
* 通过数据库内表的字段动态生成 javabean
**/
public class Cate 
{	
	private int id;
	private String catename;
	private String catepic;
	private int catelocate;
	private int cateuppercate;
	private String remark;

	public Cate()
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
	public void setCatename(String catename)
	{
		this.catename = catename;
	}
	public String getCatename()
	{
		return this.catename;
	}
	public void setCatepic(String catepic)
	{
		this.catepic = catepic;
	}
	public String getCatepic()
	{
		return this.catepic;
	}
	public void setCatelocate(int catelocate)
	{
		this.catelocate = catelocate;
	}
	public int getCatelocate()
	{
		return this.catelocate;
	}
	public void setCateuppercate(int cateuppercate)
	{
		this.cateuppercate = cateuppercate;
	}
	public int getCateuppercate()
	{
		return this.cateuppercate;
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
