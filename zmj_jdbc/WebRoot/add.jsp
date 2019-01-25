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

<title>添加</title>

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
	<form action="doPage/doAdd.jsp" method="post">
		编号：<input type="text" name="eid"><br><br> 
		姓名：<input type="text" name="ename"><br><br> 
		年龄：<input type="number" name="age"><br><br> 
		部门： <select name="did">
			<option value="1">开发部</option>
			<option value="2">实施部</option>
			<option value="3">测试部</option>
		</select><br><br>
		<input type="submit" value="保存">
		<input type="button" onclick="javascript:history.back()" value="返回"><br>
	</form>
</body>
</html>
