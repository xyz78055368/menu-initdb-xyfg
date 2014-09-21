package com.groupshop.dao;

import java.util.List;

import com.groupshop.entity.Billitem;
import com.groupshop.entity.Cate;

public interface SqlDao {
	public int getAllDate();
	public List getTableName();
	public String getInsertSql(int i);
	public int getAllDate(double i);
	
	
	public String getInsertBillItemSql(Billitem bi,String zwmc);	//ªÒµ√≤Àµ•sql”Ôæ‰
	public Billitem getBillItem(String zwbh, int i);
	
	public int billcount(String zwbh);
	
	public List<Cate> getAllCate();
}
