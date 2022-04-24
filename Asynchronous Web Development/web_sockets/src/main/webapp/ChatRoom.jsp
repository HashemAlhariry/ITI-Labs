<html style='display: table; margin: auto;'>

<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
            integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
            crossorigin="anonymous"></script>
</head>

<body>
<div class="container">
    <div class="card mt-4 shadow mb-5 bg-body rounded">
        <div class="card-header bg-warning text-white">
            Welcome To The  Chat Room
        </div>

        <div class="card-body">
            <h5 class="card-title">Chat room</h5>
            <form class="">
                <div class="input-group">
                    <span class="input-group-text">Textarea</span>
                    <textarea class="form-control" name="message" id="message" aria-label="With textarea"></textarea>
                </div> <hr>
                <input type="button"  value="send message" onclick="sendmessage(event)" class="btn btn-primary"/>
                <input type="hidden" value="<%= request.getParameter("name")%>"   name="name" id="name"/>
                <input type="hidden" value="<%= request.getParameter("gender")%>" name="gender" id="gender"/>
            </form>
        </div>
    </div>

    <div class="p-3">
        <div id="messages">
            <div class="alert alert-light border border-info border-rounded" role="alert">
                <h6 class="alert-heading">Bot:</h6><hr>
                <p>Hello world !! , I'm new here... Hello world !! , I'm new here...  Hello world !! , I'm new here...  Hello world !! , I'm new here... </p>
                <br><span class="badge bg-dark">12:45</span>
            </div>
        </div>
    </div>

    <div class="mt-5 p-2 border shadow mb-5 bg-body rounded">
        <div class="btn btn-info position-relative">
            Online users
            <span id="onlineUser" class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                    99+
            </span>
        </div>
    </div>
    <a href="./" class="btn btn-danger" value="logout" onclick="logout()">Logout</a>


</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>

    var eventSource=null;
    var worker = null;
    $(document).ready(function () {
        console.log("hellooo");
        if(typeof (worker)!=="undefined"){
            worker = new Worker("worker.js");
            var thisUser = {"name": $('#name').val(),"gender": $('#gender').val()};
            worker.postMessage(thisUser);
            worker.onmessage = function (event){
                if(event.data.name === 'messageReceived')
                    $('#messages').append(event.data.html);
                else if(event.data.name === 'userLoggedIn'){
                    $('#onlineUsers').append(event.data.html);
                }
                else if(event.data.name === 'allMessages'){
                    $('#messages').append(event.data.html);
                }
                else if(event.data.name === 'allUsersFirst'){
                    $('#onlineUsers').html(event.data.html);

                }
                else if(event.data.name === 'allUsers'){
                    $('#onlineUsers').append(event.data.html);

                }

            }
        }
    })

    function sendMessage(e) {
        e.preventDefault();
        console.log("sending message....");
        var message = $('#message').val();
        console.log(message);
        var msgObj = {"message": message, "senderName": $('#name').val(), "senderGender": $('#gender').val()};
        $.ajax({
            url: 'chatServlet',
            type: 'POST',
            contentType: 'application/x-www-form-urlencoded',
            data: msgObj,
            dataType: 'json'
        });
    }

    function logout() {
        console.log("logging out");
        var msgObj = {"message": "CLOSECONNECTION", "senderName": $('#name').val(), "senderGender": $('#gender').val()};
        $.ajax({
            url: 'chatServlet',
            type: 'POST',
            contentType: 'application/x-www-form-urlencoded',
            data: msgObj,
            dataType: 'json'
        });
        eventSource.close();

    }
</script>

</body>
</html>