package com.uniquedeveloper.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServerlet
 */
@WebServlet("/register")
public class RegistrationServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public RegistrationServerlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
//		out.print("working");
		Connection con=null;
		String uname=request.getParameter("name");
		String upwd=request.getParameter("password");
		String uemail=request.getParameter("email");
		
		RequestDispatcher dispatcher=null;
//		out.print(uname);
//		out.print(uemail);
//		out.print(umobile);
//		out.print(upwd);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp","root","Mypassword2002#");
			PreparedStatement pst1=con.prepareStatement("select * from users where uemail=?");
			pst1.setString(1, uemail);
			ResultSet rs=pst1.executeQuery();
//			PreparedStatement pst=con.prepareStatement("insert into users(uname,upwd,uemail,umobile) values (?,?,?,?)");
//			pst.setString(1, uname);
//			pst.setString(2, upwd);
//			pst.setString(3, uemail);
//			pst.setString(4, umobile);
//			int rowCount=pst.executeUpdate();
			int count=0;
			while(rs.next()) {
				count++;
			}
			if(count==0) {
				request.setAttribute("unique_user", "true");
				PreparedStatement pst=con.prepareStatement("insert into users(uname,uemail,upwd) values (?,?,?)");
				pst.setString(1, uname);
				pst.setString(2, uemail);
				pst.setString(3, upwd);
				
				int rowCount=pst.executeUpdate();
			
			dispatcher=request.getRequestDispatcher("register.jsp");
			if(rowCount>0) {
				request.setAttribute("status", "success");
			}else {
				request.setAttribute("status", "failed");
			}
//			if(request.getAttribute("status")=="done") {
//				dispatcher=request.getRequestDispatcher("login.jsp");
//				System.out.println("done");
//				
//			}
			dispatcher.forward(request,response);
		}else{
			dispatcher=request.getRequestDispatcher("register.jsp");
			request.setAttribute("unique_user", "false");
			dispatcher.forward(request,response);
			}
		}catch(Exception e) {
			
			}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		}
		
		}



		
	