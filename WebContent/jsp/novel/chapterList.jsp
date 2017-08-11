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
 
 body {
	background: #F5F5F5;
	width: 1200px;
	font-size: 14px;
}

#chapterList{
  background:#F9E9C5; 
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

<body style="margin: 0 auto;">
    <ul class="breadcrumb">
		<li><i class="icon-map-marker"></i>当前位置：</li>
		<li class="active"><a href="../novel/getPageNovel">首页</a> >> <a href="../novel/getNovelChapter?novelId=${novel.id}">${novel.title}</a> >> 章节列表</li>
	</ul>
	<form action="../novel/getNovelChapter" method="post" id="searchForm"
		class="breadcrumb form-search">
		<ul class="ul-form">
			<li><label>章节名称:</label> <input type="text" name="title"
				value="${chapter.title}" class="input-medium">
				<input type="hidden" name="novelId"
				value="${chapter.novelId}" class="input-medium">
				</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary"
				type="submit" value="查询" /></li>
		</ul>
	</form>
	<div id="chapterList">
		<c:forEach var="chapter" items="${chapters}" varStatus="i">
			<span style="display: block;width: 250px;margin-bottom:25px; float: left; margin-left: 50px;">
			    <a title="${chapter.description}" href="../novel/getChapterContent?chapterId=${chapter.id}">${chapter.title}</a>
		    </span>
		</c:forEach>
	</div>
</body>
</html>