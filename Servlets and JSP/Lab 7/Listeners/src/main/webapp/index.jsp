
<%@ page import="my.javabrains.dao.UserDao" %>
<%@ page import="my.javabrains.util.CreateFile" %>


<html style='display: table; margin: auto;'>
<head></head>
<body style='display: table-cell; vertical-align: middle;'>

<h1>index Page</h1>

    <%
    UserDao UserDao = new UserDao("Hashem" , "Hashem khaled said alhariry");
    String hello = "Hello from index.jsp";
    request.setAttribute("user",UserDao);
    request.setAttribute("hello",hello);
    %>

<jsp:forward page="JSP/secondPage.jsp" />  

</body>
</html>