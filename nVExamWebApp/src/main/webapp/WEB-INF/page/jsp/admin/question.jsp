<%-- 
    Document   : question
    Created on : Jun 20, 2021, 5:54:52 PM
    Author     : pc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style><%@include file="/WEB-INF/resource/css/admin/admin.css"%></style>
        <title>NV Exam - All questions</title>
    </head>
    <body>
        <div class="container">
            <%@include file="header_admin.jsp"%>

            <h2>All question!</h2>
            <div class="search-box">
                <form method="GET">
                    <input type="text" name="keyword" placeholder="keyword...">
                    <button type="submit">Search</button>
                </form>
            </div>
            <div class="add-new">
                <c:url var="addQuestion" value="ControlQuestion">
                    <c:param name="command" value="add_question"/>
                </c:url>
                <button>
                    <a href="${addQuestion}">
                        New question
                    </a>
                </button>
            </div>
            <main>
                <table class="table" border="1">
                    <tr>
                        <th>ID</th>
                        <th>Description</th>
                        <th>Correct answer</th>
                        <th>Option 1</th>
                        <th>Option 2</th>
                        <th>Option 3</th>
                        <th>Option 4</th>
                        <th>Option 5</th>
                        <th>Option 6</th>
                        <th>Category ID</th>
                        <th>Status</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                    <c:forEach var="ques" items="${question_list}">
                        <c:url var="updateQues" value="ControlQuestion">
                            <c:param name="command" value="send_ques_to_update" />
                            <c:param name="quesId" value="${ques.getId()}"/>
                        </c:url>
                        <c:url var="deleteQues" value="ControlQuestion">
                            <c:param name="command" value="delete_ques"/>
                            <c:param name="quesId" value="${ques.getId()}"/>
                        </c:url>
                        <tr>
                            <td>${ques.getId()}</td>
                            <td>${ques.getQuesDes()}</td>
                            <td>
                                <c:forEach var="answer" items="${ques.getCorrectAnsArr()}">
                                    ${answer}
                                </c:forEach>
                            </td>
                            <td>${ques.getOpt1()}</td>
                            <td>${ques.getOpt2()}</td>
                            <td>${ques.getOpt3()}</td>
                            <td>${ques.getOpt4()}</td>
                            <td>${ques.getOpt5()}</td>
                            <td>${ques.getOpt6()}</td>
                            <td>${ques.getCatID()}</td>
                            <td>${ques.getStatus()}</td>
                            <td><a href="${updateQues}">Update</a></td>
                            <td><a href="${deleteQues}" onclick="if (!confirm('Are you sure?'))
                                        return false">
                                    Delete
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </main>
        </div>
    </body>
</html>
