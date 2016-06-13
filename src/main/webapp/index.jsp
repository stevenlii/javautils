<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Hello world
	
<!-- 
	<form action="<%=request.getContextPath()%>/spj" method="POST">
		<input type="text" name="phone">
		<a href="http://joyne.me" target="_blank">joyne</a>
		<a href="/Ztest/src/main/webapp/index.jsp" target="_blank">down</a>
		<input type="submit" value="Submit" />
	</form>
 -->
	
	<form action="<%=request.getContextPath()%>/spdown" method="POST">
		<a href="/Ztest/src/main/webapp/index.jsp" target="_blank">down</a>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>