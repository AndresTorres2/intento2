<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Gestión de Conductores</title>
</head>
<body>
<h1>Gestión de Conductores</h1>

<table>
    <thead>
    <tr>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Email</th>
        <th>Teléfono</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="conductor" items="${conductores}">
        <tr>
            <td>${conductor.nombre}</td>
            <td>${conductor.apellido}</td>
            <td>${conductor.email}</td>
            <td>${conductor.phone}</td>
            <td>
                <a href="${pageContext.request.contextPath}/GestionServlet?action=eliminarConductor&conductorId=${conductor.id}" onclick="return confirm('¿Estás seguro de que deseas eliminar este conductor?');">Eliminar</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="${pageContext.request.contextPath}/GestionServlet?action=nuevoConductor">Agregar nuevo conductor</a>
</body>
</html>
