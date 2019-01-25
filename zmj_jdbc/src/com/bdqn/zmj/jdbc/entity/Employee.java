package com.bdqn.zmj.jdbc.entity;


public class Employee {
	private String eid;
	private String ename;
	private String age;
	private Dept dept=new Dept();
	public Employee(String eid, String ename, String age, Dept dept) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.age = age;
		this.dept = dept;
	}
	public Employee() {
		super();
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	

}
