package com.groupshop.entity;


import java.sql.Date;


/**
* 通过数据库内表的字段动态生成 javabean
**/
public class Dish 
{	
	private int id;
	private String dishbh;
	private String dname;
	private double price;
	private String spec;
	private String lpic;
	private String spic;
	private int upper;
	private String remark;
	private String sound;
	private int dishlocate;
	private int draw_dish;
	private String dish_py;

	public Dish()
	{

	}

	public void setId(int id)
	{
		this.id = id;
	}
	public int getId()
	{
		return this.id;
	}
	public void setDishbh(String dishbh)
	{
		this.dishbh = dishbh;
	}
	public String getDishbh()
	{
		return this.dishbh;
	}
	public void setDname(String dname)
	{
		this.dname = dname;
	}
	public String getDname()
	{
		return this.dname;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	public double getPrice()
	{
		return this.price;
	}
	public void setSpec(String spec)
	{
		this.spec = spec;
	}
	public String getSpec()
	{
		return this.spec;
	}
	public void setLpic(String lpic)
	{
		this.lpic = lpic;
	}
	public String getLpic()
	{
		return this.lpic;
	}
	public void setSpic(String spic)
	{
		this.spic = spic;
	}
	public String getSpic()
	{
		return this.spic;
	}
	public void setUpper(int upper)
	{
		this.upper = upper;
	}
	public int getUpper()
	{
		return this.upper;
	}
	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	public String getRemark()
	{
		return this.remark;
	}
	public void setSound(String sound)
	{
		this.sound = sound;
	}
	public String getSound()
	{
		return this.sound;
	}
	public void setDishlocate(int dishlocate)
	{
		this.dishlocate = dishlocate;
	}
	public int getDishlocate()
	{
		return this.dishlocate;
	}
	public void setDraw_dish(int draw_dish)
	{
		this.draw_dish = draw_dish;
	}
	public int getDraw_dish()
	{
		return this.draw_dish;
	}
	public void setDish_py(String dish_py)
	{
		this.dish_py = dish_py;
	}
	public String getDish_py()
	{
		return this.dish_py;
	}
}
