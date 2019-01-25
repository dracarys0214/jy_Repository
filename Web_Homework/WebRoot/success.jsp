<%@ page language="java" import="java.util.*,com.bdqn.jy.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<script src="jquery-3.3.1.js"></script>
    <style>
        p{
            text-align: center;
            margin-top: 10%;
            font-size: 30px;
        }
    </style>
</head>
<body>
	<%! String where="";%>
	<%
		User u=(User)request.getAttribute("u");
		 where=request.getAttribute("where").toString();
		System.out.print(where);
		String msg=(where=="game"?"登陆":"注册");
		//Thread.sleep(3000);
		//request.getRequestDispatcher(where+".jsp").forward(request,response);
		
	%>
    <p>恭喜<%=u.getUname() %><%=msg %>成功!</p>
    <p>3秒后跳转</p>
    <span class="sp"><%=where%></span>
  </body>
  <script>
  var where=$(".sp").hide().html();
  setTimeout("location.href='"+where+".jsp'",3000);//3秒后跳转
</script>
</html>
