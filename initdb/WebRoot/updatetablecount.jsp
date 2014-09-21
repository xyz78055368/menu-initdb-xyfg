<%
	String macid = request.getParameter("macid");
	BillDao bd = new BillDaoImp();
	int k = bd.UpdateDtable();
	out.print(k);
%>
<%@ page language="java"
	import="java.util.*,com.groupshop.*,com.groupshop.dao.BillDao,com.groupshop.daoImpl.*;"
	pageEncoding="utf-8"%>
