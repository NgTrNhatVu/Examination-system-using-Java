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
        <title>NV Exam - New question</title>
        <style><%@include file="/WEB-INF/resource/css/admin/admin.css" %></style>
    </head>
    <body>
        <%@include file="header_admin.jsp"%>
        <div class="container">
            <h2>New Question</h2>
            <main>
                <form action="/nVExamWebApp/ControlQuestion?command=add_question" method="POST" class="common-form">
                    <table>
                        <tr>
                            <td>Description:</td>
                            <td><textarea name="ques_des"></textarea></td>
                            <td>Correct Answer</td>
                        </tr>
                        <tr>
                            <td>1st Answer:</td>
                            <td><input type="text" name="opt1"></td>
                            <td>
                                <input type="checkbox" name="correct-ans" value="1">
                            </td>
                        </tr>
                        <tr>
                            <td>2nd Answer:</td>
                            <td><input type="text" name="opt2"></td>
                            <td>
                                <input type="checkbox" name="correct-ans" value="2">
                            </td>
                        </tr>
                        <tr>
                            <td>3rd Answer:</td>
                            <td><input type="text" name="opt3"></td>
                            <td>
                                <input type="checkbox" name="correct-ans" value="3">
                            </td>
                        </tr>
                        <tr>
                            <td>4th Answer:</td>
                            <td><input type="text" name="opt4"></td>
                            <td>
                                <input type="checkbox" name="correct-ans" value="4">
                            </td>
                        </tr>
                        <tr>
                            <td>5th Answer:</td>
                            <td><input type="text" name="opt5"></td>
                            <td>
                                <input type="checkbox" name="correct-ans" value="5">
                            </td>
                        </tr>
                        <tr>
                            <td>6th Answer:</td>
                            <td><input type="text" name="opt6"></td>
                            <td>
                                <input type="checkbox" name="correct-ans" value="6">
                            </td>
                        </tr>
                        <tr>
                            <td>Category</td>
                            <td>
                                <select name="category">
                                    <c:forEach var="cat" items="${cat_list}">
                                        <option value="${cat.id}">${cat.title}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Status:</td>
                            <td>
                                <select name="status">
                                    <option value="1">Showed</option>
                                    <option value="0">Hidden</option>
                                </select>
                            </td>
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
