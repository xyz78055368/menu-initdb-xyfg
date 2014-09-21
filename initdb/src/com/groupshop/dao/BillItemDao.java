package com.groupshop.dao;

import java.util.List;

public interface BillItemDao {
	
	public String getBillItemNo(String tName);	//通过桌位名称获得该桌位的账单编号
	
	public List getBillItemByList(String billNo);	//通过账单编号得到账单明细集合
	
	public String billItem(String tName);
}
