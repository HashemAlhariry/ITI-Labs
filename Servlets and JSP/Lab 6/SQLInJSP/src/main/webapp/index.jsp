<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">  
    <!-- <link rel="stylesheet" href="normalize.css" > -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/logincss.css" type="text/css" >
 
</head>

<body>



    <c:set var="testUser" value="${userBean}" /><br/>
    <sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/servlets" user="root" password="pluralsight"/>
    <sql:query var="rs" dataSource="${db}"> select * from servlets.user</sql:query>
    <table >
    <tr>
        <th>UserName</th>
        <th>userFullName</th>
  
    </tr>
    
    <c:forEach items="${rs.rows}" var="user">
    <tr>
        <td>${user.username}</td>
        <td>${user.userfullname}</td>
 
    </tr>
    </c:forEach>
    </table>
    

</body>

</html>
