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
<input type="hidden" id="status" value="<%=request.getAttribute("status")%>">
<input type="hidden" id="duplicate" value="<%=request.getAttribute("unique_user")%>">
<div class="wrapper">
      <h2>Create an Account</h2>
      <form method="post" action="register" onsubmit="return valiData();">
        <div class="input-box">
          <input type="text" name="name" id="name" placeholder="Enter your name" required />
        </div>
        <div class="input-box">
          <input type="email" name="email" id="email" placeholder="Enter your email" required />
        </div>
        <div class="input-box">
          <input type="password" name="password" id="password" placeholder="Create password" required />
        </div>
        <div class="input-box">
          <input type="password" name="repass" id="repass" placeholder="Confirm password" required onkeyup="check();"/>
          <br>
           <span id="message"></span><br>
        </div>
        <div class="input-box button">
          <input type="Submit" value="Register Now" />
        </div>
        <div class="text">
          <h3>Already have an account? <a href="login.jsp">Login now</a></h3>
        </div>
      </form>
    </div>

<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	<script type="text/javascript">
	var check = function () {
        if (
          document.getElementById("password").value ==
          document.getElementById("repass").value
        ) {
        	
          document.getElementById("message").style.color = "green";
          document.getElementById("message").innerHTML = "passwords matching";
        } else {
        	
          document.getElementById("message").style.color = "red";
          document.getElementById("message").innerHTML = "passwords not matching";
        }
	}
        
	function valiData(){
		var re1=new RegExp("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");
		
		var a=document.getElementById("password").value;
		var b=document.getElementById("email").value;
		var c=document.getElementById("name").value;
		var re2 = new RegExp("^[a-z0-9._%+-]+@[a-z0-9.-]+[.][a-z]{2,3}$");
		  var re3 = new RegExp("^[a-zA-Z ]+$");
          if (!re3.test(c)) {
            swal("Try Again","Name should contain only alphabets and space","error");
            return false;
          }
		if(!re2.test(b)){
		   swal("Try Again","Invalid email id","error");
			return false;
			
		}
		if(!re1.test(a)){
			//swal("Try Again","Passwords do not match","error");!re1.test(a)
			swal("Try Again","Passwords should be at least 8 characters 1 lower case , 1 uppercase and a number","error");
			return false;
		}
		else if(document.getElementById("password").value!=document.getElementById("repass").value){
			//swal("Try Again","Passwords should be at least 8 characters and number","error");
			swal("Try Again","Confirm password does not match with password","error");
			return false;
		}
			return true;
		}
		
	
	var status=document.getElementById("status").value;
	if(status=="success"){
		//swal("Congrats","Account created successfully!","success");
		swal({
		    title: "Congrats!",
		    text: "Account created successfully!",
		    type: "success"
		}).then(function() {
		    window.location = "login.jsp";
		});
		
	}
	
	var unique_user=document.getElementById("duplicate").value;
	if(unique_user=="false"){
		swal("Email taken","Existing account with this email","error");
	}
	</script>



</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>