<%@ page language="java" import="java.util.*,com.bdqn.jy.*"
	pageEncoding="UTF-8"%>
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

<title>My JSP 'register.jsp' starting page</title>

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
	<%
		request.setCharacterEncoding("utf-8");//设置编码，避免中文乱码
		String uname = request.getParameter("uname");//获取name=uname
		String pwd = request.getParameter("pwd");//获取name=pwd
		String pwd2 = request.getParameter("pwd2");//获取name=pwd
		User u = new User(uname, pwd);
		
		//保存到session,临时存储，关闭网页窗口时清除
		session.setAttribute("uname", uname);
		session.setAttribute("pwd", pwd);
		out.print("<script>alert('注册成功！');location.href='index.jsp';</script>");
		
		/*
		String msg = null;
		String where = "success";
		if (uname == "" || pwd == "") {
			msg = "账户名、密码不能为空!";
			where = "register";
		} else if (uname.length() < 6 || uname.length() > 12) {
			msg = "账户名长度6-12!";
			where = "register";
		} else if (pwd.length() < 6 || pwd.length() > 12) {
			msg = "密码长度6-12";
			where = "register";
		} else if (!(pwd.equals(pwd2))) {
			msg = "两次密码不同";
			where = "register";
		}
		request.setAttribute("u", u);
		request.setAttribute("msg", msg);
		request.setAttribute("where", "index");
		request.getRequestDispatcher(where + ".jsp").forward(request,
				response);
				*/
	%>

</body>
</html>
