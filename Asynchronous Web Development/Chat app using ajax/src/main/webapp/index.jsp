 
        <html style='display: table; margin: auto;'>

        <head>
        <script src=http://code.jquery.com/jquery-latest.min.js ></script>

        </head>
   

        <body style='display: table-cell; vertical-align: middle;'>

        <form action="">

            <div >
                <label for="name">Name</label>
                <input type="text"  id="name">
            </div>
            <br>
            <br>

            <div>
                <label for="message">Message</label>
                <input type="text"  id="message">
            </div>

            <br>
            <br>

            <button type="button"  id="sendMessage">Submit</button>
        </form>


        <div id="messages">
        </div>
       <script>  

         $(document).ready(function() {
                    setInterval( function(){
                            var name = $("#name").val();
                        var password = $("#password").val();
                        var jsonData = {"name": name, "pass": password};
                        $.ajax({ 
                        url: 'SendMessage',
                        type: 'GET', 
                        contentType: 'application/json', 
                        data: jsonData, 
                        dataType: 'json', 
                        success: function(data) {
                            messages = JSON.parse(JSON.stringify(data));
                            console.log(data);
                         $('#messages').empty();
                   
                        for (var i = 0; i < messages.length; i++) {
                            $('#messages').append("<div  style=\"margin: 30px;    padding: 35px; border-inline-style: groove;writing-mode: horizontal-tb;   max-width: 500px; \" >" +
                            "<h3>" + messages[i].name + "</h3>" + "<span>" + messages[i].message + "</span>" +  "</div>")
                         }
                     } 
                    });
                    }, 500);
               });


                $('#sendMessage').click(function () {
                    console.log("message sent");
                var name = $('#name').val();
                var message = $('#message').val();
                var jsonData = {"name": name, "message": message};
                $.ajax({
                    url: 'SendMessage',
                    type: 'POST',
                    contentType: 'application/x-www-form-urlencoded',
                    data: jsonData,
                    dataType: 'json',
                    success: function () {
                    
                    }
                });
            });

    </script>
        </body>

        </html>