package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BlogDAO {
	PreparedStatement pstmt;
	ResultSet rs;
	Connection con;
	
	public void getCon() {
		try {
			Context initctx = new InitialContext();
			Context ctx = (Context) initctx.lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/pool");
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//getCon end
	//게시물 작성
	public void Write(BlogBean bean) {
		getCon();
		int readcount = 0;
		try {
			String sql = "insert into BoardTable values(board_seq.NEXTVAL,?,?,?,?,sysdate,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, readcount);
			pstmt.setString(2, bean.getTitle());
			pstmt.setString(3, bean.getContent());
			pstmt.setString(4, bean.getId());
			pstmt.setString(5, bean.getLocation());
			pstmt.setString(6, bean.getUrl());
			pstmt.executeQuery();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//Write end
	//포스트 썸네일 리스트 갖고오기
	public ArrayList<BlogBean> getList(){
		getCon();
		ArrayList<BlogBean> list = new ArrayList<>();
		
		try {
			String sql = "select * from BoardTable order by num desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BlogBean bean = new BlogBean();
				bean.setNum(rs.getInt(1));
				bean.setReadcount(rs.getInt(2));
				bean.setTitle(rs.getString(3));
				bean.setContent(rs.getString(4));
				bean.setId(rs.getString(5));
				bean.setD_date(rs.getString(6));
				bean.setLocation(rs.getString(7));
				bean.setUrl(rs.getString(8));
				list.add(bean);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//지역별 리스트 갖고오기
	public ArrayList<BlogBean> getLocationList(String location){
		getCon();
		ArrayList<BlogBean> list = new ArrayList<>();
		
		try {
			String sql = "select url, location, title from BoardTable WHERE location=? order by num DESC ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, location);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BlogBean bean = new BlogBean();
				bean.setUrl(rs.getString(1));
				bean.setLocation(rs.getString(2));
				bean.setTitle(rs.getString(3));
				list.add(bean);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	//num에 해당하는 한개의 포스트 가져오기
	public BlogBean getPost(int num){
		getCon();
		BlogBean bean = new BlogBean();
		try {
			String sql = "select * from BoardTable where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,num);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bean.setNum(rs.getInt(1));
				bean.setReadcount(rs.getInt(2));
				bean.setTitle(rs.getString(3));
				bean.setContent(rs.getString(4));
				bean.setId(rs.getString(5));
				bean.setD_date(rs.getString(6));
				bean.setLocation(rs.getString(7));
				bean.setUrl(rs.getString(8));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}//getPost end
	//count 메소드
	public void countUp() {
		getCon();
		try {
			String updateSql = "update BoardTable set READCOUNT=READCOUNT+1";
			pstmt = con.prepareStatement(updateSql);
			pstmt.executeQuery();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//최신 글 번호 가져오기.
	public int getPostNum() {
		int num =0;
		getCon();
		try {
			String sql="SELECT NUM FROM (SELECT * FROM sys.BoardTable ORDER BY NUM DESC) WHERE ROWNUM =1";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	//리뷰어 회원가입
	public void reviewerJoin(ReviewerBean bean) {
		getCon();
		int type = 2; //리뷰어
		try {
			String sql="insert into REVIEWER values(?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getPassword());
			pstmt.setString(3, bean.getName());
			pstmt.setString(4, bean.getEmail());
			pstmt.setString(5, bean.getGender());
			pstmt.setString(6, bean.getAge());
			pstmt.setString(7, bean.getTel());
			pstmt.setString(8, bean.getUrl());
			pstmt.setInt(9, type);
			pstmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//reviewerJoin end
	//광고주 회원가입
	public void AdvertiserJoin(AdvertiserBean bean) {
		getCon();
		int type = 1; //광고주
		try {
			String sql="insert into ADVERTISER values(?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getPassword());
			pstmt.setString(3, bean.getName());
			pstmt.setString(4, bean.getEmail());
			pstmt.setString(5, bean.getTel());
			pstmt.setString(6, bean.getRestuarnatName());
			pstmt.setString(7, bean.getCompanyName());
			pstmt.setString(8, bean.getRegistration());
			pstmt.setInt(9, type);
			pstmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//reviewerJoin end
	//입력된 id가 존재하는지 여부
	public String getId(String id) {
		String getId=null;
		getCon();
		try {
			String sql="SELECT * from(SELECT id FROM REVIEWER UNION SELECT id from ADVERTISER) WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				getId = rs.getString(1);
			}
			con.close();
			} catch (Exception e) {
			e.printStackTrace();
		}
		return getId;
	}
	public boolean getAdvertiser(String id, String password) {
		getCon();
		try {
			String sql = "select * from ADVERTISER where id=? and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2,password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			con.close();
			} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}//getAdvertiser end
	
	//reviewer table에 존재하는지
	public boolean getReviewer(String id, String password) {
		getCon();
		try {
			String sql = "select * from REVIEWER where id=? and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2,password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}//getReviewer end
	//댓글 작성
	public void insertComment(int num, String id, String comment) {
		getCon();
		try {
			String sql = "insert into USERCOMMENT values(?,comment_seq.NEXTVAL,?,sysdate,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, id);
			pstmt.setString(3, comment);
			pstmt.executeUpdate();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	//현재 COMMENTNUM 갖고오기
	
	//하나의 게시글에 해당하는 댓글 전체 가져오기.
	public ArrayList<UserComment> getComment(int num) {
		ArrayList<UserComment> list = new ArrayList<>();
		getCon();
		try {
			String sql = "select * from UserComment where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				UserComment ucmnt = new UserComment();
				ucmnt.setNum(rs.getInt(1));
				ucmnt.setCommentNum(rs.getInt(2));
				ucmnt.setId(rs.getString(3));
				ucmnt.setD_date(rs.getString(4));
				ucmnt.setContent(rs.getString(5));
				list.add(ucmnt);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public void postUpdate(String title, String location, String content, String url,int num) {
		getCon();
		try {
			String sql = "update BoardTable set Title=?, LOCATION=?, CONTENT=?, URL=?,d_date=sysdate where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,title);
			pstmt.setString(2,location);
			pstmt.setString(3,content);
			pstmt.setString(4, url);
			pstmt.setInt(5,num);
			pstmt.executeQuery();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void commentDelete(int commentNum) {
		getCon();
		try {
			String sql = "delete from UserComment where COMMENTNUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, commentNum);
			pstmt.executeQuery();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//commentDelete end
	public void postDelete(int num) {
		getCon();
		try {
			String sql = "delete from BoardTable where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeQuery();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//postDelete end
	public void UserDelete(String id, String pass, int typeNum) {
		getCon();
		String type="";
		try {
			if(typeNum==1) {
				type="ADVERTISER";
			}else {
				type="REVIEWER";
			}
			String sql = "delete from "+type+" where id=? and password=? and type=?";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			pstmt.setInt(3, typeNum);
			pstmt.executeQuery();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//UserDelete end
}
