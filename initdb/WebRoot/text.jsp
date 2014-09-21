<%@ page contentType="text/html;charset=GBK" %>
<%! 
    //定义实例变量 
    String username; 
    String password;
    java.io.PrintWriter output;
%>
<% 
    //从request中获取参数
    username = request.getParameter("username");
    password = request.getParameter("password");
    output = response.getWriter();
    showUserInfo(); 
 %>
 <%! 
    public void showUserInfo() {  
      
       int i =0;  
       double sum = 0.0;  
       while (i++ < 1000000000) {
             sum += i;  
       }    
       
       output.println(Thread.currentThread().getName() + "<br>");
       output.println("username:" + username + "<br>"); 
       output.println("password:" + password + "<br>"); 
    }
 %> 