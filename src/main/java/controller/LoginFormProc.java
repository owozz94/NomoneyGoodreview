package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BlogDAO;
import model.UserBean;

@WebServlet("/LoginFormProc")
public class LoginFormProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getPost(request, response);
	}	
	protected void getPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BlogDAO bdao = new BlogDAO();
		
		String userType = request.getParameter("userType");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		int type=0;
		
		if(userType.toString().trim().equals("reviewer")) {
			type=2;
		}else {
			type=1;
		}
		System.out.println("id="+id);
		System.out.println("password="+password);
		if(("").equals(id)) {
			request.setAttribute("msg", "2");
			RequestDispatcher dis = request.getRequestDispatcher("LoginForm.jsp");
			dis.forward(request, response);
			return;
		}else if(("").equals(password)) {
			request.setAttribute("msg", "3");
			RequestDispatcher dis = request.getRequestDispatcher("LoginForm.jsp");
			dis.forward(request, response);
			return;
		}
		if(type==1&&bdao.getId(id)!=null) {
			bdao.getReviewer(id, password);
			System.out.println(bdao.getReviewer(id, password));
			
			UserBean user = new UserBean();
			user.setId(id);
			user.setPassword(password);
			user.setType(type);
			
			request.getSession().setAttribute("user", user);
			response.sendRedirect("MainThumbnail");
			return;
		}else if(type==2&&bdao.getId(id)!=null){
			bdao.getAdvertiser(id, password);
			System.out.println(bdao.getReviewer(id, password));
			
			UserBean user = new UserBean();
			user.setId(id);
			user.setPassword(password);
			user.setType(type);
			
			request.getSession().setAttribute("user", user);
			response.sendRedirect("MainThumbnail");
			return;
		}
		
		else {
			request.setAttribute("msg", "1");
			RequestDispatcher dis = request.getRequestDispatcher("LoginForm.jsp");
			dis.forward(request, response);
		}
	}
}
