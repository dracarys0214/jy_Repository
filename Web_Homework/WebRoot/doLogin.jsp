<%@ page language="java" import="java.util.*,com.bdqn.jy.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'verifyLogin.jsp' starting page</title>
    
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
			
			/*  session*/
			/* 	String sname=session.getAttribute("uname").toString();
			String spwd=session.getAttribute("pwd").toString(); */
			
			
			
			String save=request.getParameter("save");
			
			out.print("是否保存"+save);
			
			
			if(uname.equals("admin")&&pwd.equals("1234")){
				session.setAttribute("loginUser", uname);
				session.setMaxInactiveInterval(3600);
				if("on".equals(save)){
					Cookie cookie1=new Cookie("uname",uname);
					Cookie cookie2=new Cookie("pwd",pwd);
					
					
					/* 设置时间/秒； 不设置或设置-1，浏览器关闭即销毁；0 手动销毁Cookie */
					cookie1.setMaxAge(3600*24);
					cookie2.setMaxAge(3);
					
					response.addCookie(cookie1);
					response.addCookie(cookie2);
				}
				out.print("<script>alert('登陆成功');location.href='index.jsp';</script>");
				//request.getRequestDispatcher("game.jsp").forward(request, response);		
			}else{
			out.print("<script>alert('登陆失败');location.href='register.jsp';</script>");
			//request.getRequestDispatcher("register.jsp").forward(request, response);		
			}
			
			/* if(name.equals(sname)&&pwd.equals(spwd)){
				out.print("<script>alert('登陆成功！');location.href='game.jsp';</script>");
			}else{
				out.print("<script>alert('密码或用户名错误！');location.href='index.jsp';</script>");
			} */
			
			
			/*
			User u=new User(name,pwd);	
			List<User> list=new ArrayList<User>();
			list.add(new User("zhangsan","z123456"));
			list.add(new User("lishiming","l123456"));
			list.add(new User("wangerxiao","w123456"));
			
			for(User t:list){
				if(t.getUname().equals(name)&&t.getPwd().equals(pwd)){
				request.setAttribute("u", u);
				request.setAttribute("where", "game");
				request.getRequestDispatcher("success.jsp").forward(request,
				response);
				return;
				}
			}
			
			request.setAttribute("msg", "账号或密码错误");
			request.getRequestDispatcher("index.jsp").forward(request,
				response);
				*/
	%>
   
  </body>
</html>
