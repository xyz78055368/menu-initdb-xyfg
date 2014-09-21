<%
	SqlDao sd = new SqlDaoImp();
double h=789;
	out.println(sd.getAllDate(h));
%>
<%@ page language="java" import="java.util.*,com.groupshop.dao.SqlDao,com.groupshop.daoImpl.SqlDaoImp" pageEncoding="utf-8"%>