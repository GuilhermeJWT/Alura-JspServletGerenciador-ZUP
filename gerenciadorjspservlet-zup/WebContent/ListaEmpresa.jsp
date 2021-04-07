<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="br.com.zup.model.ModelEmpresa"%>

<c:url value="/empresaServlet" var="linkRemover"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listas de Empresas</title>
</head>
<body>

	<c:if test="${not empty empresa}">
		Empresa: ${empresa} cadastrada com Sucesso
	</c:if>
	
	<c:if test="${empty empresa}">
		Nenhuma Empresa Cadastrada
	</c:if>

	<h2>Lista de Empresas</h2>
	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li>${empresa.nome } - <fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/>
			 <a href="/gerenciadorjspservlet-zup/removeEmpresa?id=${empresa.id}">Remover</a>
			</li>
		</c:forEach>
	</ul>
		
</body>
</html>