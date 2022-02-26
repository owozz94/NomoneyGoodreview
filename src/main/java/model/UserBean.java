package model;

import java.io.Serializable;

//현재 로그인중인 사용자 정보 저장
public class UserBean implements Serializable{

	private static final long serialVersionUID = 1L;	private String id;
	private String password;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	private int type;
}
