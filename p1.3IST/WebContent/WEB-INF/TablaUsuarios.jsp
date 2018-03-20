<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Presentación de usuarios</title>
<style> table, tr, td, th {border: 1px solid brown;} </style>
</head>
<body>
<table>
<tr style="background:#BDBDBD">
<th> Apellidos </th>
<th> Nombre </th>
<th> email </th>
</tr>
<c:forEach items="${profesores}" var="prof" varStatus="estado">
<c:if test="${estado.count%2 == 0}">
<tr style="background:#81BEF7">
</c:if>
<c:if test="${estado.count%2 != 0}">
<tr style="background:#01A9DB">
</c:if>
<td><c:out value="${prof.apellidos}" /></td>
<td><c:out value="${prof.nombre}" /></td>
<td><c:out value="${prof.email}" /></td>
</tr>
</c:forEach> </table>
<br>Lista de correos:<br>
<c:forEach items="${profesores}" var="prof" varStatus="estado">
<c:out value="${prof.email}"/><c:if test="${!estado.last}">,</c:if></c:forEach>
<br>

</body>
</html>