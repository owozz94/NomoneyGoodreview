package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AdvertiserBean;
import model.BlogDAO;
import model.UserBean;


@WebServlet("/AdvertiserJoin")
public class AdvertiserJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getPost(request, response);
	}protected void getPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		AdvertiserBean bean = new AdvertiserBean();
		BlogDAO bdao = new BlogDAO();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String password_2 = request.getParameter("password_2");
		String name= request.getParameter("name");
		String email= request.getParameter("email");
		String tel= request.getParameter("tel");
		String restaurantname= request.getParameter("restaurantname");
		String companyname= request.getParameter("companyname");
		String registration= request.getParameter("registration");
		
		if(id.equals("")||password.equals("")||password_2.equals("")||name.equals("")||email.equals("")||restaurantname.equals("")||registration.equals("")||tel.equals("")||companyname.equals("")) {
			//""값
			request.setAttribute("msg", "3");
			RequestDispatcher dis= request.getRequestDispatcher("AdvertiserJoin.jsp");
			dis.forward(request, response);
			return;
		}
		System.out.println("id="+id);
		String check = bdao.getId(id);

		if(bdao.getId(id)!=null) {
			//아이디 중복
			request.setAttribute("msg", "1");
			RequestDispatcher dis= request.getRequestDispatcher("AdvertiserJoin.jsp");
			dis.forward(request, response);
			return;
		}else{
			bean.setId(request.getParameter("id"));
			if(password.equals(password_2)) {
				UserBean user = new UserBean();
				request.getSession().setAttribute("msg", "4");
				bean.setPassword(password);
				bean.setName(name.trim());
				bean.setEmail(email.trim());
				bean.setRestuarnatName(restaurantname.trim());
				bean.setCompanyName(companyname.trim());
				bean.setTel(tel.trim());
				bean.setRegistration(registration);
				bdao.AdvertiserJoin(bean);
				
				user.setId(id);
				user.setPassword(password_2);
				user.setType(1);
				request.getSession().setAttribute("user", user);
				response.sendRedirect("MainThumbnail");
				return;
			}else {
				//비밀번호 불일치
				request.setAttribute("msg", "2");
				RequestDispatcher dis= request.getRequestDispatcher("AdvertiserJoin.jsp");
				dis.forward(request, response);
			}
		}
			
	}
}
