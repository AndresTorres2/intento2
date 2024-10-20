<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
  <title>Gestión de Buses</title>
</head>
<body>
<h1>Gestión de Buses</h1>

<table>
  <thead>
  <tr>
    <th>Bus #</th>
    <th>Capacidad</th>
    <th>Nombre del Conductor</th>
    <th></th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="bus" items="${buses}">
    <tr>
      <td>${bus.busId}</td>
      <td>${bus.capacidad}</td>
      <td>${bus.conductor.nombre} ${bus.conductor.apellido}</td>
      <td>
        <a href="${pageContext.request.contextPath}/GestionServlet?action=eliminarBus&busId=${bus.busId}" onclick="return confirm('¿Estás seguro de que deseas eliminar este bus?');">Eliminar</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<a href="${pageContext.request.contextPath}/GestionServlet?action=nuevoBus">Agregar nuevo bus</a>
</body>
</html>
