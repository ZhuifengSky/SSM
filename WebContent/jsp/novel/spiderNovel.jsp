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
<title>小说抓取</title>
<link href="../static/styles/ssm.min.css" rel="stylesheet" type="text/css" />
<link id="remove-bt-css1" href="../static/js/bootstrap/2.3.1/css_flat/bootstrap.min.css" type="text/css" rel="stylesheet" />
<script src="../static/js/jquery-3.2.1.min.js" type="text/javascript"
	language="javascript"></script>
<script src="../static/js/bootstrap/2.3.1/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
   <ul class="breadcrumb">
      	<li><i class="icon-map-marker"></i>当前位置：</li>
		<li>小说抓取</li>		
	</ul><br/>
   <form action="../novel/spiderNovel" method="post" class="form-horizontal">
      <div class="control-group">
			<label class="control-label">主域名:</label>
			<div class="controls">
				<input type="text" name="baseUrl" htmlEscape="false" maxlength="100" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
	  </div>
	  <div class="control-group">
			<label class="control-label">目标Url:</label>
			<div class="controls">
				<input type="text" name="targetUrl" htmlEscape="false" maxlength="500" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
	  </div>
	  <div class="control-group">
			<label class="control-label">目标Path:</label>
			<div class="controls">
				<input type="text" name="targetPath" htmlEscape="false" maxlength="100" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
	  </div>
	  <div class="control-group">
			<hr>
			<label class="control-label">标题Path:</label>
			<div class="controls">
				<input type="text" name="title" htmlEscape="false" maxlength="100" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
	  </div>
	  <div class="control-group">
			<label class="control-label">类别Path:</label>
			<div class="controls">
				<input type="text" name="type" htmlEscape="false" maxlength="100" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
	  </div>
	  <div class="control-group">
			<label class="control-label">状态Path:</label>
			<div class="controls">
				<input type="text" name="status" htmlEscape="false" maxlength="100" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
	  </div>
	  <div class="control-group">
			<label class="control-label">作者Path:</label>
			<div class="controls">
				<input type="text" name="author" htmlEscape="false" maxlength="100" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
	  </div>
	  <div class="control-group">
			<label class="control-label">封面Path:</label>
			<div class="controls">
				<input type="text" name="coverImage" htmlEscape="false" maxlength="100" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
      </div>
	  <div class="control-group">
			<label class="control-label">简单描述Path:</label>
			<div class="controls">
				<input type="text" name="description" htmlEscape="false" maxlength="100" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
	  </div>
	  <div class="control-group">
			<hr>
			<label class="control-label">详情页UrlPath:</label>
			<div class="controls">
				<input type="text" name="detailUrl" htmlEscape="false" maxlength="100" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
	  </div>
	  <div class="control-group">
			<label class="control-label">章节Path:</label>
			<div class="controls">
				<input type="text" name="chapterPath" htmlEscape="false" maxlength="100" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
	  </div>
	  <div class="control-group">
			<hr>
			<label class="control-label">章节标题Path:</label>
			<div class="controls">
				<input type="text" name="chapterTitle" htmlEscape="false" maxlength="100" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
	  </div>
	  <div class="control-group">
			<label class="control-label">章节简述Path:</label>
			<div class="controls">
				<input type="text" name="chapterDesc" htmlEscape="false" maxlength="100" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
	  </div>
	  <div class="control-group">
			<hr>
			<label class="control-label">正文URlPath:</label>
			<div class="controls">
				<input type="text" name="contentUrl" htmlEscape="false" maxlength="100" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
	  </div>
	  <div class="control-group">
			<label class="control-label">正文Path:</label>
			<div class="controls">
				<input type="text" name="contentPath" htmlEscape="false" maxlength="100" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
	  </div>
	  <div class="control-group">
			<label class="control-label">编码方式:</label>
			<div class="controls">
				<select name="encodingType" class="required" cssStyle="width:220px;">
					    <option value="">请选择</option>
                        <option value="gbk">gbk</option>
                        <option value="gb2312">gb2312</option>
                        <option value="utf-8">utf-8</option> 
				</select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
	  </div>
      <div class="form-actions">
	        <input id="btnSubmit" class="btn btn-primary" type="submit" value="开始抓取"/>
      </div>
   </form>
</body>
</html>