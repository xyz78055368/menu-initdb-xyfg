package com.groupshop.entity;


import java.sql.Date;


/**
* 通过数据库内表的字段动态生成 javabean
**/
public class Obj 
{	
	private int id;
	private String name;
	private String pic;
	private String txt;
	private int obj_x;
	private int obj_y;
	private int obj_wid;
	private int obj_hgt;
	private String obj_font;
	private int obj_size;
	private int obj_color;
	private int obj_align;
	private int obj_collocate;
	private int obj_enter;
	private int page;
	private int ranking;
	private int tag1;
	private int tag2;
	private String remark;
	private int compent;

	public Obj()
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
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	public void setPic(String pic)
	{
		this.pic = pic;
	}
	public String getPic()
	{
		return this.pic;
	}
	public void setTxt(String txt)
	{
		this.txt = txt;
	}
	public String getTxt()
	{
		return this.txt;
	}
	public void setObj_x(int obj_x)
	{
		this.obj_x = obj_x;
	}
	public int getObj_x()
	{
		return this.obj_x;
	}
	public void setObj_y(int obj_y)
	{
		this.obj_y = obj_y;
	}
	public int getObj_y()
	{
		return this.obj_y;
	}
	public void setObj_wid(int obj_wid)
	{
		this.obj_wid = obj_wid;
	}
	public int getObj_wid()
	{
		return this.obj_wid;
	}
	public void setObj_hgt(int obj_hgt)
	{
		this.obj_hgt = obj_hgt;
	}
	public int getObj_hgt()
	{
		return this.obj_hgt;
	}
	public void setObj_font(String obj_font)
	{
		this.obj_font = obj_font;
	}
	public String getObj_font()
	{
		return this.obj_font;
	}
	public void setObj_size(int obj_size)
	{
		this.obj_size = obj_size;
	}
	public int getObj_size()
	{
		return this.obj_size;
	}
	public void setObj_color(int obj_color)
	{
		this.obj_color = obj_color;
	}
	public int getObj_color()
	{
		return this.obj_color;
	}
	public void setObj_align(int obj_align)
	{
		this.obj_align = obj_align;
	}
	public int getObj_align()
	{
		return this.obj_align;
	}
	public void setObj_collocate(int obj_collocate)
	{
		this.obj_collocate = obj_collocate;
	}
	public int getObj_collocate()
	{
		return this.obj_collocate;
	}
	public void setObj_enter(int obj_enter)
	{
		this.obj_enter = obj_enter;
	}
	public int getObj_enter()
	{
		return this.obj_enter;
	}
	public void setPage(int page)
	{
		this.page = page;
	}
	public int getPage()
	{
		return this.page;
	}
	public void setRanking(int ranking)
	{
		this.ranking = ranking;
	}
	public int getRanking()
	{
		return this.ranking;
	}
	public void setTag1(int tag1)
	{
		this.tag1 = tag1;
	}
	public int getTag1()
	{
		return this.tag1;
	}
	public void setTag2(int tag2)
	{
		this.tag2 = tag2;
	}
	public int getTag2()
	{
		return this.tag2;
	}
	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	public String getRemark()
	{
		return this.remark;
	}
	public void setCompent(int compent)
	{
		this.compent = compent;
	}
	public int getCompent()
	{
		return this.compent;
	}
}
