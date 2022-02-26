package model;

public class UserComment {
	//댓글
	private int num; 
	private int commentNum;
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	private String id; 
	private String d_date; 
	private String content;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getD_date() {
		return d_date;
	}
	public void setD_date(String d_date) {
		this.d_date = d_date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	} 
	

}
