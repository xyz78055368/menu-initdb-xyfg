<%@ page contentType="text/html;charset=GBK" %>
<%! 
    //����ʵ������ 
    String username; 
    String password;
    java.io.PrintWriter output;
%>
<% 
    //��request�л�ȡ����
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