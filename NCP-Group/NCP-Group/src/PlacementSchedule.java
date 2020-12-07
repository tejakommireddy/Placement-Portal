import java.io.*;  
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  
import java.sql.*;  
@WebServlet("/PlacementSchedule")
public class PlacementSchedule extends HttpServlet  
{    
     public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
      {  
         PrintWriter out = res.getWriter();  
         res.setContentType("text/html");  
         out.println("<html><body><style> .button{background-color: #808080;border: none;color: white;padding: 10px 15px;text-align: center;text-decoration: none;display: inline-block;margin: 4px 2px;font-size: 10px;border-radius: 12px;border: 2px solid #000000;position:relative; left:680px; top:70px;box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);cursor: pointer;}ul {list-style-type: none;margin: 0;padding: 0;overflow: hidden;background-color: #ff0000;;}body {height: 100%; background-position: top;background-repeat: no-repeat;background-size:cover;}table, th, td {border: 1px solid black;border-collapse: collapse;margin-top:100px}</style><ul><h2 style='text-align:center'>PLACEMENT SCHEDULE</h2></ul>"); 

 
         try 
         {  
             Class.forName("com.mysql.jdbc.Driver");  
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ncpproj", "root", "sneha");  
              
             Statement stmt = con.createStatement();  
             ResultSet rs = stmt.executeQuery("select * from employee");  
             out.println("<table style='width:50%'>");  
             out.println("<tr><th>S.No</th><th>Name of the Company</th> <th>JOb_role</th><th>Date of exam</th></tr>");  
             while (rs.next()) 
             {  
                 String id = rs.getString("id");  
                 String cname = rs.getString("comp_name"); 
		String role = rs.getString("job_title"); 
		String edate = rs.getString("examdate"); 
		 
                   
                 out.println("<tr><td>" + id + "</td><td>" + cname + "</td><td>" + role + "</td><td>" + edate + "</td></tr>");   
             }  
             out.println("</table>");  
             out.println("</html></body>");  
             con.close();  
            }  
             catch (Exception e) 
            {  
            	e.printStackTrace();
             out.println("error");  
         }  
     }  
 } 