<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
  <title>Dashboard Admin - PoliBus</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
    }
    .dashboard-container {
      width: 80%;
      margin: 0 auto;
      padding: 20px;
      background-color: white;
      box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
      border-radius: 8px;
    }
    h1 {
      text-align: center;
    }
    .menu {
      display: flex;
      justify-content: space-around;
      margin: 20px 0;
    }
    .menu-item {
      background-color: #3498db;
      padding: 20px;
      width: 20%;
      text-align: center;
      border-radius: 8px;
      color: white;
      text-decoration: none;
      font-size: 18px;
      transition: background-color 0.3s ease;
    }
    .menu-item:hover {
      background-color: #2980b9;
    }
  </style>
</head>
<body>
<div class="dashboard-container">
  <h1>Dashboard Admin - PoliBus</h1>
  <div class="menu">
    <a class="menu-item" href="">Conductores</a>
    <a class="menu-item" href="">Buses</a>
    <a class="menu-item" href="${pageContext.request.contextPath}/GestionServlet?action=gestionRutas">Rutas</a>
    <a class="menu-item" href="">Viajes</a>
  </div>
</div>
</body>
</html>
