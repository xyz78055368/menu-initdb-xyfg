<%@page import="com.groupshop.daoImpl.BillDaoImp"%><%
int i = Integer.parseInt(request.getParameter("i"));
String str = BillDaoImp.SQLSTR.get(i);
System.out.println(i+"**"+str);
out.print(str);
%>
<%@ page language="java" import="java.util.*,com.groupshop.dao.BillDao;" pageEncoding="utf-8"%>