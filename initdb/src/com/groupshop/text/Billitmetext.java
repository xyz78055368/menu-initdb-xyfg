package com.groupshop.text;

import com.groupshop.dao.BillItemDao;
import com.groupshop.daoImpl.BillItemDaoImp;



public class Billitmetext{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BillItemDao bid = new BillItemDaoImp();
		String billNo = bid.getBillItemNo("‘√ŒË");
		System.out.println(billNo);
	}

}
