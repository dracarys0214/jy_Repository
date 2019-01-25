<%@ page language="java"
	import="java.util.*,com.bdqn.zmj.jdbc.dao.*,com.bdqn.zmj.jdbc.entity.*"
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

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" href="layui-v2.4.5/layui/css/layui.css">
<script src="layui-v2.4.5/layui/layui.js"></script>
<style>
th, td {
	text-align: center !important;
	width: 100px;
}

body>div {
	width: 1000px;
	margin:0 auto;
}

legend {
	text-align: center;
}
</style>
</head>

<body>
	<%
		EmployeeDao dao=new EmployeeDao();
		//Employee无参，获得所有数据
		List<Employee>list =dao.getList(new Employee());
	%>
	<div>

		<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 20px;">
			<legend>公司信息表</legend>
		</fieldset>

		<div class="layui-form">
			<table class="layui-table">
				<colgroup>
					<col width="100">
					<col width="100">
					<col width="100">
					<col width="100">
					<col width="100">
				</colgroup>
				<button class="layui-btn layui-btn-warm">
					<a href="add.jsp">添加</a>
				</button>
				<thead>
					<tr>
						<th>编号</th>
						<th>姓名</th>
						<th>年龄</th>
						<th>部门</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (int i = 0; i < list.size(); i++) {
					%>
					<tr>
						<td><%=list.get(i).getEid()%></td>
						<td><%=list.get(i).getEname()%></td>
						<td><%=list.get(i).getAge()%></td>
						<td><%=list.get(i).getDept().getDname()%></td>
						<td>
							<button class="layui-btn layui-btn-normal layui-btn-xs">
								<i class="layui-icon"><a
									href="update.jsp?eid=<%=list.get(i).getEid()%>">修改</a></i>
							</button>
							<button class="layui-btn layui-btn-danger layui-btn-xs">
								<i class="layui-icon"><a href="javascript:void(0)"
									eid=<%=list.get(i).getEid()%> onclick="del(this)">删除</a></i>
							</button>
						</td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>

	<script>
		function del(obj) {
			if (confirm("确认删除？")) {
				var eid = obj.getAttribute("eid");
				location.href = "doPage/doDel.jsp?eid=" + eid;
			}
		}
	</script>
</body>
</html>

