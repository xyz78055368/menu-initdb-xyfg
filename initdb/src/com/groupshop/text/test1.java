package com.groupshop.text;

import com.groupshop.dao.SqlDao;
import com.groupshop.daoImpl.SqlDaoImp;

public class test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SqlDao sd = new SqlDaoImp();
//		System.out.println(sd.getAllDate(1));
		sd.getInsertSql(3);

	}

}
