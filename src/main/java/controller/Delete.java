package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BlogBean;
import model.BlogDAO;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getPost(request, response);
	}protected void getPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BlogDAO bdao = new BlogDAO();
		String option = request.getParameter("option");
		int num = Integer.parseInt(request.getParameter("num"));
		
		if(option!=null) {
			BlogBean bb= (BlogBean) request.getSession().getAttribute("BlogBean");
			ServletContext context = getServletContext();
			String savefolder = "/upload"; 
			String realfolder = context.getRealPath(savefolder);
			String path = realfolder.substring(1,98);
			String bbUrl = "c"+path+bb.getUrl();
			if(bbUrl!=null) {
				File file = new File(bbUrl);
			if(file.exists()) { //파일이 존재하면 삭제
				file.delete();
				System.out.println("이전 이미지 삭제완료");
			}
		}
		bdao.postDelete(num);
		System.out.println("게시물 삭제");
		response.sendRedirect("MainThumbnail");
		}
	}

}
