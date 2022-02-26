package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BlogBean;
import model.BlogDAO;
import model.UserBean;
import model.UserComment;

public class GetPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getPost(request, response);
	}protected void getPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BlogDAO bdao = new BlogDAO();
		BlogBean bean = new BlogBean();
		UserBean user = (UserBean) request.getSession().getAttribute("user");
		String option = request.getParameter("option");
		int num = Integer.parseInt(request.getParameter("num"));
		//댓글 가져오기
		ArrayList<UserComment> list = bdao.getComment(num);
		//작성자인 경우 : 게시물 num, id가 일치
		request.getSession().setAttribute("comment", list);
		request.getSession().setAttribute("center", "Post.jsp");
		String comentExist = (String) request.getAttribute("comment");
		
		//수정하기 버튼을 눌렀을 경우
		if(("update").equals(option)) {
			System.out.println(num);
			bean = bdao.getPost(num);
			RequestDispatcher dis = request.getRequestDispatcher("PostUpdate.jsp");
			dis.forward(request, response);
			return;
		}else if(comentExist!=null){
			//일반 사용자의 경우
			//num에 해당하는 한개의 게시글 갖고오기.
			bean = bdao.getPost(num);
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("BlogBean", bean);
			request.getSession().setAttribute("center", "Post.jsp");
			response.sendRedirect("Main.jsp");
			return;
		}
		bdao.countUp();
		bean = bdao.getPost(num);
		request.getSession().setAttribute("user", user);
		request.getSession().setAttribute("BlogBean", bean);
		request.getSession().setAttribute("center", "Post.jsp");
		response.sendRedirect("Main.jsp");
		
	}
}
