
var eventSource=null;
this.onmessage = function (event){
    eventSource = new EventSource("chatServlet?name=" + event.data.name + "&gender=" + event.data.gender);
    eventSource.addEventListener('messageReceived',function (e){
        var data = JSON.parse(e.data);
        console.log(data);
        var html = "<div class=\"well well-sm inline\">\n" +
            "<h3>" + data.sender.name + "</h3>\n" +
            "<p>" + data.message + "</p>\n" +
            "</div>";
        postMessage({"name": "messageReceived","html": html});
    });

    eventSource.addEventListener('userLoggedIn',function (e){
        var data = JSON.parse(e.data);
        console.log(data);
        var html = "<div class=\"well well-sm inline\">\n" +
            "<h3>" + data.name + "</h3>\n" +
            " </div>";
        postMessage({"name": "userLoggedIn","html": html});
    });

    eventSource.addEventListener('allMessages',function (e){
        console.log("ppppppp");
        var data = JSON.parse(e.data);
        console.log(data);
        for(var i=0;i<data.length;i++){
            var html = "<div class=\"well well-sm\">\n" +
                "<h3>" + data[i].sender.name + "</h3>\n" +
                " <p>" + data[i].message + "</p>\n" +
                " </div>";
            postMessage({"name": "allMessages","html": html});
        }
    });

    eventSource.addEventListener('allUsers',function (e){
        var data = JSON.parse(e.data);
        console.log(data);
        for(var i=0;i<data.length;i++) {
            if (i === 0) {
                var html = "<div class=\"well well-sm inline\">\n" +
                    "<h3>" + data[i].name + "</h3>\n" +
                    " </div>";
                postMessage({"name": "allUsersFirst","html": html});
            } else {
                var html = "<div class=\"well well-sm inline\">\n" +
                    "<h3>" + data[i].name + "</h3>\n" +
                    " </div>";
                postMessage({"name": "allUsers","html": html});
            }
        }
    });
}