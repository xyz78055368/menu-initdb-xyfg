<%
	String name = request.getParameter("name");
	String pwd = request.getParameter("pwd");
	System.out.println(name +"***********"+pwd);
	Opt opt = new Opt(name, pwd);
	Login login = new LoginImp();	String info = "Error";
	info = login.checkUser(opt);
//	String str ="";
//	Userlogin ul1 = new Userlogin(name);
//	if (InsertTableText.uLogList.size() == 0) {
//		Userlogin ul = new Userlogin(name);
//		InsertTableText.uLogList.add(ul);
//	} else {
//		for (int i = 0; i < InsertTableText.uLogList.size(); i++) {
//			Userlogin ul = InsertTableText.uLogList.get(i);
//			if (ul.getUname().equals(opt.getName())) {
//				info = "Error";
//				str = "";
//				break;
//			}else{
//				str = "ex";
//			}
//		}
//		if(str.equals("ex")){
//			info = "OK";
//			InsertTableText.uLogList.add(ul1);
	//	}		
//	}
	out.print(info);
//out.print("OK");
%>
<%@ page language="java"
	import="java.util.*,com.groupshop.entity.Opt,com.groupshop.dao.Login,com.groupshop.daoImpl.LoginImp,com.groupshop.entity.Userlogin,com.groupshop.text.InsertTableText;"
	pageEncoding="utf-8"%>