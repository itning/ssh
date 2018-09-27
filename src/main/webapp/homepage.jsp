<%--
  Created by IntelliJ IDEA.
  User: 舒露
  Date: 2018/9/26
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 101 Template</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container">
<script>
    function homeWokeDelete(idExt) {
        window.location.href = "/HomeWork_delete?id=" + idExt;
    }
</script>
<div class="page-header">
    <h1>列表展示
        <small>文件</small>
    </h1>
</div>
<form action="/file_updown" method="post" enctype="multipart/form-data">
    <input type="file" name="file" value="选择文件"/>
    <select class="form-control" name="type" style="width: 30%">
<c:forEach items="${requestScope.get('workList')}" var="workList">
        <option>${workList.typeName}</option>
</c:forEach>
    </select>
    <input type="submit" class="btn btn-success" value="上传">
</form>
<form class="form-inline pull-right" action="/">
    <div class="form-group">
        <label class="sr-only" for="exampleInputAmount">Amount (in dollars)</label>
        <div class="input-group">
            <input type="text" class="form-control" id="exampleInputAmount" placeholder="键入名称">
        </div>
    </div>
    <input type="submit" class="btn btn-default" value="搜索" style="width: 15%"/>
</form>
<table class="table table-hover">
    <tr>
        <td>文件上传者</td>
        <td>文件名</td>
        <td>操作</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${requestScope.get('homeWorkList')}" var="homeWork">
        <tr>
            <td>${homeWork.user.userId}</td>
            <td>${homeWork.idExt}</td>
            <td>
                <button class="btn btn-default" onclick="homeWokeDelete('${homeWork.idExt}')">删除</button>
            </td>
            <td>
                <button class="btn btn-default" onclick="">下载</button>
            </td>
        </tr>
    </c:forEach>

</table>
<button type="button" class="btn btn-success pull-right">全部下载</button>
<nav aria-label="Page navigation" class="text-center">
    <ul class="pagination">
        <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
        <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
        <li><a href="#">2</a></li>
        <li>
            <a href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
