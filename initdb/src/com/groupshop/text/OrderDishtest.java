package com.groupshop.text;

import com.groupshop.dao.OrderDish;
import com.groupshop.daoImpl.OrderDishImp;
import com.groupshop.entity.B_wdk;



public class OrderDishtest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		B_wdk bwdk = new B_wdk();
		String zwmc = "133";
		String cmbh = "6318";
//		double cmdj = 20;
		float cmsl = 5;
		String fwyh = "0001";
		int xfks = 1;
//		bwdk.setZwmc(zwmc);
		bwdk.setCMBH(cmbh);
		bwdk.setCMSL(cmsl);
		bwdk.setFWYH(fwyh);
//		bwdk.setXfks(xfks);
		bwdk.setKWBH("°××Æ");
		bwdk.setZWBH(zwmc);
		String date = "2011-1-12 5:34:44";
		bwdk.setTMBJ(date);
		OrderDish od = new OrderDishImp();
		String s = od.orderDish(bwdk,xfks);
		System.out.println(s);

	}

}
