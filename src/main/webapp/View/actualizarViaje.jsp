<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Actualizar Viaje</title>
</head>
<body>
<h1>Actualizar Viaje</h1>
<form action="${pageContext.request.contextPath}/GestionServlet?action=actualizarViaje" method="post">
    <input type="hidden" name="viajeId" value="${viaje.id}" />

    <label for="rutaId">Ruta:</label>
    <select id="rutaId" name="rutaId" required>
        <c:forEach var="ruta" items="${rutas}">
            <option value="${ruta.id}" <c:if test="${ruta.id == viaje.ruta.id}">selected</c:if>>${ruta.origen} - ${ruta.destino}</option>
        </c:forEach>
    </select><br/><br/>

    <label for="fecha">Fecha:</label>
    <input type="date" id="fecha" name="fecha" value="${viaje.fecha}" required /><br/><br/>

    <label for="hora">Hora:</label>
    <input type="time" id="hora" name="hora" value="${viaje.hora}" required /><br/><br/>

    <input type="submit" value="Actualizar Viaje" />
</form>
</body>
</html>
