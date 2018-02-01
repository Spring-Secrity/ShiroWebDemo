<%@page import="org.apache.shiro.authz.AuthorizationException"%>
<%@page import="javax.naming.AuthenticationException"%>
<%@page import="org.apache.shiro.authc.ConcurrentAccessException"%>
<%@page import="org.apache.shiro.authc.IncorrectCredentialsException"%>
<%@page import="org.apache.shiro.authc.UnknownAccountException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shiro Web演示-错误</title>
</head>
<%
	StringBuilder builder = new StringBuilder();
	String name = (String)request.getAttribute("name");
	Exception ex = (Exception)request.getAttribute("ex");
	if(ex instanceof UnknownAccountException) {
		// 用户不存在
		builder.append("用户：").append(name).append(" 不存在！");
	}else if(ex instanceof IncorrectCredentialsException) {
		// 密码不正确
		builder.append("用户：").append(name).append(" 密码不正确！");
	}else if(ex instanceof ConcurrentAccessException) {
		// 用户已经登录
		builder.append("用户：").append(name).append(" 已经登录！");
	}else if(ex instanceof AuthenticationException) {
		// 用户认证异常
		builder.append("用户：").append(name).append(" 认证出错！");
	}else if(ex instanceof AuthorizationException) {
		// 访问权限错误
		builder.append(ex.getMessage());
	}else {
		// 未知异常
		builder.append("未知错误");
	}
%>
<body>
	<div>
		<h1>出错啦</h1>
		<p><%=builder.toString()%></p>
	</div>
	<div>
		<a href="<%=request.getContextPath()%>/index">重新登录</a>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>