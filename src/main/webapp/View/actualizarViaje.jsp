<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Actualizar Viaje</title>
</head>
<body>
<h1>Actualizar Viaje</h1>

<form action="${pageContext.request.contextPath}/GestionServlet?action=actualizarViaje" method="post">
    <input type="hidden" name="viajeId" value="${viaje.id}" />

    <label for="busId">Bus:</label>
    <select name="busId" id="busId">
        <c:forEach var="bus" items="${buses}">
            <option value="${bus.busId}" ${bus.busId == viaje.bus.busId ? 'selected' : ''}>
                    ${bus.busId}
            </option>
        </c:forEach>
    </select><br/>

    <label for="rutaId">Ruta:</label>
    <select name="rutaId" id="rutaId">
        <c:forEach var="ruta" items="${rutas}">
            <option value="${ruta.id}" ${ruta.id == viaje.ruta.id ? 'selected' : ''}>
                    ${ruta.origen} - ${ruta.destino}
            </option>
        </c:forEach>
    </select><br/>

    <label for="fecha">Fecha:</label>
    <input type="date" name="fecha" id="fecha" value="${viaje.fecha}" required /><br/>

    <label for="horaDeSalida">Hora de Salida:</label>
    <input type="time" name="horaDeSalida" id="horaDeSalida" value="${viaje.horaDeSalida}" required /><br/>

    <label for="jornada">Jornada:</label>
    <input type="text" name="jornada" id="jornada" value="${viaje.jornada}" required /><br/>

    <input type="submit" value="Actualizar Viaje" />
</form>

<a href="${pageContext.request.contextPath}/View/gestionViaje.jsp">Volver a la lista de viajes</a>

</body>
</html>
