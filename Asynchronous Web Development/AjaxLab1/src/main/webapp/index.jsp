<%@ page import="java.util.*,my.javabrains.UserDao" %>
    <%@ page import="my.javabrains.SearchForm" %>

        <html style='display: table; margin: auto;'>

        <head>
        <script>

                var req = null;
                function submitForm(){]

                    if (window.XMLHttpRequest)
                     req = new XMLHttpRequest();
                    else if (window.ActiveXObject)
                    req = new ActiveXObject(Microsoft.XMLHTTP);
                    req.onreadystatechange = handleReq;
                    req.open( "GET", "simpleResponse.txt?t="+new Date().getTime(), true);
                    req.send(null);
                    
                }

                function handleReq(){

                    if (req.readyState == 4){
                        if (req.status == 200)
                        {document.getElementById("dyn").value="Received:" +  req.responseText;}
                        else    
                        document.ajax.dyn.value="Error code " + req.status;}
                 }
            

                //----------------------------------//

                var req2 = null;
                function submitForm2()
                {
                    
                    if (window.XMLHttpRequest){ 
                       req2 = new XMLHttpRequest();
                    }
            
                    req2.onreadystatechange = handleStateChange;
                    yourvalue=document.getElementById("thename").value;
                    url = "ServletGetUser"+"?uName=" + yourvalue + "&timeStamp=" + new Date().getTime();
                    req2.open( "GET", url, true);
                    req2.send(null);
                    
                }

                function handleStateChange() {
                    if (req2.readyState == 4 && req2.status == 200) {
                        xmlvalue=req2.responseText;
                        document.getElementById("status").value = xmlvalue;
                    }
                }

                //----------------------------------//

                var xmlHttp;
                function startRequest() {

                    createXMLHttpRequest();
                    xmlHttp.onreadystatechange = handleStateChange2;
                    xmlHttp.open("GET", "innerHTML.txt", true);
                    xmlHttp.send(null);

                }
                function createXMLHttpRequest() {
                        if (window.ActiveXObject)
                        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                        else if (window.XMLHttpRequest)
                        xmlHttp = new XMLHttpRequest();
                 }

                function handleStateChange2() {
                if (xmlHttp.readyState == 4 && xmlHttp.status == 200)
                document.getElementById("results").innerHTML =
                xmlHttp.responseText;
                }

        </script>
        </head>

        <body style='display: table-cell; vertical-align: middle;' onload = "setInterval('startRequest()' ,5000)">

                <FORM method = "POST" name = "ajax" action = "">
                    <input type = "button" value = "Submit" onclick = "submitForm();">
                    <input type = "text" value = "" name = "dyn" id="dyn">
                </FORM>

                
                <br>
                <br>
                <br>

                <FORM name = "ajax" action = "">

                    <div>
                    Enter your Name <input type = "text" id = "thename" value = "" size = "20" onblur = "submitForm2();">
                        <input type = "text" id = "status" value = "" name = "checkName">
                    </div>
                    <br>
                Enter password <input type = "password" id = "thepassword" value = "" size = "20">
                    <br>
                    <br>
                    <input type = "button" value = "Submit" onclick = "">
                </FORM>



            <div id="results">

            </div>


        </body>

        </html>