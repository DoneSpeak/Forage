<%@ page import="cn.forage.model.Student" %><%--
  Created by IntelliJ IDEA.
  User: DoneSpeak
  Date: 2017/5/17
  Time: 1:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Student str = (Student)request.getAttribute("student");
    %>
    <%= str.getName() %>
</body>
</html>
