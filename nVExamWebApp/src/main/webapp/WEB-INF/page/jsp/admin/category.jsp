<%-- 
    Document   : category
    Created on : Jun 21, 2021, 9:40:47 AM
    Author     : pc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style><%@include file="/WEB-INF/resource/css/admin/admin.css" %></style>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">

            <%@include file="header_admin.jsp"%>
            <h2>All category</h2>
            <div class="search-box">
                <form method="GET">
                    <input type="text" name="keyword" placeholder="keyword...">
                    <button type="submit">Search</button>
                </form>
            </div>
            <div class="add-new">
                <c:url var="addCategory" value="ControlQuestion">
                    <c:param name="command" value="add_category"/>
                </c:url>
                <button><a href="${addCategory}">New Category</a></button>
            </div>
            <main>
                <c:forEach var="category" items="${cat_list}">
                    <div class="display-box">
                        <img src="${category.img}" width="150px" heigth="150px" alt="Ảnh danh mục">
                        <h3>${category.title}</h3>
                    </div>
                </c:forEach>
            </main>
        </div>
    </body>
</html>
