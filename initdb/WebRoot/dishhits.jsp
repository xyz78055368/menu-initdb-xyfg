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
//			for(int i=0;i<list.size();i++){
//				System.out.println(list.get(i).toString());
//			}
//			kt.orderDish(list,zdbh,fwyh);
		System.out.println("点击率 ：" + (list.size() / 27.0));
	
	
	
	String machineno = request.getParameter("machineno");
	int tableid = Integer.parseInt(request.getParameter("tableid"));
	int dishid = Integer.parseInt(request.getParameter("dishid"));
	String time = request.getParameter("time");
	System.out.println("machineno"+machineno);
	System.out.println("tableid"+tableid);
	System.out.println("dishid"+dishid);
	System.out.println("time" + time);
	IReportform ipf = new ReportformImp();
	Dishhits dh = new Dishhits();
	dh.setMachineno(machineno);
	dh.setTableid(tableid);
	dh.setDishid(dishid);
	dh.setTime(time); 
	String mes = ipf.updateHits(dh);
	out.print(mes);
//out.print("OK");
 %>
<%@ page language="java" import="com.groupshop.daoImpl.ReportformImp,com.groupshop.dao.IReportform,java.util.*,com.groupshop.entity.Dishhits" pageEncoding="utf-8"%>
