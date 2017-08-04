<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h3>小说列表</h3>
   <table border="1px">
      <tr>
         <th>封面</th>
         <th>标题</th>
         <th>类别</th>
         <th>状态</th>
         <th>作者</th>
         <th>描述</th>
         <th>添加时间</th>
      </tr>
   	  <c:forEach var="novel" items="${novels}">
   	      <tr>
   	          <td><img alt="封面" src="${novel.coverImage}"></td>
   	          <td>${novel.title}</td>
   	          <td>${novel.type}</td>
   	          <td>${novel.status}</td>
   	          <td>${novel.author}</td>
   	          <td>${novel.description}</td>
   	          <td><fmt:formatDate value="${novel.createDate}"
							pattern="yyyy-MM-dd hh:mm:ss" /></td>
   	      </tr>
   	  </c:forEach>	
   
   </table>
</body>
</html>