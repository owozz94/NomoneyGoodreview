package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BlogBean;
import model.BlogDAO;

public class MainThumbnail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getPost(request, response);
	}protected void getPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BlogDAO bdao = new BlogDAO();
		ArrayList<BlogBean> list = new ArrayList<>();
		String location = request.getParameter("location");
		if(location!=null) {
			list = bdao.getLocationList(location);
		}else {
			list = bdao.getList();
		}
		request.getSession().setAttribute("location", location);
		request.getSession().setAttribute("center", "ThumbnailList.jsp");
		request.getSession().setAttribute("list", list);
		response.sendRedirect("Main.jsp");
	}

}
