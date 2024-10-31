<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Pasajeros</title>
    <style>
        body {
            background: #100f0f;
            color: #dcdcdc;
            font-family: Arial, sans-serif;
        }

        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        h1 {
            margin-bottom: 20px;
        }

        .pasajero {
            background-color: #1c1c1c;
            padding: 20px;
            border: 1px solid #dcdcdc;
            margin-bottom: 15px;
            width: 80%;
        }

        a {
            text-decoration: none;
            color: #dcdcdc;
        }

        .back-link {
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Lista de Pasajeros para el Viaje #${viaje.id}</h1>

    <c:if test="${not empty pasajeros}">
        <c:forEach var="pasajero" items="${pasajeros}">
            <div class="pasajero">
                <p><strong>Nombre:</strong> ${pasajero.nombre} ${pasajero.apellido}</p>
                <p><strong>ID de Estudiante:</strong> ${pasajero.id}</p>
                <p><strong>Correo:</strong> ${pasajero.correo}</p>
            </div>
        </c:forEach>
    </c:if>

    <c:if test="${empty pasajeros}">
        <p>No hay pasajeros registrados para este viaje.</p>
    </c:if>

    <div class="back-link">
        <a href="${pageContext.request.contextPath}/ViajeServlet?ruta=verDetalles&ids=${viaje.id}">Volver a Detalles del Viaje</a>
    </div>
</div>
</body>
</html>
