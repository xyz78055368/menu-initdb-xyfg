package com.groupshop.entity;

public class ErrorBill {
	
	public ErrorBill(){}
	
	public ErrorBill(String macno,int tableid,boolean istrue,String billitem){
		this.setMacno(macno);
		this.setBillitem(billitem);
		this.setIstrue(istrue);
		this.setTableid(tableid);
	}
	
	
	
	private String macno;
	private int tableid;
	private boolean istrue;
	private String billitem;
	public String getMacno() {
		return macno;
	}
	public void setMacno(String macno) {
		this.macno = macno;
	}
	public int getTableid() {
		return tableid;
	}
	public void setTableid(int tableid) {
		this.tableid = tableid;
	}
	public boolean isIstrue() {
		return istrue;
	}
	public void setIstrue(boolean istrue) {
		this.istrue = istrue;
	}
	public String getBillitem() {
		return billitem;
	}
	public void setBillitem(String billitem) {
		this.billitem = billitem;
	}
}
