<%@ page import="java.util.*,my.javabrains.UserDao" %>
    <%@ page import="my.javabrains.SearchForm" %>
    <%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
        <html style='display: table; margin: auto;'>

        <head></head>
        <body style='display: table-cell; vertical-align: middle;'>

            <h1>Search Form</h1>
            <h2>Please enter user name</h2>
            <FORM method="post" action="SearchForm" >
                <br>
                <br> Name: <INPUT TYPE=TEXT NAME=name>
                <INPUT TYPE=SUBMIT VALUE=Submit>
            </FORM>

            <tag:if test="${result!=null}">  
            <tag:if test="${result.size()==0}">
               <p style="color: red">No user</p>
                </tag:if>   
            <tag:if test="${result.size()>0}">

                 <table style="border: 1px solid black;">
                        <tr>
                            <th> FullName </th>
                            <th> User Name </th>
                        </tr>
                       
                       <tag:forEach items="${result}" var="ailment">
                        <tr>
                            <td>
                            ${ailment.userFullName}
                            </td>
                            <td>
                            ${ailment.username}
                            </td>

                         </tr>
                        </tag:forEach> 
                    </table>
            </tag:if>
            </tag:if>
 




        </body>

        </html>