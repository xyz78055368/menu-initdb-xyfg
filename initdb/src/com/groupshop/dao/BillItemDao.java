package com.groupshop.dao;

import java.util.List;

public interface BillItemDao {
	
	public String getBillItemNo(String tName);	//ͨ����λ���ƻ�ø���λ���˵����
	
	public List getBillItemByList(String billNo);	//ͨ���˵���ŵõ��˵���ϸ����
	
	public String billItem(String tName);
}
