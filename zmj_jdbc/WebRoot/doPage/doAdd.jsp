<%@page import="com.bdqn.zmj.jdbc.dao.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'doAdd.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	This is my JSP page.
	<br>
	<%
		//request.setCharacterEncoding("utf-8");
		String eid = request.getParameter("eid");
		String ename = request.getParameter("ename");
		String age = request.getParameter("age");
		String did = request.getParameter("did");
		
		EmployeeDao dao= new EmployeeDao();
		String sql="insert into employee(emp_id,emp_name,age,dept_id) values(?,?,?,?)";
		int flag=dao.executeUpdate(sql, eid,ename,age,did);
		if(flag==1){
		out.write("<script>alert('添加成功');</script>");
		}else{
		out.write("<script>alert('添加失败');</script>");
		}	
		out.write("<script>location.href='index.jsp';</script>");
	%>



</body>
</html>
