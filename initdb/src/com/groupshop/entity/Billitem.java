package com.groupshop.entity;


import java.sql.Date;


/**
* 通过数据库内表的字段动态生成 javabean
**/
public class Billitem 
{	
	private String wdbz;
	public String getWdbz() {
		return wdbz;
	}

	public void setWdbz(String wdbz) {
		this.wdbz = wdbz;
	}
	private int id;
	private double uid;
	private String billno;
	private String itemname;
	private double itemnum;
	private double itemprice;
	private double itemtotal;
	private double itemamount;
	private double discount;
	private int count;
	private int show;
	private int kitchen;
	private String itemremark;
	private String ordertime;
	private String opt;
	private int communi;
	private int tableid;
	private int status;
	private String waiter;
	private String itemspec;
	private int dishid;

	public Billitem()
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
	public void setUid(double uid)
	{
		this.uid = uid;
	}
	public double getUid()
	{
		return this.uid;
	}
	public void setBillno(String billno)
	{
		this.billno = billno;
	}
	public String getBillno()
	{
		return this.billno;
	}
	public void setItemname(String itemname)
	{
		this.itemname = itemname;
	}
	public String getItemname()
	{
		return this.itemname;
	}
	public void setItemnum(double itemnum)
	{
		this.itemnum = itemnum;
	}
	public double getItemnum()
	{
		return this.itemnum;
	}
	public void setItemprice(double itemprice)
	{
		this.itemprice = itemprice;
	}
	public double getItemprice()
	{
		return this.itemprice;
	}
	public void setItemtotal(double itemtotal)
	{
		this.itemtotal = itemtotal;
	}
	public double getItemtotal()
	{
		return this.itemtotal;
	}
	public void setItemamount(double itemamount)
	{
		this.itemamount = itemamount;
	}
	public double getItemamount()
	{
		return this.itemamount;
	}
	public void setDiscount(double discount)
	{
		this.discount = discount;
	}
	public double getDiscount()
	{
		return this.discount;
	}
	public void setCount(int count)
	{
		this.count = count;
	}
	public int getCount()
	{
		return this.count;
	}
	public void setShow(int show)
	{
		this.show = show;
	}
	public int getShow()
	{
		return this.show;
	}
	public void setKitchen(int kitchen)
	{
		this.kitchen = kitchen;
	}
	public int getKitchen()
	{
		return this.kitchen;
	}
	public void setItemremark(String itemremark)
	{
		this.itemremark = itemremark;
	}
	public String getItemremark()
	{
		return this.itemremark;
	}
	public void setOrdertime(String ordertime)
	{
		this.ordertime = ordertime;
	}
	public String getOrdertime()
	{
		return this.ordertime;
	}
	public void setOpt(String opt)
	{
		this.opt = opt;
	}
	public String getOpt()
	{
		return this.opt;
	}
	public void setCommuni(int communi)
	{
		this.communi = communi;
	}
	public int getCommuni()
	{
		return this.communi;
	}
	public void setTableid(int tableid)
	{
		this.tableid = tableid;
	}
	public int getTableid()
	{
		return this.tableid;
	}
	public void setStatus(int status)
	{
		this.status = status;
	}
	public int getStatus()
	{
		return this.status;
	}
	public void setWaiter(String waiter)
	{
		this.waiter = waiter;
	}
	public String getWaiter()
	{
		return this.waiter;
	}
	public void setItemspec(String itemspec)
	{
		this.itemspec = itemspec;
	}
	public String getItemspec()
	{
		return this.itemspec;
	}
	public void setDishid(int dishid)
	{
		this.dishid = dishid;
	}
	public int getDishid()
	{
		return this.dishid;
	}
}
