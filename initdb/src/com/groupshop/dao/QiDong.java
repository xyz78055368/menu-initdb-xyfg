package com.groupshop.dao;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

public class QiDong extends HttpServlet implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

	
	public void contextInitialized(ServletContextEvent sce) {
		Build b = new Build();
		b.build();
	}
	
}
