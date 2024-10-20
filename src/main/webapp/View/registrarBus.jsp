<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Registrar Bus</title>
</head>
<body>
<h1>Registrar Bus</h1>

<form action="${pageContext.request.contextPath}/GestionServlet?action=guardarBus" method="post">
    <input type="hidden" name="action" value="registrarBus" />

    <label for="busId">Número de Bus:</label><br/>
    <input type="text" id="busId" name="busId" required/><br/><br/>

    <label for="capacidad">Capacidad:</label><br/>
    <input type="number" id="capacidad" name="capacidad" required/><br/><br/>

    <label for="conductor">Conductor:</label><br/>
    <select id="conductor" name="conductorId" required>
        <option value="">Selecciona un conductor</option>
        <c:forEach var="conductor" items="${conductores}">
            <option value="${conductor.id}">${conductor.nombre} ${conductor.apellido}</option>
        </c:forEach>
    </select><br/><br/>

    <input type="submit" value="Registrar Bus" />
</form>

<a href="${pageContext.request.contextPath}/GestionServlet?action=gestionBuses">Volver a la lista de buses</a>

</body>
</html>
