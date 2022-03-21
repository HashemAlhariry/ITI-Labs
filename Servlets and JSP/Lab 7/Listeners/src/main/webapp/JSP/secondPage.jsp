
<html style='display: table; margin: auto;'>
<head></head>
<body style='display: table-cell; vertical-align: middle;'>

 
<h1>second Page</h1>

<%out.println(request.getAttribute("hello"));%>
<%@ include file="thirdPage.jsp" %>

<p> total users </p>
 ${totalusers} 
<p> totla current users</p>
 ${currentusers}
 
</body>
</html>

