package com.groupshop.text;

import com.groupshop.dao.CreatTableDao;
import com.groupshop.daoImpl.CreatTableDaoImp;

public class CreatTableDaoImpText {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CreatTableDao ctd = new CreatTableDaoImp();
//		int num = 0;
//		num = ctd.getTableCount();
//		System.out.println(num);
		
		String CSql = ctd.getCreatTableSql(1);
		System.out.println(CSql);
		
	}

}
