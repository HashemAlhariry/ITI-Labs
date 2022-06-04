<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>

    <form:form method="POST" modelAttribute="user" action="${contextPath}/users/register">

        <b><spring:message code="field.username"/></b>
        <form:input path="name"/>
        <form:errors path="name" />
        <br/>
        <b>Salary</b>
        <form:input path="salary" />
        <form:errors path="salary" />
        <br/>

        <b>age</b>
        <form:input path="age" />
        <form:errors path="age" />
        <br/>

        <input type="submit" value="Add new User"/>

    </form:form>
    ${contextPath}
</body>
</html>
