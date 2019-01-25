package com.bdqn.zmj.jdbc.entity;

public class Dept {
	private String did;
	private String dname;
	public Dept(String did, String dname) {
		super();
		this.did = did;
		this.dname = dname;
	}
	public Dept() {
		super();
	}
	public Dept(String did) {
		super();
		this.did = did;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}


}
