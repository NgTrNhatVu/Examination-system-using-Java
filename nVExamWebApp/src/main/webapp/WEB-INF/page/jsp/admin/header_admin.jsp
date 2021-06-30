<%-- 
    Document   : header
    Created on : Jun 21, 2021, 6:11:11 PM
    Author     : pc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style><%@include file="/WEB-INF/resource/css/admin/admin.css"%></style>
    </head>
    <body>
        <header>
            <div class="top-header">
                <div class="logo">
                    <img/>
                </div>
                <div class="banner">
                    <h1>NV Exam </h1>
                </div>
                <div class="account">

                </div>
            </div>
            <nav>
                <c:url var="questions" value="ControlQuestion">
                    <c:param name="command" value="all_question" />
                </c:url>
                <c:url var="categories" value="ControlQuestion">
                    <c:param name="command" value="all_category" />
                </c:url>
                <a href="${questions}">Questions</a>
                <a href="${categories}">Categories</a>
            </nav>
        </header>

    </body>
</html>
