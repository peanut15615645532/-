<%--
  Created by IntelliJ IDEA.
  User: peanut
  Date: 2020/8/11
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>
        <font style="color: red;font-size: 40px">
            <%=(String)request.getAttribute("info")%>
        </font>
    </center>
</body>
</html>
