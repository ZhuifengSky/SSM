<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<style type="text/css">
.desc {
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
	width: 300px;
}
</style>
<link href="../static/styles/ssm.min.css" rel="stylesheet"
	type="text/css" />
<link id="remove-bt-css1" href="../static/js/bootstrap/2.3.1/css_flat/bootstrap.min.css" type="text/css" rel="stylesheet" />
<script src="../static/js/jquery-3.2.1.min.js" type="text/javascript"
	language="javascript"></script>
<script src="../static/js/bootstrap/2.3.1/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript">
	function page(n, s) {
		$("#pageNo").val(n);
		$("#pageSize").val(s);
		$("#searchForm").submit();
		return false;
	}
</script>
</head>

<body>
	<form action="../novel/getPageNovel" method="post" id="searchForm"
		class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${page.pageSize}" />
		<ul class="ul-form">
			<li><label>小说标题:</label> <input type="text" name="title"
				value="${queryBean.title}" class="input-medium"></li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary"
				type="submit" value="查询" /></li>
		</ul>
	</form>
	<table class="table table-striped table-bordered table-condensed">
		<tr>
			<th>封面</th>
			<th>标题</th>
			<th>类别</th>
			<th>状态</th>
			<th>作者</th>
			<th>描述</th>
			<th>添加时间</th>
		</tr>
		<c:forEach var="novel" items="${page.list}">
			<tr>
				<td><img alt="封面" src="${novel.coverImage}"></td>
				<td><a href="../novel/getNovelChapter?novelId=${novel.id}">${novel.title}</a></td>
				<td>${novel.type}</td>
				<td>${novel.status}</td>
				<td>${novel.author}</td>
				<td><div class="desc">${novel.description}</div></td>
				<td><fmt:formatDate value="${novel.createDate}"
						pattern="yyyy-MM-dd hh:mm:ss" /></td>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination" id="pageList">${page}</div>
</body>
</html>