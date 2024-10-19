<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login PoliBus</title>
</head>
<body>
<h2>Login PoliBus</h2>

<form action="${pageContext.request.contextPath}/GestionServlet?action=validarUsuario" method="post">
    <label for="username">Usuario:</label>
    <input type="text" id="username" name="username" required><br><br>

    <label for="password">Contraseña:</label>
    <input type="password" id="password" name="password" required><br><br>

    <input type="submit" value="Iniciar Sesión">
</form>

</body>
</html>
