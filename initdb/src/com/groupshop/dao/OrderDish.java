package com.groupshop.dao;

import com.groupshop.entity.B_wdk;

public interface OrderDish {
	public String orderDish(B_wdk bwdk ,int xfks);
	public String getCmbhByDishId(int dishid);
	public String getZwmcByTableId(int tableId);
}
