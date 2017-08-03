<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h3>拿到内容</h3>
   <table>
      <tr>
         <th>标题</th>
         <th>url</th>
      </tr>
   	  <c:forEach var="bean" items="${beans}">
   	      <tr>
   	         <td>${bean.title}</td>
   	          <td>${bean.url}</td>
   	      </tr>
   	  </c:forEach>	
   
   </table>
</body>
</html>