package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BlogDAO;

@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getPost(request, response);
	}protected void getPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BlogDAO bdao = new BlogDAO();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		if(("").equals(password)||("").equals(id)) {
			request.getSession().setAttribute("msg", "2");
			response.sendRedirect("MainThumbnail");
			return;
		}
		if(bdao.getAdvertiser(id, password)) {
			bdao.UserDelete(id, password,1);
			HttpSession session =  request.getSession();
			session.invalidate();
			response.sendRedirect("MainThumbnail");
			return;
		}
		else if(bdao.getReviewer(id, password)) {
			bdao.UserDelete(id, password, 2);
			HttpSession session =  request.getSession();
			session.invalidate();
			response.sendRedirect("MainThumbnail");
			return;
		}else {
			request.getSession().setAttribute("msg", "1");
			response.sendRedirect("MainThumbnail");
			return;
		}
		
		
	}

}
