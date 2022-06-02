<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>ex01_02_02.jsp</h3>
<!-- http://localhost/webPro/html/days06/ex01_ok_02.jsp
?
cars=BMW
&
deptno=30 -->

<%
 String content = request.getParameter("content");
%>

하고 싶은 말:
<br>

<!-- 숨겨놓을 목적으로 사용하는 태그 hidden
  사용하는 이유?  나중에.. -->
<input type="hidden" name="content" 

  value="<%= content.replace("\r\n","<br>") %>">


</body>
</html>