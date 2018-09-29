<%--
  Created by IntelliJ IDEA.
  User: 舒露
  Date: 2018/9/28
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    application.setAttribute("basePath", basePath);
%>
<html>
<head>
    <title>错误页面</title>
</head>
<body>
哥哥，没有你要的东西~~~~~
</body>
</html>
