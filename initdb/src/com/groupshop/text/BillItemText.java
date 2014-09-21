package com.groupshop.text;

import com.groupshop.dao.SqlDao;
import com.groupshop.daoImpl.SqlDaoImp;
import com.groupshop.entity.Billitem;

public class BillItemText {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String zwmc = "½ðÁú¸ó1.1 ";
//		// TODO Auto-gene"rated method stub
//		SqlDao sd = new SqlDaoImp();
//		int count = sd.billcount(zwmc);
//		System.out.println(count);
		String zwmc = "½ðÁú¸ó1.1";
		int index =1;
		System.out.println(zwmc);
		System.out.println(index);
		SqlDao sd = new SqlDaoImp();

		Billitem bi = sd.getBillItem(zwmc,index);
		String sql = sd.getInsertBillItemSql(bi,zwmc);
	}
}
