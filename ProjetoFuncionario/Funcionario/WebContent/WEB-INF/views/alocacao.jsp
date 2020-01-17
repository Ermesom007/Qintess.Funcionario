<%@ taglib prefix= "spring" uri= "http://www.springframework.org/tags" %>
<%@ taglib prefix= "form" uri= "http://www.springframework.org/tags/form" %>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>        



<!DOCTYPE html>
<html>
<head>


<spring:url value="/alocacao/salva/" var= "salva"></spring:url>
<spring:url value="/alocacao/altera/" var= "altera"></spring:url>
<spring:url value="/alocacao/deleta/" var= "deleta"></spring:url>


<%@include file="../jsp/head.jsp" %>

<meta charset="UTF-8">
<title>Controle de Clientes</title>
</head>
<body>
<%@include file="../jsp/menu.jsp" %>
	<div class="container">
		
		<h1>Clientes</h1>
		
		<h3>Cadastre um cliente</h3>
		
		<form:form action="${salva}" modelAttribute="alocacao">
			<form:hidden path="id"/>
			
			<label for="cliente">Cliente</label>
			<form:input path="cliente" id="cliente"/>
			
			<br>
			
			<input type="submit" value="${alocacao.id == 0 ? 'Cadastrar' : 'Alterar' }" />
			
			<c:if test="${alocacao.id ne 0 }">
				<input type="submit" name="cancela" value="Cancelar"/>
			</c:if>
		
		</form:form>
		
		<hr>
		
		<c:if test="${not empty alocacoes}">
			<table border="1">
				<tr>
					<th>Codigo</th>
					<th>Cliente</th>
					<th colspan="2">Ações</th>
				</tr>
				<c:forEach var="alocacao" items="${alocacoes}">
				<tr>
					<td>${alocacao.id}</td>
					<td>${alocacao.cliente}</td>
					<td><a href="${altera }${alocacao.id }">Alterar</a></td>
					<td><a href="${deleta }${alocacao.id }">Deletar</a></td>
				</tr>
				</c:forEach>	
			</table>
		</c:if>
	</div>
	
</body>
</html>