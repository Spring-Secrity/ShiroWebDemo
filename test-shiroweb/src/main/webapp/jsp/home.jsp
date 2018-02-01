<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shiro Web演示-主页</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div>
		<h1>主页</h1>
		<shiro:hasRole name="admin">
			<a href="<%=request.getContextPath()%>/admin">用户管理</a>
		</shiro:hasRole>
		<br />
		<shiro:hasPermission name="winnebago:drive:eagle5">
			<a>操作审计</a>
		</shiro:hasPermission>
		<br />
	
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>