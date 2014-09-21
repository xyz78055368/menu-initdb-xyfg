package com.groupshop.entity;


import java.sql.Date;


/**
* 通过数据库内表的字段动态生成 javabean
**/
public class Dtable 
{	
	private int id;
	private int tablecate;
	private String tableno;
	private String tablename;
	private String remark;

	public Dtable()
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
	public void setTablecate(int tablecate)
	{
		this.tablecate = tablecate;
	}
	public int getTablecate()
	{
		return this.tablecate;
	}
	public void setTableno(String tableno)
	{
		this.tableno = tableno;
	}
	public String getTableno()
	{
		return this.tableno;
	}
	public void setTablename(String tablename)
	{
		this.tablename = tablename;
	}
	public String getTablename()
	{
		return this.tablename;
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
