<%
	request.setCharacterEncoding("utf-8");
	String zwmc = request.getParameter("tablename");
	int index = Integer.parseInt(request.getParameter("ind"));
	SqlDao sd = new SqlDaoImp();
	String sql = sd.getInsertBillItemSql(SqlDaoImp.billItemList
			.get(index), zwmc);
	out.print(sql);
%>
<%@ page language="java"
	import="java.util.*,com.groupshop.dao.SqlDao,com.groupshop.daoImpl.SqlDaoImp,com.groupshop.entity.Billitem;"
	pageEncoding="utf-8"%>