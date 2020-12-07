import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
 /*private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

 
 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  try{
   
    final String JDBC_DRIVER= "com.mysql.jdbc.Driver";
    final String DB_URL="jdbc:mysql://localhost:3306/Ncpproj";
   int flag=0;
    response.setContentType("text/html");
   PrintWriter out=response.getWriter();
   String user=request.getParameter("user"); 
   String p=request.getParameter("psw");  
   String n=request.getParameter("re-psw");
   String ph=request.getParameter("phn");
   String e=request.getParameter("email");  
  
  try
  {
   
   Class.forName(JDBC_DRIVER);
   
  Connection conn =DriverManager.getConnection(DB_URL,"root","teja9999" );
  
  
  PreparedStatement ps=conn.prepareStatement(  
    "insert into StRegister values(?,?,?,?,?)");  
      
    ps.setString(1,user);  
    ps.setString(2,p);  
    ps.setString(3,n);  
    ps.setString(4,ph);  
    ps.setString(5,e);
    int i=ps.executeUpdate();  
    if(i>0)  
    out.print("You are successfully registered..."); 
              
    }catch (Exception e2) 
  {System.out.println(e2);}  
  
             
    out.close(); 
  }
    catch(Exception e)
  {
   System.out.println(e); 
  }
 }

}