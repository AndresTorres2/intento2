<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Crear Viaje</title>
</head>
<body>
<h1>Crear Viaje</h1>
<form action="${pageContext.request.contextPath}/GestionServlet?action=guardarViaje" method="post">
    <label for="rutaId">Ruta:</label>
    <select id="rutaId" name="rutaId" required>
        <c:forEach var="ruta" items="${rutas}">
            <option value="${ruta.id}">${ruta.origen} - ${ruta.destino}</option>
        </c:forEach>
    </select><br/><br/>

    <label for="fecha">Fecha:</label>
    <input type="date" id="fecha" name="fecha" required /><br/><br/>

    <label for="horaDeSalida">Hora de Salida:</label>
    <input type="time" id="horaDeSalida" name="horaDeSalida" required /><br/><br/>

    <input type="submit" value="Crear Viaje" />
</form>
</body>
</html>
