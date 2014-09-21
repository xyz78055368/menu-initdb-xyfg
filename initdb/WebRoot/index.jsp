<%
	CreatTableDao ctd = new CreatTableDaoImp();
	int num = 0;
	num = ctd.getTableCount();
	out.print(num);
%>
<%@ page language="java" import="java.util.*,com.groupshop.dao.CreatTableDao,com.groupshop.daoImpl.CreatTableDaoImp" pageEncoding="utf-8"%>
