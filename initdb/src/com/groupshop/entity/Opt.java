package com.groupshop.entity;


import java.sql.Date;


/**
* 通过数据库内表的字段动态生成 javabean
**/
public class Opt 
{	
	private int id;
	private String name;
	private String code;
	private String password;
	private String auth;
	private String remark;
	private String flag;

	public Opt()
	{

	}
	public Opt(String name,String pwd){
		this.setName(name);
		this.setPassword(pwd);
	}

	public void setId(int id)
	{
		this.id = id;
	}
	public int getId()
	{
		return this.id;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	public void setCode(String code)
	{
		this.code = code;
	}
	public String getCode()
	{
		return this.code;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPassword()
	{
		return this.password;
	}
	public void setAuth(String auth)
	{
		this.auth = auth;
	}
	public String getAuth()
	{
		return this.auth;
	}
	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	public String getRemark()
	{
		return this.remark;
	}
	public void setFlag(String flag)
	{
		this.flag = flag;
	}
	public String getFlag()
	{
		return this.flag;
	}
}
