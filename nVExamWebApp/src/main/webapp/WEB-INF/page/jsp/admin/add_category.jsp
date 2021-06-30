<%-- 
    Document   : add_question
    Created on : Jun 22, 2021, 2:34:29 PM
    Autdor     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NV Exam - New category</title>
        <style><%@include file="/WEB-INF/resource/css/admin/admin.css" %></style>
    </head>
    <body>
        <%@include file="header_admin.jsp"%>
        <div class="container">
            <h2>New Category</h2>
            <main>
                <form action="/nVExamWebApp/ControlQuestion?command=add_category" method="POST" class="common-form">
                    <table>
                        <tr>
                            <td>Title</td>
                            <td><textarea name="cat_title"></textarea></td>
                        </tr>
                        <tr>
                            <td>Category Image</td>
                            <td><input type="text" name="cat_img"></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <button type="submit">Add</button>
                            </td>
                        </tr>
                    </table>
                </form>
            </main>
        </div>
    </body>
</html>
