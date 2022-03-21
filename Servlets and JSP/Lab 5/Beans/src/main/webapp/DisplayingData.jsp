<jsp:useBean id="myBean" scope="session" class="my.javabrains.Employee" />
<jsp:setProperty name="myBean" property="*" />

<!doctype html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <title>Login Form</title>
  <link rel="stylesheet" href="login_form.css">

</head>

<body>
  <h2>LOGIN FORM</h2><br>
  <div class="login">
    <form id="login">
      <label><b>User Name</b> </label>
      <p>
        <jsp:getProperty name="myBean" property="username" />
      </p>
      <br>
      <br>
      <label><b>Department Name</b></label>
      <br>
      <br>
      <jsp:getProperty name="myBean" property="departmentName" />
      <br>
      <br>
      <label><b>age</b></label>
      <br>
      <br>
      <jsp:getProperty name="myBean" property="age" />
      <br>
      <br>
      <label><b>salary</b></label>
      <br>
      <jsp:getProperty name="myBean" property="salary" />
      <br>
      <br>

    </form>
  </div>
</body>

</html>