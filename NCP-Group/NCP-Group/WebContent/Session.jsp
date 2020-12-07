<%@ page import = "java.io.*,java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%
   // Get session creation time.
   Date createTime = new Date(session.getCreationTime());
   
   // Get last access time of this Webpage.
   Date lastAccessTime = new Date(session.getLastAccessedTime());

   String title = "Saved Jobs";
   Integer visitCount = new Integer(1);
   String visitCountKey = new String("SavedJobCount");
   String userIDKey = new String("userID");
   String userID = new String("User");
   String JobListKey=new String("JobList");
   List <List<String>> JobList=new ArrayList<List<String>>();
   // Check if this is new comer on your Webpage.
   if (session.isNew() ){
      title = "Your saved jobs";
      session.setAttribute(userIDKey, userID);
      session.setAttribute(visitCountKey,  visitCount);
      String Company=request.getParameter("Company");
      String JobTitle=request.getParameter("JobTitle");
      String GPA=request.getParameter("GPA");
      String CTC=request.getParameter("CTC");
      String ApplyBy=request.getParameter("ApplyBy");
      List<String> newJob=new ArrayList<String>();
      newJob.add(Company);
      newJob.add(JobTitle);
      newJob.add(GPA);
      newJob.add(CTC);
      newJob.add(ApplyBy);
      System.out.println(Arrays.toString(newJob.toArray()));
      JobList.add(newJob);
      session.setAttribute(JobListKey,JobList);
   } 
   else{
   visitCount = (Integer)session.getAttribute(visitCountKey);
   //System.out.print(visitCount);
   //if(visitCount==null){
	 //  visitCount=0;
   //}
   visitCount = visitCount + 1;
   userID = (String)session.getAttribute(userIDKey);
   session.setAttribute(visitCountKey,  visitCount);
   JobList= (List <List<String>>)session.getAttribute(JobListKey);
   String Company=request.getParameter("Company");
   String JobTitle=request.getParameter("JobTitle");
   String GPA=request.getParameter("GPA");
   String CTC=request.getParameter("CTC");
   String ApplyBy=request.getParameter("ApplyBy");
   List<String> newJob=new ArrayList<String>();
   newJob.add(Company);
   newJob.add(JobTitle);
   newJob.add(GPA);
   newJob.add(CTC);
   newJob.add(ApplyBy);
   JobList.add(newJob);
   session.setAttribute(JobListKey,JobList);  
   System.out.println("["); 
   
   for (List<String> list : JobList) { 
       System.out.print("  ["); 

       for (String item : list) { 
           System.out.print("  "
                            + item 
                            + ", "); 
       } 
       System.out.println("], "); 
   } 
   System.out.println("]"); 
   }
%>

 <html>
   <head>
      <title>Session Tracking</title>
   </head>
   
   <body>
   		<script language="javascript" type="text/javascript">
   		var a = <%= JobList%>;
   		document.write(a);
   		document.write("<table><th>Company</th><th>Job Title</th><th>GPA</th><th>CTC</th><th>ApplyBy</th>")
   		
   		for (var a=0; a < <%=visitCount%>; a++) {
            	document.write("<tr>");
            	//List<String> listel=JobList.get(a);
                	document.write("<td>"+<%= JobList.get(0).get(1)%>+"</td>");
                	document.write("<td>"+<%= JobList.get(0).get(1)%>+"</td>");
                	document.write("<td>"+<%= JobList.get(0).get(2)%>+"</td>");
                	document.write("<td>"+<%=JobList.get(0).get(3) %>+"</td>");
                	document.write("<td>"+<%= JobList.get(0).get(4)%>+"</td>");
       			document.write("</tr>");
       	}
   		document.write("</table>")
    </script>
      <center>
         <h1>Your saved jobs</h1>
      </center>
      
      <table border = "1" align = "center"> 
         <tr bgcolor = "#949494">
            <th>Session info</th>
            <th>Value</th>
         </tr> 
         <tr>
            <td>id</td>
            <td><% out.print( session.getId()); %></td>
         </tr> 
         <tr>
            <td>Creation Time</td>
            <td><% out.print(createTime); %></td>
         </tr> 
         <tr>
            <td>Time of Last Access</td>
            <td><% out.print(lastAccessTime); %></td>
         </tr> 
         <tr>
            <td>User ID</td>
            <td><% out.print(userID); %></td>
         </tr> 
         <tr>
            <td>Number of Saved Jobs</td>
            <td><% out.print(visitCount); %></td>
         </tr> 
      </table> 
      
      <table border = "1" align = "center">
      <tr bgcolor = "#949494">
      <th>Company</th><th>Job Title</th><th>GPA</th><th>CTC</th><th>Apply By</th>
      </tr>
      <% ArrayList users = (ArrayList)JobList;
      	for (int i = 0; i < users.size(); i++)
      	 { List user = (List)users.get(i);
      	    out.print("<tr><td>");
      	    out.print(user.get(0));
      	    out.print("</td><td>");
      	 	out.print(user.get(1));
      	 	out.print("</td><td>");
      		out.print(user.get(2));
      		out.print("</td><td>");
      		out.print(user.get(3));
      		out.print("</td><td>");
      		out.print(user.get(4));
      		out.print("</td></tr>");
      	 %>
      <% } %>
      </table>
      
   
   </body>
</html>
