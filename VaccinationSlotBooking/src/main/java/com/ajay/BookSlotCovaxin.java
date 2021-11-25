package com.ajay;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookSlotCovaxin
 */
@WebServlet("/BookSlotCovaxin")
public class BookSlotCovaxin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSlotCovaxin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String mobile = request.getParameter("mobile");
		String aadhar = request.getParameter("aadhar");
	
		try {
			System.out.println("Slot book Connection 1 ");
			Connection con = myConnection.getConnection();
			PreparedStatement st = con.prepareStatement("insert into consumer values(curdate(),?,?,?,?)");
			PreparedStatement st1 = con.prepareStatement("insert into vaccinationDetails values(?,0,?,curdate())");
			Statement cst2 = con.createStatement();
			st.setString(1,name);
			st.setInt(2,age);
			st.setString(3,mobile);
			st.setString(4,aadhar);
			st1.setString(1, aadhar);
			st1.setString(2, "Covaxin");
			st.executeUpdate();
			st1.executeUpdate();
			cst2.execute(("update vaccines set CovaxinDose = CovaxinDose - 1  where date = curdate()"));
			System.out.println("Slot book Connection 2 ");
			st.close();
			con.close();
			RequestDispatcher RequestDispatcherObj = request.getRequestDispatcher("/VaccinationDetail.jsp");
			RequestDispatcherObj.forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
