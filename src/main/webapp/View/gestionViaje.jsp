<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Lista de Viajes</title>
</head>
<body>
<h1>Lista de Viajes</h1>
<table border="1">
  <tr>
    <th>ID</th>
    <th>Bus</th>
    <th>Fecha</th>
    <th>Hora de Salida</th>
    <th>Ruta</th>
    <th>Jornada</th>
    <th>Asientos Ocupados</th>
  </tr>
  <c:forEach var="viaje" items="${viajes}">
    <tr>
      <td>${viaje.id}</td>
      <td>${viaje.bus.busId}</td>
      <td>${viaje.fecha}</td>
      <td>${viaje.horaDeSalida}</td>
      <td>${viaje.ruta.RutaId}</td>
      <td>${viaje.jornada}</td>
      <td>${viaje.asientosOcupados}</td>
    </tr>
  </c:forEach>

</table>
</body>
</html>