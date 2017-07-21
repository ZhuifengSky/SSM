<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="user/searchUser.do" method="post">
	姓名：<input type="text" name="userName" value="${queryBean.userName}">
	性别：<input type="text" name="sex" value="${queryBean.sex}">
	<input type="submit" value="查找">
</form>
<table border="1px">
<thead>
  <tr>
	<td>姓名</td>
	<td>性别</td> 
  </tr>
</thead>
<c:forEach items="${users}" var="u">   
		<tr>
			<td>${u.userName}</td>
			<td>${u.sex}</td>
		</tr>
</c:forEach>
</table> 
</body>
</html>