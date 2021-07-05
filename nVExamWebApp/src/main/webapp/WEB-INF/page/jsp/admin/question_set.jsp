<%-- 
    Document   : question_set
    Created on : Jul 2, 2021, 11:05:47 AM
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
                <c:forEach var="ques_set" items="${ques_set_list}">
                    <div class="display-box">
                        <img src="${ques_set.getImage()}" width="150px" heigth="150px" alt="Set's banner"/>
                        <h3>${ques_set.title}</h3>
                        <p>${ques_set.date}</p>
                    </div>
                </c:forEach>
            </main>
        </div>
    </body>
</html>
