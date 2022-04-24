
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

<form action="ChatRoom.jsp" class="container  p-3 mt-3 border border-2 rounded-top text-center shadow p-3 mb-5 bg-body rounded">
    <p class="h2 mt-3 mb-3">Join Our Chat Room</p>
    <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon1">@</span>
        <input type="text" name="name" id ="name" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
    </div>

    <div class="form-check-inline">
        <input class="form-check-input" type="radio" name="gender" id="male">
        <label class="form-check-label" for="male"> Male </label>
    </div>
    <div class="form-check-inline">
        <input class="form-check-input" type="radio" name="gender" id="female">
        <label class="form-check-label" for="female"> Female </label>
    </div>

    <input type="submit"  value="Go To Chat Room" class="btn btn-primary">
</form>

</body>
</html>