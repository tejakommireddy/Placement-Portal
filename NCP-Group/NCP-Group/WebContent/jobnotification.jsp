


<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("userid");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "company";
String userid = "root";
String password = "sneha";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>








<!DOCTYPE html>
<html>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, inital-scale= 1 ">
 <link rel="stylesheet" href="style.css">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 
 <head>

 </head> 

 <body style="border-style: outset;">
				<div class="header" >
    				<!--<h1>Amrita Vishwa Vidyapeetham</h1>
					
    			</div>
 
<nav>
	<ul>
   <li> <a href="#home" >HOME</a></li>
    <li><a href=" " >Students Login</a></li>
    <li><a href=" " >Guest Login</a></li>
	<li style="float: right;"><a href=""  style="float: right;">Further Info</a></li>
    </nav>
	</ul>
-->


<section>
<center><h2>Applications</h2></center>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from job_notification";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>

			
			
			
			<button class="accordion"><center><%=resultSet.getString("comp_name") %></center></button>
				<div class="panel">
				<p>Job Title:<p style="color:black;"><%=resultSet.getString("Job_title") %></p> </p>
				<p>Eligibility:<p style="color:black;">><%=resultSet.getString("eligibility") %></p> </p>
				
				<p>ctc:<p style="color:black;"><%=resultSet.getString("ctc") %></p></p>
				<p>apply by: <p style="color:black;"><%=resultSet.getString("applyby") %></p></p>
				<button class="button">Register</button>
				</div>

<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>		
			
<script>
var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
  acc[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var panel = this.nextElementSibling;
    if (panel.style.display === "block") {
      panel.style.display = "none";
    } else {
      panel.style.display = "block";
    }
  });
}
</script>
			
			
</section>

<br>
<hr>
<footer class="container foot">
    <a href="https://www.facebook.com/AmritaUniversity"><i class="fa fa-facebook"></i></a>
    <a href="https://www.instagram.com/explore/locations/339148330/amrita-vishwa-vidyapeetham-amritapuri-campus/?hl=en"><i class="fa fa-instagram"></i></a>
    <h6>For more updates go through our social media channel too.</h6>

</footer>

 </body>
 </html>
 
