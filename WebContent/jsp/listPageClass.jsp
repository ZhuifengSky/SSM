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
		<input id="pageNo" name="pageNo" type="hidden"  value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}" />
		
	<input type="submit" value="查找">
</form>
<table border="1px">
<thead>
  <tr>
	<td>班级</td>
	<td>描述</td> 
  </tr>
</thead>
<c:forEach items="${page.list}" var="c">   
		<tr>
			<td>${c.name}</td>
			<td>${c.remark}</td>
		</tr>
</c:forEach>
<tr><td colspan="2"><div class="pagination">${page}</div></td></tr>

</table> 
</body>
</html>