<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up Form by Colorlib</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<input type="hidden" id="statuss" value="<%=request.getAttribute("stat")%>">
    <div class="wrapper">
      <h2>Sign In</h2>
      <form method="post" action="login" >
        <div class="input-box">
          <input
            type="email"
            id="email"
            name="email"
            placeholder="Enter your email"
            required
          />
        </div>

        <div class="input-box">
          <input
            type="password"
            id="password"
            name="password"
            placeholder="Enter password"
            required
          />
        </div>

        <div class="input-box button">
          <input type="Submit" value="Sign In" />
        </div>
        <div class="text">
          <h3>Not a member? <a href="register.jsp">Create account</a></h3>
        </div>
      </form>
    </div>


<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	<script type="text/javascript">
	var status=document.getElementById("statuss").value;
	if(status=="failed"){
		swal("Sorry","Wrong username or password","error");
	}
	
	
	</script>
	
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>