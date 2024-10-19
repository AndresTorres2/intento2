<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Gestión de Rutas</title>
</head>
<body>
<h1>Gestión de Rutas</h1>

<table >
    <thead>
    <tr>
        <th>Origen</th>
        <th>Destino</th>
        <th>Recorrido</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="ruta" items="${rutas}">
        <tr>
            <td>${ruta.origen}</td>
            <td>${ruta.destino}</td>
            <td>
                <c:forEach var="calle" items="${ruta.calles}" varStatus="status">
                    ${calle.nombre}<c:if test="${!status.last}">, </c:if>
                </c:forEach>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/GestionServlet?action=formActualizarRuta&rutaId=${ruta.id}">Actualizar</a> |
                <a href="${pageContext.request.contextPath}/GestionServlet?action=eliminarRuta&rutaId=${ruta.id}" onclick="return confirm('¿Estás seguro de que deseas eliminar esta ruta?');">Eliminar</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="${pageContext.request.contextPath}/GestionServlet?action=nuevaRuta">Agregar nueva ruta</a>
</body>
</html>
