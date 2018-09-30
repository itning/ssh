<%--
  Created by IntelliJ IDEA.
  User: 舒露
  Date: 2018/9/29
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    application.setAttribute("basePath", basePath);
%>
<c:forEach items="${requestScope.get('homeWorkList')}" var="homeWork">
    <tr>
        <td>${homeWork.user.userId}</td>
        <td>${homeWork.idExt}</td>
        <td>
            <button class="btn btn-default" onclick="homeWokeDelete('${homeWork.idExt}')">删除</button>
        </td>
        <td>
            <button class="btn btn-default" onclick="homeWorkDown('${homeWork.idExt}')">下载</button>
        </td>
    </tr>
</c:forEach>
