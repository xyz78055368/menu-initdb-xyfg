<%
Logger logger = Logger.getLogger("application");
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

	String machineno = request.getParameter("machineno");
	String name = request.getParameter("name");
	//System.out.println(name + "****" + machineno);
	logger.info("**"+name + "****" + machineno);
	String uname = "";
	int k = InsertTableText.uLogList.size();
	System.out.println("登录用户数量："+k);
		Date date = new Date();
	for (int i = 0; i < k; i++) {
		Userlogin ul = InsertTableText.uLogList.get(i);
		if (ul.getUname().equals(name)) {
			ul.setLogTime(date);
		} else {
			if ((ul.getLogTime().getTime() + 1000 * 60 * 2) <= date.getTime()) {
				InsertTableText.uLogList.remove(i);
			}
		}
	}
	out.print("OK");
%>
<%@ page language="java"
	import="org.apache.log4j.Logger,java.util.*,com.groupshop.text.InsertTableText,com.groupshop.entity.Userlogin;"
	pageEncoding="UTF-8"%>