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
	B_wdk bwdk = new B_wdk();
	int tableid = Integer.parseInt(new String(request.getParameter("table").getBytes("GB2312")));
	int dishid = Integer.parseInt(request.getParameter("dish_id"));
	float cmsl = Float.parseFloat(request.getParameter("item_num"));
	String fwyh = request.getParameter("user");
	String kwbz = new String(request.getParameter("item_remark").getBytes("GB2312"));
	String sjbj = request.getParameter("ordertime");
	String dishName=request.getParameter("item_name");

	//String opt = request.getParameter("opt");
	OrderDish od = new OrderDishImp();
	int xfks = Integer.parseInt(request.getParameter("dinningpeople"));
	String cmbh = od.getCmbhByDishId(dishid);
	double price = Double.parseDouble(request.getParameter("item_price"));
	String zwmc = od.getZwmcByTableId(tableid);
	System.out.println("cmbh"+cmbh);
	bwdk.setCMBH(cmbh);
	bwdk.setCMSL(cmsl);
	bwdk.setFWYH(fwyh);
	bwdk.setTMBJ(sjbj);
	bwdk.setKWBH(kwbz);
	bwdk.setZWBH(zwmc);
	bwdk.setCMDJ(price);
	bwdk.setCMMC(dishName);
	String s = od.orderDish(bwdk,xfks);
	out.print(s);
%>
<%@ page language="java"
	import="java.util.*,com.groupshop.entity.B_wdk,com.groupshop.daoImpl.OrderDishImp,com.groupshop.dao.OrderDish"
	pageEncoding="utf-8"%>
