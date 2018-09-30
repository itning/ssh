<%--
  Created by IntelliJ IDEA.
  User: 舒露
  Date: 2018/9/29
  Time: 15:25
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
<body>
<div class="page-header">
    <h1>列表展示
        <small>文件</small>
    </h1>
</div>
<nav class="navbar ">
    <div class="container-fluid">
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <select class="form-control" name="type" style="margin: 8px;width: 30%; float: right; " id="type">
                <c:forEach items="${requestScope.get('workList')}" var="workList">
                    <option value="${workList.typeId}">${workList.typeName}</option>
                </c:forEach>
            </select>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<section class="container">
    <table class="table table-hover">
        <thead>
        <tr>
            <td>文件上传者</td>
            <td>文件名</td>
            <td>操作</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody id="here"></tbody>
    </table>
    <button type="button" class="btn btn-default pull-right" onclick="homeWorkDownAll()">全部下载</button>
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
</section>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
    var typeId;
    $(function () {
        send("${basePath}AdminAction_data");
        $('#type').change(function () {
            let val = $(this).val();
            typeId=val;
            send("${basePath}AdminAction_data?id=" + val);
        })
    });

    function send(url) {
        $.get(url, function (data) {
            let $here = $('#here');
            $here.empty();
            $here.append(data);
        })
    }

    function homeWokeDelete(idExt) {
        window.location.href = "${basePath}HomeWork_delete?id=" + idExt;
    }

    function homeWorkDown(idExt) {
        window.location.href = "${basePath}HomeWork_Down?id=" + idExt;
    }

    function homeWorkDownAll() {
        window.location.href = "${basePath}HomeWork_Down_All?id=" + typeId;
    }
</script>
</body>
</html>
