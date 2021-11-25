<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<head>
        <title>Slot Booking</title>
        <style>
            ul#menu li{
                padding: 10px;
                display: inline;
                font-size: 20px;
            }
            input{
                padding: 12px;
                margin: 18px;
            }
        </style>
    </head>

    <body>
    	<%@ page import="java.sql.*" %>
    	<%@ page import="com.ajay.*" %>
    	<%
    	ResultSet rs = null;
	    	try {
				System.out.println("Slot book Connection 1 ");
				Connection con = myConnection.getConnection();
				Statement st = con.createStatement();
				rs = st.executeQuery("select CovaxinDose,Covishield,Sputnik,Moderna from vaccines where date=curdate()");
				System.out.println("Slot book Connection 2 ");
				rs.next();
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
    	%>
        <ul id="menu">
        	<form method="post" action="Booking.html">
        		<li>Covaxin    : <%=rs.getString("CovaxinDose") %> <input type="submit" value="Book Slot"></li>
        	</form>
            
            <br>
            <form method="post" action="BookingCovishield.html">
        		<li>Covishield    : <%=rs.getString("Covishield") %> <input type="submit" value="Book Slot"></li>
        	</form>
            <br>
            <form method="post" action="BookingSputnik.html">
        		<li>Sputnik-V    : <%=rs.getString("Sputnik") %> <input type="submit" value="Book Slot"></li>
        	</form>
            <br>
            <form method="post" action="BookingModerna.html">
        		<li>Moderna    : <%=rs.getString("Moderna") %> <input type="submit" value="Book Slot"></li>
        	</form>  
        </ul>
        
    </body>