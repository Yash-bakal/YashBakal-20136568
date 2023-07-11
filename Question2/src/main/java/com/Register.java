package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

public class Register extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
	   int id = Integer.parseInt(request.getParameter("uid"));
	   String name = request.getParameter("uname");
	   int phn = Integer.parseInt(request.getParameter("uphn"));
	   int mark = Integer.parseInt(request.getParameter("umarks"));
	   String branch = request.getParameter("ubranch");
	   
	   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/igt1","root","Sqlreset123@#");
		    PreparedStatement pstmt = con.prepareStatement("insert into test1 values(?,?,?,?,?)"); 
		    
		    pstmt.setInt(1, id);
		    pstmt.setString(2, name);
		    pstmt.setInt(3, phn);
		    pstmt.setInt(4, mark);
		    pstmt.setString(5, branch);
		    
		    pstmt.execute();
		    pstmt.close();
		    
			RequestDispatcher rd = request.getRequestDispatcher("Sucess.html");
			rd.forward(request, response);
		   // PrintWriter out = response.getWriter();
		    //out.print("<h3>Congrats you are successfully registered</h3>");
		   
	   }
		catch(Exception e){
		      System.out.println(e);	
		}
	}


}
