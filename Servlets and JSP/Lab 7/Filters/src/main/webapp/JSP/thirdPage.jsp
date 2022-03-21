<%@ page import="my.javabrains.dao.UserDao" %>

<%
UserDao user =(UserDao)request.getAttribute("user");
out.println(user.username);
out.println(user.userFullName);
%>
 
