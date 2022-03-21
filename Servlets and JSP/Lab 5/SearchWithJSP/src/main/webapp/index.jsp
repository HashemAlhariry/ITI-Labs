<%@ page import="java.util.*,my.javabrains.UserDao" %>
    <%@ page import="my.javabrains.SearchForm" %>

        <html style='display: table; margin: auto;'>

        <head></head>

        <body style='display: table-cell; vertical-align: middle;'>

            <h1>Search Form</h1>
            <h2>Please enter user name</h2>
            <FORM>
                <br>
                <br> Name: <INPUT TYPE=TEXT NAME=name>
                <INPUT TYPE=SUBMIT VALUE=Submit>
            </FORM>
            <% SearchForm searchForm=new SearchForm();
             if(request.getParameter("name")!=null) { 
                 List<UserDao> users = searchForm.connectDB(request.getParameter("name"));
               
                if(users!=null){
                         
                if(users.size()==0){
                %>
                <p style="color: red">No user</p>
                <% } else { %>
                    <table style="border: 1px solid black;">
                        <tr>
                            <th> FullName </th>
                            <th> User Name </th>
                        </tr>
                        <% for (int i=0; i < users.size(); i++) { %>
                            <tr>
                                <td>
                                    <%= users.get(i).userFullName%>
                                </td>
                            <tr>
                                <td>
                                    <%= users.get(i).username%>
                                </td>

                                <% }%>
                    </table>

                    <% } }
                    
                    else{
                    
                    }
                    
                     }%>





        </body>

        </html>