<%-- 
    Document   : update_question
    Created on : Jun 23, 2021, 5:09:44 PM
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <%@include file="header_admin.jsp"%>
            <h2>Update question</h2>
            <main>
                <form action="/nVExamWebApp/ControlQuestion?command=update_ques" method="POST" class="common-form">
                    <input type="hidden" value="${the_question.getId()}" name="ques_ID">
                    <table>
                        <tr>
                            <td>Description:</td>
                            <td><textarea name="ques_des">${the_question.getQuesDes()}</textarea></td>
                        </tr>
                        <tr>
                            <td>1st Answer:</td>
                            <td><textarea name="opt1">${the_question.getOpt1()}</textarea></td>
                        </tr>
                        <tr>
                            <td>2nd Answer:</td>
                            <td><textarea name="opt2">${the_question.getOpt2()}</textarea></td>
                        </tr>
                        <tr>
                            <td>3rd Answer:</td>
                            <td><textarea name="opt3">${the_question.getOpt3()}</textarea></td>
                        </tr>
                        <tr>
                            <td>4th Answer:</td>
                            <td><textarea name="opt4">${the_question.getOpt4()}</textarea></td>
                        </tr>
                        <tr>
                            <td>5th Answer:</td>
                            <td><textarea name="opt5">${the_question.getOpt5()}</textarea></td>
                        </tr>
                        <tr>
                            <td>6th Answer:</td>
                            <td><textarea name="opt6">${the_question.getOpt6()}</textarea></td>
                        </tr>
                        <tr>
                            <td>Correct Answer</td>
                            <td>
                                <!--Get the array of correct answers-->
                                <c:set var="correctAnsArr" value="${the_question.getCorrectAnsArr()}"/>

                                <!--Iterate i from 1 -> 6 to check-->
                                <c:forEach var = "i" begin = "1" end = "6">
                                    <!--isNotAnswer is the checker for if i is one of the correct answer-->
                                    <c:set var="isNotAnswer" value="true"/>

                                    <!--Check if i is one of the correct answers-->
                                    <!--If it is, print out a checked checkbox, and set isNotAnswer to false-->
                                    <c:forEach var="ans" items="${correctAnsArr}">
                                        <c:if  test = "${ans == i}">
                                            <c:set var="isNotAnswer" value="false"/>
                                            Option ${i}
                                            <input type="checkbox" name="correct-ans" value="${i}" checked>
                                            &nbsp;
                                        </c:if>
                                    </c:forEach>

                                    <!--if isNotAnswer is still equal to "true"-->
                                    <!--print out a regular unchecked checkbox-->
                                    <c:if test="${isNotAnswer == true}">
                                        Option ${i}
                                        <input type="checkbox" name="correct-ans" value="${i}">
                                        &nbsp;
                                    </c:if>
                                </c:forEach>
                            </td>
                        </tr>
                        <tr>
                            <td>Category</td>
                            <td>
                                <select name="category">
                                    <c:set var="catId" value="${the_question.getCatID()}"/>
                                    <c:forEach var="cat" items="${cat_list}">
                                        <c:choose>
                                            <c:when  test = "${catId == cat.id}">
                                                <option value="${cat.id}" selected>${cat.title}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${cat.id}">${cat.title}</option>
                                            </c:otherwise>
                                        </c:choose>
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
                                <button type="submit">Update question</button>
                            </td>
                        </tr>
                    </table>
                </form>
            </main>
        </div>
    </body>
</html>
