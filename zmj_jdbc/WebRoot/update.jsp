<%@page import="com.bdqn.zmj.jdbc.dao.*,com.bdqn.zmj.jdbc.entity.*"%>
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
	
	
	<%
		//request.setCharacterEncoding("utf-8");
		String eid = request.getParameter("eid");
		EmployeeDao dao= new EmployeeDao();
		Employee e=new Employee();
		e.setEid(eid);
		
		List<Employee> list=dao.getList(e);
		if(list.size()>0){
			e=list.get(0);
		}
		String did=	e.getDept().getDid();
	 %>
	
	<form action="doPage/doUpdate.jsp" method="post">
		<input type="hidden" name="eid" value=<%=e.getEid()%>>
		姓名：<input type="text" name="ename" value=<%=e.getEname()%>><br><br> 
		年龄：<input type="number" name="age" value=<%=e.getAge()%>><br><br> 
		部门： <select name="did">
			<option value="1" <%="1".equals(did)?"selected":""%>>开发部</option>
			<option value="2" <%="2".equals(did)?"selected":""%>>实施部</option>
			<option value="3" <%="3".equals(did)?"selected":""%>>测试部</option>
		</select><br><br>
		<input type="submit" value="修改">
		<input type="button" onclick="javascript:history.back()" value="返回">
	</form>

</body>
</html>
