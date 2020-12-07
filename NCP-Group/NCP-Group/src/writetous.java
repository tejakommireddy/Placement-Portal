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

/* Servlet implementation class SignupServlet*/
@WebServlet("/writetous")
public class writetous extends HttpServlet {
  /*private static final long serialVersionUID = 1L;
       
    /
     * @see HttpServlet#HttpServlet()
     */
    public writetous() {
        super();
        // TODO Auto-generated constructor stub
    }

  
  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
  {
    // TODO Auto-generated method stub
    try{
      int flag=0;
       response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      String user=request.getParameter("name"); 
      String phone=request.getParameter("contactph");  
      String email=request.getParameter("contactemail");
      String msubject=request.getParameter("contactsub");
      String message=request.getParameter("contactmsg");  
    
    try
    {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/NCPProj","root","sneha");
    
    
    PreparedStatement ps=conn.prepareStatement(  
        "insert into writetous values(?,?,?,?,?)");  
          
        ps.setString(1,user);  
        ps.setString(2,phone);  
        ps.setString(3,email);  
        ps.setString(4,msubject);  
        ps.setString(5,message);
        int i=ps.executeUpdate();  
        if(i>0)  
        out.print("Message sent successfully..."); 
        
            
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