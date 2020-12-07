<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<meta charset="ISO-8859-1">
</html>
<!DOCTYPE html>
<html>
    <head>
        <title>Register</title>
        <link rel="stylesheet" href="style_student_login_css.css">       
    </head>
    <script>
                function validateform(event)
                {
                  var psw=document.getElementById("MyForm").elements.namedItem("psw").value;
                  var repsw=document.getElementById("MyForm").elements.namedItem("re-psw").value;
                  var phn=document.getElementById("MyForm").elements.namedItem("phn").value;
                  var email = document.getElementById("MyForm").elements.namedItem("email").value;
                  var user = document.getElementById("MyForm").elements.namedItem("user").value;
                  if(user == "" || phn == "" || email == ""){
                    alert("please fill the empty fields");
                    event.preventDefault();
                  }
      
                  if(user.length < 4){
                    alert("invalid user name");
                    event.preventDefault();
                  }
      
                  if(phn.length != 10){
                    alert("invalid phn no");
                    event.preventDefault();
                  }
      
                  if(!email.endsWith("@gmail.com")){
                    alert("invalid email");
                    event.preventDefault();
                    }
                  
                }
                
                </script>
    
    <body>

        <!-- (#)Since we didnt not start working on actions it will load in the same page.just for UI-->
        <!--Names for not assigned to call them-->
        <form id="MyForm" class="box" action="SignupServlet" method="GET" onsubmit="return validateform()">
            <h1>Register</h1>
            <input type="text" name="user" placeholder="Username">
            <input type="password" placeholder="Password" name="psw" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
            title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
            <input type="password" placeholder="Re-enter Password" name="re-psw" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
            title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
            <input type="text" name="phn" placeholder="Phone number" maxlength="10">
            <input type="text" name="email" placeholder="Enter email-id">
            <input type="submit" name="" value="Sign In">

        </form>

        <div id="message">
            <h3>Password must contain the following:</h3>
            <p id="letter" class="invalid">A <b>lowercase</b> letter</p>
            <p id="capital" class="invalid">A <b>capital (uppercase)</b> letter</p>
            <p id="number" class="invalid">A <b>number</b></p>
            <p id="length" class="invalid">Minimum <b>8 characters</b></p>
          </div>
                          
    </body>


</html>