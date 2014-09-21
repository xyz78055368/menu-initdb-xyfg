package com.groupshop.dao;
import java.util.List;

import com.groupshop.entity.DishHitsbb;
import com.groupshop.entity.Dishhits;


public interface IReportform {
	public List<DishHitsbb> getDishHitsbbList();
	public List<DishHitsbb> getDishHitsCatebbList();
	public List<DishHitsbb> getDianJiLv();
	public String updateHits(Dishhits dh);
	
	public final int PAGE_SUM = 20;  //菜品所在一页的行数
}
