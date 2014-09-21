package com.groupshop.daoImpl;


import java.sql.Date;

import org.apache.log4j.Logger;

import com.groupshop.dao.DataBase;
import com.groupshop.dao.DownPic;

public class DownPicImp implements DownPic{
	public DownPicImp(){
//		logger = Logger.getLogger(DataBase.class.getName());
	}
	Logger logger = Logger.getLogger(DataBase.class.getName());
	public void downPic(String name){
//		System.out.println("["+new Date(System.currentTimeMillis())+"] "+name+" 开始下载");
		logger.debug("图片"+name+" 开始下载");
	}
}
