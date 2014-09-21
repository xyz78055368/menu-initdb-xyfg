package com.groupshop.entity;


import java.sql.Date;


/**
* 通过数据库内表的字段动态生成 javabean
**/
public class Bill 
{	
	private int id;
	private String billno;
	private String tablecate;
	private String tableno;
	private double total;
	private double amount;
	private String remark;
	private String starttime;
	private String shift;
	private String opt;
	private int dinningpeple;

	public Bill()
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
	public void setBillno(String billno)
	{
		this.billno = billno;
	}
	public String getBillno()
	{
		return this.billno;
	}
	public void setTablecate(String tablecate)
	{
		this.tablecate = tablecate;
	}
	public String getTablecate()
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
	public void setTotal(double total)
	{
		this.total = total;
	}
	public double getTotal()
	{
		return this.total;
	}
	public void setAmount(double amount)
	{
		this.amount = amount;
	}
	public double getAmount()
	{
		return this.amount;
	}
	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	public String getRemark()
	{
		return this.remark;
	}
	public void setStarttime(String starttime)
	{
		this.starttime = starttime;
	}
	public String getStarttime()
	{
		return this.starttime;
	}
	public void setShift(String shift)
	{
		this.shift = shift;
	}
	public String getShift()
	{
		return this.shift;
	}
	public void setOpt(String opt)
	{
		this.opt = opt;
	}
	public String getOpt()
	{
		return this.opt;
	}
	public void setDinningpeple(int dinningpeple)
	{
		this.dinningpeple = dinningpeple;
	}
	public int getDinningpeple()
	{
		return this.dinningpeple;
	}
}
