<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h3 style="color:red">${errorMag}</h3>
<h3><a href="${pageContext.request.contextPath}/drivers/add">Register</a></h3><br>
<form method="post" action="${pageContext.request.contextPath}/login">
    Login <input name="login" type="text">
    Password <input name="password" type="password">
    <button type="submit">Login</button>
</form>
</body>
</html>
