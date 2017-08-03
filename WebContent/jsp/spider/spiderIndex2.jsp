<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>    --%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爬虫首页</title>
</head>
<body>
   <form action="/ssm/spider/getContentBySoup" method="post">
      <table>
          <thead>
              <tr><td colspan="2" align="center"><h3>抓取首页</h3></td></tr>
          </thead>
          <tbody>
              <tr>
                  <th align="right">目标url:</th>
                  <td><input type="text" name="targetUrl"></td>
              </tr>
          	  <tr>
          	  	  <th align="right">目标抓取路径:</th>
                  <td><input type="text" name="targetPath"></td>
          	  </tr>
          	  <tr>
          	  	  <th align="right">目标编码方式:</th>
                  <td><select name="encodingType">
                        <option value="">请选择</option>
                        <option value="gbk">gbk</option>
                        <option value="gb2312">gb2312</option>
                        <option value="utf-8">utf-8</option>
                     </select></td>
          	  </tr>
          </tbody>
          <tfoot>
              <tr>
                  <td colspan="2" align="center"><input type="submit" value="开始抓取"></td>
          	  </tr>
          </tfoot>
      </table>
   
   </form>
</body>
</html>