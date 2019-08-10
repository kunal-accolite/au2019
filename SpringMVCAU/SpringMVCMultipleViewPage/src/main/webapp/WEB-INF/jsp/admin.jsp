<%@page import="java.util.List"%>
<%@page import="com.accolite.au.User"%>
<%@page import="com.accolite.au.Utility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.hibernate.criterion.Restrictions" %>
<%@ page import="org.hibernate.*" %>
<%@ page import="javax.persistence.criteria.CriteriaBuilder" %>
<%@ page import="javax.persistence.EntityManager" %>
<%@ page import="javax.persistence.EntityManagerFactory" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User details</title>
</head>
<body bgcolor="">
    <table width="500" border="1"><tr><th>Username</th><th>Password</th><th>Count</th>
	<th>Timestamp</th><th>Checked</th>
        <%
        	
            Utility utility=new Utility();
            Session s = utility.getsession();
            Transaction tr = s.beginTransaction();
            Criteria cr = s.createCriteria(User.class);
            List<User> results = cr.list();
            int i=1;
            for(User user: results)
            { 
                out.println("<tr><td>"+user.getUsername()+"</td><td>"+user.getPassword()+"</td><td>"+user.getCount()+"</td><td>"+user.getTs()+
					"</td><td>"+user.isChecked()+"</td></tr>");
                i++;
            }
       %>
      </table>
      <br><br><br>
      <form method="post" action="http://localhost:8080/SpringMVCAU/api/unblock">
      	<input type="text" name="username"></input>
      	<input type="submit" value="unblock"></input>
      </form>
</body>
</html>