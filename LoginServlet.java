package com;

import jakarta.servlet.RequestDispatcher;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet Called");
		String uname = request.getParameter("UserName");
		String pass = request.getParameter("Pwd");
		RequestDispatcher rd = null;
		if(uname.equals("admin") && uname.equals(pass)) {
			System.out.println("Succesfully Login");
			rd = request.getRequestDispatcher("success.html");
			
		}
		else {
			System.out.println("Login Unsucessfull");
			rd = request.getRequestDispatcher("error.html");

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpSe, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String e = request.getParameter("employeeId");
		String n = request.getParameter("name");
		String age = request.getParameter("age");

		String g = request.getParameter("gender");
		String c = request.getParameter("city");
        int a = Integer.parseInt(age);
        int ei = Integer.parseInt(e);


		
		try {
			// 1. Register driver class
			Class.forName("com.mysql.jdbc.Driver");
			// 2. create the connection

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","vishal");
		
		   // 3. Create PreparedStatement
			
			String query = "insert into emptable values(?,?,?,?,?)"; // ? => placeholder
			PreparedStatement pstmt =conn.prepareStatement(query);
			pstmt.setInt(1,ei);
			pstmt.setString(2,n);
			pstmt.setInt(3,a);
			pstmt.setString(4,g);
			pstmt.setString(5,c);


			
			int row = pstmt.executeUpdate();
			System.out.println(" inserted.....");
		
		}
		catch(Exception ex){
		System.out.println(ex);
		}
	}
		public void allEmployeeData() {
			
		}

}

