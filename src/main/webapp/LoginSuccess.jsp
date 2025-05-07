<%--
  Created by IntelliJ IDEA.
  User: Aman
  Date: 23-05-2025
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Login Success Page</title>
</head>
<body>
<a href="login.html"></a>
<h3>Hi <%= request.getAttribute("user")%>, Login Successful.</h3>
</body>
</html>
