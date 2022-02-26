package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BlogDAO;
import model.ReviewerBean;
import model.UserBean;

@WebServlet("/ReviewerJoin")
public class ReviewerJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getPost(request, response);
	}	
	protected void getPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ReviewerBean bean = new ReviewerBean();
		BlogDAO bdao = new BlogDAO();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String password_2 = request.getParameter("password_2");
		String name= request.getParameter("name");
		String email= request.getParameter("email");
		String gender= request.getParameter("gender");
		String age= request.getParameter("age");
		String tel= request.getParameter("tel");
		String url= request.getParameter("url");
		if(id.equals("")||password.equals("")||password_2.equals("")||name.equals("")||email.equals("")||gender.equals("")||age.equals("")||tel.equals("")||url.equals("")) {
			//""값
			request.setAttribute("msg", "3");
			RequestDispatcher dis= request.getRequestDispatcher("ReviewerJoin.jsp");
			dis.forward(request, response);
			return;
		}
		if(bdao.getId(id)!=null) {
			//아이디 중복
			request.setAttribute("msg", "1");
			RequestDispatcher dis= request.getRequestDispatcher("ReviewerJoin.jsp");
			dis.forward(request, response);}
			
			else{bean.setId(request.getParameter("id"));
			if(password.equals(password_2)) {
				UserBean user = new UserBean();
				request.getSession().setAttribute("msg", "4");
				bean.setPassword(password);
				bean.setName(name.trim());
				bean.setEmail(email.trim());
				bean.setGender(gender);
				bean.setAge(age);
				bean.setTel(tel.trim());
				bean.setUrl(url.trim());
				bdao.reviewerJoin(bean);
				
				user.setId(id);
				user.setPassword(password_2);
				user.setType(2);
				
				response.sendRedirect("MainThumbnail");
				
				
			}else {
				//비밀번호 불일치
				request.setAttribute("msg", "2");
				RequestDispatcher dis= request.getRequestDispatcher("ReviewerJoin.jsp");
				dis.forward(request, response);
			}
		}
			
	}

}
