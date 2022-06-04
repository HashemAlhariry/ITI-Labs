<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<form method="POST" enctype="multipart/form-data" action="${contextPath}/uploadFile">
    <b>File</b>
    <input type="file" name="file" />
    <br/>
    <input type="submit" value="Upload file"/>
</form>
</body>
</html>