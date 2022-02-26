package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.buf.StringUtils;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.BlogBean;
import model.BlogDAO;
import model.UserBean;

public class FileProc extends HttpServlet {
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
		BlogBean bean = new BlogBean();
		
		String realfolder=""; 
		//실제로 만들어질 폴더명을 설정 
		String savefolder = "/upload"; 
		String encType = "UTF-8"; 
		int maxSize = 10*1024*1024;//5m
		//파일이 저장될 경로 값을 읽어 오는 객체 
		ServletContext context = getServletContext();
		realfolder = context.getRealPath(savefolder);
		
		MultipartRequest multi = new MultipartRequest(request, realfolder, maxSize, encType, 
				new DefaultFileRenamePolicy()); //파일 이름을 변경을 자동
		UserBean user = (UserBean) request.getSession().getAttribute("user");
		
		String id = user.getId();
		String option=multi.getParameter("option");
		String title = multi.getParameter("title");
		String location = multi.getParameter("location");
		String content = multi.getParameter("content");
		String filename = multi.getFilesystemName("filename");
		String url = "";
			if(filename!=null) {
				url = "upload\\"+filename;
				bean.setUrl(url);
			}
			if(content.equals("")) {
		         request.setAttribute("msg", "2");
		         RequestDispatcher dis = request.getRequestDispatcher("WriteForm.jsp");
		         dis.forward(request, response);
		      }
			if(title.equals("")) {
		         request.setAttribute("msg", "1");
		         RequestDispatcher dis = request.getRequestDispatcher("WriteForm.jsp");
		         dis.forward(request, response);
		      }
			//update문
			if(option!=null) {
				BlogBean bb= (BlogBean) request.getSession().getAttribute("BlogBean");
				String path = realfolder.substring(1,98);
				String bbUrl = "c"+path+bb.getUrl();
				System.out.println("bbUrl="+bbUrl);
				if(bbUrl!=null) {
					File file = new File(bbUrl);
				if(file.exists()) { //파일이 존재하면 삭제
					file.delete();
					System.out.println("이전 이미지 삭제완료");
				}
			}
				if(filename!=null) {
				url = "upload\\"+filename;
		}
			bdao.postUpdate(title, location, content, url,bb.getNum());
			option = null;
			 response.sendRedirect("MainThumbnail");
			return;
			}else {
		    	 bean.setLocation(location);
		    	 bean.setTitle(title);
		    	 bean.setContent(content);
		    	 bean.setId(id);
		         bdao.Write(bean);
		         response.sendRedirect("MainThumbnail");
		         return;
			      
			}
		}
	}	
