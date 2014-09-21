package com.groupshop.entity;


import java.sql.Date;


/**
* 通过数据库内表的字段动态生成 javabean
**/
public class Tablebill 
{	
	private int id;
	private String billno;
	private String tableno;
	private String remark;
	private String serBillno;
	private String serTableno;
	private String serTableName;
	private int tableid;
	private double amount; 
	private String starttime;
	private int dinningpeople;
	
	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getTableid() {
		return tableid;
	}

	public void setTableid(int tableid) {
		this.tableid = tableid;
	}

	public String getSerBillno() {
		return serBillno;
	}

	public void setSerBillno(String serBillno) {
		this.serBillno = serBillno;
	}

	public String getSerTableno() {
		return serTableno;
	}

	public void setSerTableno(String serTableno) {
		this.serTableno = serTableno;
	}

	public String getSerTableName() {
		return serTableName;
	}

	public void setSerTableName(String serTableName) {
		this.serTableName = serTableName;
	}

	public Tablebill()
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
	public void setTableno(String tableno)
	{
		this.tableno = tableno;
	}
	public String getTableno()
	{
		return this.tableno;
	}
	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	public String getRemark()
	{
		return this.remark;
	}

	public int getDinningpeople() {
		return dinningpeople;
	}

	public void setDinningpeople(int dinningpeople) {
		this.dinningpeople = dinningpeople;
	}
}
