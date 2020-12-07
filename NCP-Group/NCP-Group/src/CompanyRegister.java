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

/* Servlet implementation class CompanyRegister*/
@WebServlet("/CompanyRegister")
public class CompanyRegister extends HttpServlet {
  /*private static final long serialVersionUID = 1L;
       
    /
     * @see HttpServlet#HttpServlet()
     */
    public CompanyRegister() {
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
      String nameoforg=request.getParameter("nameoforg"); 
      String natureofb=request.getParameter("natureofb");  
      String rolesoff=request.getParameter("rolesoff");
      String contactnum=request.getParameter("contactnum");
      String numberofemp=request.getParameter("numberofemp");  
      String annualturnover=request.getParameter("annualturnover");
      String requirednumstudents=request.getParameter("requirednumstudents");
      String mail=request.getParameter("mail");
      String about=request.getParameter("about");
    
    try
    {
      
      Class.forName(JDBC_DRIVER);
      
    Connection conn =DriverManager.getConnection(DB_URL,"root","sneha" );
    
    
    PreparedStatement ps=conn.prepareStatement(  
        "insert into CompName values(?,?,?,?,?,?,?,?,?)");  
          
        ps.setString(1,nameoforg);  
        ps.setString(2,natureofb);  
        ps.setString(3,rolesoff);  
        ps.setString(4,contactnum);  
        ps.setString(5,numberofemp);
        ps.setString(6,annualturnover);
        ps.setString(7,requirednumstudents);
        ps.setString(8,mail);
        ps.setString(9,about);
        int i=ps.executeUpdate();  
        if(i>0)  
        out.print("You are successfully registered..."); 
        
        response.sendRedirect("CompProfile.jsp");
                  
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