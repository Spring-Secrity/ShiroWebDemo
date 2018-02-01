<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shiro Web演示-用户登录</title>
</head>
<body>
	<div>
		<h1>用户登录</h1>
		
		<form action="<%=request.getContextPath()%>/user?action=login" method="post">
			用户名：<input type="text" name="name"> <br />
			密码：<input type="password" name="password"> <br />
			<input type="submit" value="登录"> <br />
		</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>