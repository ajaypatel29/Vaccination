package com.ajay;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Connection
 */
@WebServlet("/Connection")
public class myConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myConnection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}
	public static Connection getConnection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/vaccination";
		String userName = "root";
		String pass = "12345";
		
		try{
			System.out.println("Driver Not loaded");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			con = DriverManager.getConnection(url,userName,pass);
			System.out.println("Connection successful");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
