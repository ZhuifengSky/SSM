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
		<%-- <input type="hidden" name="pageSize" value="${queryBean.page.pageSize}">
		<input type="hidden" name="pageNum" value="${queryBean.page.pageNum}"> --%>
		<input type="hidden" name="pageSize" value="1">
		<input type="hidden" name="pageNum" value="1">
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
<c:forEach items="${page.list}" var="u">   
		<tr>
			<td>${u.userName}</td>
			<td>${u.sex}</td>
		</tr>
</c:forEach>
<tr><td colspan="2">当前页:${page.pageNum} 总页数:${page.pages} 总记录数:${page.total}首页${page.firstPage} 末页${page.lastPage}</td></tr>

</table> 
</body>
</html>