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
			String uname = "";
			String pwd = "";
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie c : cookies) {
					if (c.getName().equals("uname")) {
						uname=c.getValue();
					}else if(c.getName().equals("pwd")){
						pwd=c.getValue();
					}

				}
			}
		%>
		<form action="doLogin.jsp" method="post">
			<fieldset>
				<legend>登陆</legend>
				<br> <label for="uname">账号</label> <input type="text"
					id="uname" name="uname" value="<%=uname%>"><br>
				<br> <label for="pwd">密码</label> <input type="password"
					id="pwd" name="pwd" value="<%=pwd%>"><br> <input type="checkbox"
					name="save">保存密码<br> <br> <input type="submit"
					value="登陆"> <input type="reset" value="取消">
				<p><%=request.getAttribute("msg") == null ? "" : request
					.getAttribute("msg")%></p>
				<a href="register.jsp">没有账号？注册</a>
			</fieldset>
		</form>
	</div>

</body>
</html>
