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

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
form {
	width: 16%;
	text-align: center;
	margin: 10% auto;
}

a {
	font-size: 12px;
	float: right;
}
</style>

</head>

<body>
	<div>
		
		<%
			String num = application.getAttribute("count").toString();
			int oldCount = (num == null ? 0 : Integer.parseInt(num));
			
			/* 第二个参数为字符串  */
			application.setAttribute("count", ++oldCount+"");
		
		%>
		<p>当前访问人数：<%=application.getAttribute("count")%></p>
	</div>

</body>
</html>
