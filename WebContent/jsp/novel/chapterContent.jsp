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
    overflow: auto; overflow-x:hidden;
	background: #F5F5F5;
	width: 1200px;
	font-size: 14px;
	overflow-x: hidden;
    overflow-y: auto;
}

#chapterContent{
  background:#F9E9C5;
  padding-top: 30px;
  padding-left: 10px;
  padding-right: 10px;
  padding-bottom:30px;
}
.ali{
    width:250px;
    font-size: 16px;
    font-weight: 600; 
	padding-left: 130px;
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
		<li class="active"><a href="../novel/getNovelChapter?novelId=${chapter.novelId}">${novel.title}</a> >> ${chapter.title}</li>
	</ul>
	<div style="padding-left: 20px"><h4>${chapter.title}</h4></div>
	<div id="chapterContent">
		${chapter.content}
	</div>
	<ul class="breadcrumb" style="margin-top: 20px;">
		<c:if test="${chapter.lastChapterId ne null and chapter.lastChapterId ne ''}">
			<li class="ali"><a href="../novel/getChapterContent?chapterId=${chapter.lastChapterId}">上一章<a></a></li>
		</c:if>
		<li class="ali"><a href="../novel/getNovelChapter?novelId=${chapter.novelId}">返回章节列表</a></li>
		<c:if test="${chapter.nextChapterId ne null and chapter.nextChapterId ne ''}">
			<li class="ali"><a href="../novel/getChapterContent?chapterId=${chapter.nextChapterId}">下一章</a></li>
		</c:if>
		
	</ul>
</body>
</html>