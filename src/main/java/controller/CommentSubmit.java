package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BlogDAO;
import model.UserBean;
import model.UserComment;
@WebServlet("/CommentSubmit")
public class CommentSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getPost(request, response);
	}
	protected void getPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UserComment ucmt = new UserComment();
		BlogDAO bdao = new BlogDAO();
		UserBean user = (UserBean) request.getSession().getAttribute("user");
		int num = Integer.parseInt(request.getParameter("num"));
		String id = user.getId();
		String comment = request.getParameter("comment");
		
		String type = request.getParameter("type");
		String commentNum = request.getParameter("commentNum");
		if(type!=null) {
			//댓글 삭제
			bdao.commentDelete(Integer.parseInt(commentNum));
		}else {
			//댓글 삽입
		bdao.insertComment(num,id,comment);
		}
		ucmt.setId(id);
		ucmt.setContent(comment);
		ucmt.setNum(num);
		request.getSession().setAttribute("ucmt", ucmt);
		request.setAttribute("comment", "exist");
		RequestDispatcher dis = request.getRequestDispatcher("GetPost");
		dis.forward(request, response);
		
	}

}
