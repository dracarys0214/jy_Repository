package com.bdqn.jy;

public class User {
	private String uname;
	private String pwd;

	public User(String uname, String pwd) {
		super();
		this.uname = uname;
		this.pwd = pwd;
	}

	public User() {
		super();
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
