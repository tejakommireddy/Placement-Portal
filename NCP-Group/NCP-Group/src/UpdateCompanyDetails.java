import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.*;

class Company{
	String CompanyID=null;
	String CompanyName=null;
	String Location=null;
	String PointOfContact=null;
	long Phone=0;
	String Email=null;
	public void setID(String a) {
		CompanyID=a;
	}
	public void setName(String a) {
		CompanyName=a;
	}
	public void setLocation(String a) {
		
		Location=a;
	}
	public void setPoint(String a) {
		PointOfContact=a;
	}
	public void setPhone(long a) {
		Phone=a;
	}
	public void setEmail(String a) {
		Email=a;
	}
}
@WebServlet("/UpdateCompanyDetails")
public class UpdateCompanyDetails extends HttpServlet{
	static Company getCompany(Node node) {
        //XMLReaderDOM domReader = new XMLReaderDOM();
        Company com = new Company();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            com.setID(getTagValue("CompanyID", element));
            com.setName(getTagValue("CompanyName", element));
            com.setLocation(getTagValue("Location",element));
            com.setPoint(getTagValue("PointOfContact",element));
            com.setPhone(Long.parseLong(getTagValue("Phone", element)));
            com.setEmail(getTagValue("Email",element));
        }

        return com;
    }
	static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UpdateCompanyDetails() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/NCPProj","root","sneha");
			PrintWriter out = response.getWriter();
			String filePath = "C://Users/Sneha/Videos/NCPProj.xml";
	        File xmlFile = new File(filePath);
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder;
	        try {
	            dBuilder = dbFactory.newDocumentBuilder();
	            Document doc = dBuilder.parse(xmlFile);
	            doc.getDocumentElement().normalize();
	            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	            NodeList nodeList = doc.getElementsByTagName("Company");
	            List<Company> comList = new ArrayList<Company>();
	            for (int i = 0; i < nodeList.getLength(); i++) {
	                comList.add(getCompany(nodeList.item(i)));
	            }
	            //lets print Employee list information
	            PreparedStatement stmt;
	            Statement statement=con.createStatement();
	            statement.executeUpdate("TRUNCATE Company");
	            for (Company com : comList) {
	                stmt=con.prepareStatement("insert into Company values(?,?,?,?,?,?)");
		            stmt.setString(1,com.CompanyID);
		            stmt.setString(2,com.CompanyName);
		            stmt.setString(3, com.Location);
		            stmt.setString(4, com.PointOfContact);
		            stmt.setLong(5, com.Phone);
		            stmt.setString(6, com.Email);
		            stmt.executeUpdate();
	            }
	            System.out.println("Succesfull!");
	            out.println("<html><body><h2>Database has been updated successfully!</h2></body></html>");
	        } catch (SAXException | ParserConfigurationException | IOException e1) {
	            e1.printStackTrace();
	        }
			
			con.close();

			}
		catch(Exception e){ System.out.println(e);}

	}
		
	}
