<% 
request.setCharacterEncoding("utf-8");
			List<String> list = new ArrayList<String>();
			Map map = request.getParameterMap();
			Set keSet = map.entrySet();
			for (Iterator itr = keSet.iterator(); itr.hasNext();) {
			Map.Entry me = (Map.Entry) itr.next();
				Object ok = me.getKey();
				Object ov = me.getValue();
				String[] value = new String[1];
				if (ov instanceof String[]) {
					value = (String[]) ov;
				} else {
					value[0] = ov.toString();
				}
				for (int k = 0; k < value.length; k++) {
					  System.out.println(ok+"="+value[k]);
					list.add(value[k]);
				}
			}

System.out.println("***************************************************");

String id = request.getParameter("dishid");
String num = request.getParameter("item_num");
String name = request.getParameter("item_name");
String spec = request.getParameter("item_spec");
String price = request.getParameter("price");
String fwyh = request.getParameter("optcode");
String remark = request.getParameter("remark");
String serBillno = request.getParameter("serbillno");
String macid = request.getParameter("macid");
String tableid = request.getParameter("table");
String waiter = request.getParameter("optcode");
//OrderDish od = new OrderDishImp();
//OrderDishImp odi = new OrderDishImp();
//String cmbh = od.getCmbhByDishId(Integer.parseInt(id));
//String zwmc = od.getZwmcByTableId(Integer.parseInt(tableid));
//TableDish td = new TableDish();
//td.setTableNo(zwmc);
//td.setDishNo(cmbh);
//td.setDishName(name);
//td.setDishSpec(spec);
//td.setDishRemark(remark);
//td.setWaiter(waiter);
//td.setDishNum(Double.parseDouble(num));
//String str =  odi.retreatfood(td);
out.print(0);
%>
<%@ page language="java" import="java.util.*,com.groupshop.dao.OrderDish,com.groupshop.daoImpl.OrderDishImp;" pageEncoding="utf-8"%>