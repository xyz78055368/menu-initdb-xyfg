<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@page import="com.groupshop.entity.Cate"%>
<%@page import="com.groupshop.dao.SqlDao"%>
<%@page import="com.groupshop.daoImpl.SqlDaoImp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'dishhits.jsp' starting page</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <script language="JavaScript"   src="./css/js.js" type="text/javascript"></script>
 <script type="text/javascript">
  	function sub(){
  		if(check()&&choseCate()){
  		document.form1.submit();
  		}
  	}
  </script>
  </head>
<body onLoad="YYYYMMDDstart(),YYYYMMDDstart1()"> 
<form   name="form1" action="baobiao/getdishcatehits.jsp" method = "post">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name = "chose" />
		 ����&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="radio" name = "chose" checked="checked"/>
		����&nbsp;&nbsp;&nbsp;
		<select onchange = "getCate(this.value)" name = "cate">
			<option value = " ">��ѡ�����</option>
			<%
			SqlDao sd = new SqlDaoImp();
			List<Cate> list = sd.getAllCate();
			for(Cate cate :list){
				%>
					<option value = "<%=cate.getId() %>"><%=cate.getCatename() %></option>
				<%
			}
			 %>
		</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <img src="./images/cx.png" onclick="sub()">
    <br>
    <br>
   &nbsp;&nbsp;&nbsp;&nbsp;��ʼʱ�䣺 <select   name="YYYY"   onchange= "YYYYDD(this.value) "> 
        <option   value= " "> ��ѡ��   �� </option> 
    </select> 
    <select   name="MM"       onchange= "MMDD(this.value) "> 
        <option   value= " "> ѡ��   �� </option> 
    </select> 
    <select   name="DD"> 
        <option   value= " "> ѡ��   �� </option> 
    </select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 

	<br>&nbsp;&nbsp;&nbsp;&nbsp;����ʱ�䣺 <select   name="YYYY1"   onchange= "YYYYDD1(this.value) "> 
        <option   value= " "> ��ѡ��   �� </option> 
    </select> 
    <select   name="MM1"       onchange= "MMDD1(this.value) "> 
        <option   value= " "> ѡ��   �� </option> 
    </select> 
    <select   name="DD1"> 
        <option   value= " "> ѡ��   �� </option> 
    </select> 


</form> 
</body> 
</html>
