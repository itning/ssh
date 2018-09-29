<%--
  Created by IntelliJ IDEA.
  User: 舒露
  Date: 2018/9/28
  Time: 14:29
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
    <title>Title</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 101 Template</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>

<html>
<head>
    <title>登陆</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<header class="page-header text-center">
    <h1>用户登录页面</h1>
</header>
<form action="${basePath}userAction" method="post">
    <div class="container center-block">
        <div class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label">用&nbsp;户&nbsp;名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="userId" placeholder="请输入用户名">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" name="userPwd" placeholder="请输入密码">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-1 control-label"></div>
                <div class="col-sm-11">
                    <button type="submit" class="btn btn-primary btn-lg btn-block">登录</button>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
