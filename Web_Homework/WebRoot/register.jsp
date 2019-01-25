<%@ page language="java" import="java.util.*,com.bdqn.jy.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
 	<style>
        form {
            width: 20%;
            text-align: center;
            margin: 10% auto;
        }
        a{
            font-size: 12px;
            float: right;
        }
        .la{
            margin-left: -2em;
        }
    </style>
</head>
<body>
<div>
    <form action="doRegister.jsp" method="post">
        <fieldset>
            <legend>注册</legend>
            <br>
            <label for="uname">账号</label>
            <input type="text" id="uname" name="uname" placeholder="字母+数字,长度6-12"><br><br>
            <label for="pwd">密码</label>
            <input type="password" id="pwd" name="pwd" placeholder="字母+数字,长度6-12"><br><br>
            <label class="la" for="pwd2">确认密码</label>
            <input type="password" id="pwd2" name="pwd2"><br>
            <br>
            <input type="submit" value="登陆">
            <input type="reset" value="取消">
            <p><%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%></p>
        </fieldset>
    </form>
</div>
  </body>
</html>
