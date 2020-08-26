<%@ page import="entity.Question" %><%--
  Created by IntelliJ IDEA.
  User: peanut
  Date: 2020/8/11
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Question question =(Question) request.getAttribute("question");
    %>
    <center>
        <form action="/myWeb/question/update" method="get">
            <table border="2">
                <tr>
                    <td>题目编号：</td>
                    <td><input type="text" name="questionId" value="${requestScope.question.questionId}" readonly></td>
                </tr>
                <tr>
                    <td>题目：</td>
                    <td><input type="text" name="title" value="${requestScope.question.title}"></td>
                </tr>
                <tr>
                    <td>A：</td>
                    <td><input type="text" name="optionA" value="${requestScope.question.optionA}"></td>
                </tr>
                <tr>
                    <td>B：</td>
                    <td><input type="text" name="optionB" value="${requestScope.question.optionB}"></td>
                </tr>
                <tr>
                    <td>C：</td>
                    <td><input type="text" name="optionC" value="${requestScope.question.optionC}"></td>
                </tr>
                <tr>
                    <td>D：</td>
                    <td><input type="text" name="optionD" value="${requestScope.question.optionD}"></td>
                </tr>
                <tr>
                    <td>正确答案：</td>
                    <td>
                        <input type="radio" name="answer" value="A" ${"A" == question.answer?"checked":""}>A
                        <input type="radio" name="answer" value="B" ${"B" == question.answer?"checked":""}>B
                        <input type="radio" name="answer" value="C" ${"C" == question.answer?"checked":""}>C
                        <input type="radio" name="answer" value="D" ${"D" == question.answer?"checked":""}>D
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="更新试题"></td>
                    <td><input type="reset" value="重置"></td>
                </tr>
            </table>
        </form>
    </center>

</body>
</html>
