<%
	int i = Integer.parseInt(request.getParameter("i"));
	SqlDao sd = new SqlDaoImp();
	String insertsql = InsertTableText.getAllInsert.get(i).toString();
	System.out.println( i +" * "+insertsql);
	out.print(insertsql);
%>
<%@ page language="java"
	import="java.util.*,com.groupshop.dao.SqlDao,com.groupshop.daoImpl.SqlDaoImp,com.groupshop.text.InsertTableText;"
	pageEncoding="utf-8"%>