<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- http://localhost/webPro/html/days06/ex01_ok.jsp?name=hong&age=20 -->


<h3>ex01_ok.jsp</h3>
<%
  //[스크립트릿] 자바코딩
  
  String name = request.getParameter("name");
  int age = Integer.parseInt(request.getParameter("age"));
  
%>
<!-- 표현식 -->

이름:<%=name%><br>
나이:<%=age %><br>

</body>
</html>