<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<meta charset="ISO-8859-1">
<!DOCTYPE html>
<html>
    <head>
        <title>Student Login</title>
        <link rel="stylesheet" href="style_student_login_css.css">

        <nav>
            <ul>
           <li> <a href="#home" >HOME</a></li>
        </ul>    
        
        </nav>
        
    </head>

    <body>

        <!-- (#)Since we didnt not start working on actions it will load in the same page.just for UI-->
        <!--Names for not assigned to call them-->
        <form id="MyForm" class="box" action="LoginServlet" method="GET" onsubmit="return validateform()">
            <h1>Student Login</h1>
            <input type="text" name="username" placeholder="Username">
            <input type="password" name="password" placeholder="Password">
            <input type="submit" name="" value="login">

        </form>

    </body>

    <script>
      function validateform()
      {
        var user = document.getElementById("MyForm").elements.namedItem("username").value;
        var psw=document.getElementById("MyForm").elements.namedItem("password").value;

        if(user == "" || psw == "")
        {
            alert("please fill the empty fields");
        }
      }
    </script>

</html>