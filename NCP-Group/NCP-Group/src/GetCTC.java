import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/GetCTC")
public class GetCTC extends HttpServlet{
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GetCTC() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Float symbol = Float.parseFloat(request.getParameter("CTC"));
		//System.out.println(symbol);
		PrintWriter out = response.getWriter();
		//out.println("symbol:"+symbol);
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/NCPProj","root","sneha");
		System.out.println("Connected");
		PreparedStatement pst=con.prepareStatement("select * from jobavail where CTC>=?");
    	pst.setFloat(1,symbol);
    	ResultSet rs=pst.executeQuery();
    	System.out.println("no error");
    	/*out.println("<html><style>th{background-color:red;color:white;height:50px}td{height:40px;}</style><body><table border='1' align='center' width='80%'>");
    	out.println("<th>Company</th><th>Job Title</th><th>GPA Criteria</th><th>CTC</th><th>Apply By</th><th>Save Job</th>");
    	while(rs.next())
    		{
    		out.println("<tr><td>");
    		out.println(rs.getString(2));
    		out.println("</td><td>");
    		out.println(rs.getString(3));
    		out.println("</td><td>");
    		out.println(rs.getFloat(4));
    		out.println("</td><td>");
    		out.println(rs.getFloat(5));
    		out.println("</td><td>");
    		out.println(rs.getString(6));
    		out.println("</td>");
    		out.println("<td>");
    		String s="http://localhost:8081/NCP_Class/Session.jsp?Company="+rs.getString(2)+"&JobTitle="+rs.getString(3)+"&GPA="+rs.getString(4)+"&CTC="+rs.getString(5)+"&ApplyBy="+rs.getString(6);
    		out.println("<a href=");
            out.println(s);
            out.println("><button>Save Job</button></a>");
    		out.println("</td></tr>");
    		 System.out.println(rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4)+" "+rs.getFloat(5)+" "+rs.getString(6));
    		}
    	out.println("</table></body></html>");*/
    	out.println("<html><style>th{background-color:red;color:white;height:50px}td{height:40px;}</style><body><table border='1' align='center' width='80%'>");
    	out.println("<th>Company</th><th>Job Title</th><th>GPA Criteria</th><th>CTC</th><th>Apply By</th><th>Save Job</th>");
    	while(rs.next())
    		{
    		out.println("<tr><td>");
    		out.println(rs.getString(2));
    		out.println("</td><td>");
    		out.println(rs.getString(3));
    		out.println("</td><td>");
    		out.println(rs.getFloat(4));
    		out.println("</td><td>");
    		out.println(rs.getFloat(5));
    		out.println("</td><td>");
    		out.println(rs.getString(6));
    		out.println("</td>");
    		out.println("<td>");
    		String s="http://localhost:8081/NCP-Group/Session.jsp?Company="+rs.getString(2)+"&JobTitle="+rs.getString(3)+"&GPA="+rs.getString(4)+"&CTC="+rs.getString(5)+"&ApplyBy="+rs.getString(6);
    		out.println("<a href=");
            out.println(s);
            out.println("><button>Save Job</button></a>");
    		out.println("</td></tr>");
    		 //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getFloat(3)+" "+rs.getFloat(4)+" "+rs.getString(5));
    		}
    	out.println("</table></body></html>");

    	con.close();
		}
		catch(Exception e) {
		}
		
	}
}
