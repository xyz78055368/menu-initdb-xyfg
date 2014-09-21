package com.groupshop.entity;


import java.sql.Date;


/**
* 通过数据库内表的字段动态生成 javabean
**/
public class Ipad_billitem 
{	
	private String billno;
	private int status;
	private String uid;
	private String show;
	private String item_id;
	private double item_discount;
	private String tableid;
	private double item_pric;
	private Date ordertime;
	private String item_name;
	private String item_remark;
	private int itemcount;
	private double item_amount;
	private double item_total;
	private String item_spec;
	private String opt;
	private String communi;
	private String userid;
	private int item_num;
	private String kitchen;
	private int count;
	private String waiter;
	private String macid;

	public Ipad_billitem()
	{

	}

	public void setBillno(String billno)
	{
		this.billno = billno;
	}
	public String getBillno()
	{
		return this.billno;
	}
	public void setStatus(int status)
	{
		this.status = status;
	}
	public int getStatus()
	{
		return this.status;
	}
	public void setUid(String uid)
	{
		this.uid = uid;
	}
	public String getUid()
	{
		return this.uid;
	}
	public void setShow(String show)
	{
		this.show = show;
	}
	public String getShow()
	{
		return this.show;
	}
	public void setItem_id(String item_id)
	{
		this.item_id = item_id;
	}
	public String getItem_id()
	{
		return this.item_id;
	}
	public void setItem_discount(double item_discount)
	{
		this.item_discount = item_discount;
	}
	public double getItem_discount()
	{
		return this.item_discount;
	}
	public void setTableid(String tableid)
	{
		this.tableid = tableid;
	}
	public String getTableid()
	{
		return this.tableid;
	}
	public void setItem_pric(double item_pric)
	{
		this.item_pric = item_pric;
	}
	public double getItem_pric()
	{
		return this.item_pric;
	}
	public void setOrdertime(Date ordertime)
	{
		this.ordertime = ordertime;
	}
	public Date getOrdertime()
	{
		return this.ordertime;
	}
	public void setItem_name(String item_name)
	{
		this.item_name = item_name;
	}
	public String getItem_name()
	{
		return this.item_name;
	}
	public void setItem_remark(String item_remark)
	{
		this.item_remark = item_remark;
	}
	public String getItem_remark()
	{
		return this.item_remark;
	}
	public void setItemcount(int itemcount)
	{
		this.itemcount = itemcount;
	}
	public int getItemcount()
	{
		return this.itemcount;
	}
	public void setItem_amount(double item_amount)
	{
		this.item_amount = item_amount;
	}
	public double getItem_amount()
	{
		return this.item_amount;
	}
	public void setItem_total(double item_total)
	{
		this.item_total = item_total;
	}
	public double getItem_total()
	{
		return this.item_total;
	}
	public void setItem_spec(String item_spec)
	{
		this.item_spec = item_spec;
	}
	public String getItem_spec()
	{
		return this.item_spec;
	}
	public void setOpt(String opt)
	{
		this.opt = opt;
	}
	public String getOpt()
	{
		return this.opt;
	}
	public void setCommuni(String communi)
	{
		this.communi = communi;
	}
	public String getCommuni()
	{
		return this.communi;
	}
	public void setUserid(String userid)
	{
		this.userid = userid;
	}
	public String getUserid()
	{
		return this.userid;
	}
	public void setItem_num(int item_num)
	{
		this.item_num = item_num;
	}
	public int getItem_num()
	{
		return this.item_num;
	}
	public void setKitchen(String kitchen)
	{
		this.kitchen = kitchen;
	}
	public String getKitchen()
	{
		return this.kitchen;
	}
	public void setCount(int count)
	{
		this.count = count;
	}
	public int getCount()
	{
		return this.count;
	}
	public void setWaiter(String waiter)
	{
		this.waiter = waiter;
	}
	public String getWaiter()
	{
		return this.waiter;
	}
	public void setMacid(String macid)
	{
		this.macid = macid;
	}
	public String getMacid()
	{
		return this.macid;
	}
}
