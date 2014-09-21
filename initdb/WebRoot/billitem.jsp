<%
	request.setCharacterEncoding("utf-8");
	String zwmc = request.getParameter("tableid");
		
//	List<String> list = new ArrayList<String>();
//			Map map = request.getParameterMap();
//			Set keSet = map.entrySet();
//			for (Iterator itr = keSet.iterator(); itr.hasNext();) {
//			Map.Entry me = (Map.Entry) itr.next();
//				Object ok = me.getKey();
//				Object ov = me.getValue();
//				String[] value = new String[1];
///				if (ov instanceof String[]) {
//					value = (String[]) ov;
//				} else {
//					value[0] = ov.toString();
//				}
//				for (int k = 0; k < value.length; k++) {
//					  System.out.println(ok+"="+value[k]);
//					list.add(value[k]);
//				}
//			}
		
	SqlDao sd = new SqlDaoImp();
	int count = sd.billcount(zwmc);
	out.print(count);
%>
<%@ page language="java"
	import="java.util.*,com.groupshop.dao.SqlDao,com.groupshop.daoImpl.SqlDaoImp,com.groupshop.dao.OrderDish,com.groupshop.daoImpl.OrderDishImp;"
	pageEncoding="utf-8"%>

