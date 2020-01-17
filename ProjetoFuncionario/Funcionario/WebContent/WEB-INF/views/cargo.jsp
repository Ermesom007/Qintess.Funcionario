<%@ taglib prefix= "spring" uri= "http://www.springframework.org/tags" %>
<%@ taglib prefix= "form" uri= "http://www.springframework.org/tags/form" %>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>        


<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">
<title>Cadastro de cargos</title>

<spring:url value="/cargo/salva/" var= "salva"></spring:url>
<spring:url value="/cargo/altera/" var= "altera"></spring:url>
<spring:url value="/cargo/deleta/" var= "deleta"></spring:url>
	
</head>
<body>
<%@include file="../jsp/head.jsp" %>
<%@include file="../jsp/menu.jsp" %>
	<div class="container">
		
		<h1>Cargos</h1>
		
		<h3>Cadastre um cargo</h3>
		
		<form:form action="${salva}" modelAttribute="cargo">
			<form:hidden path="id"/>
			
			<label for="cargo">Cargo</label><br>
			<form:input path="cargo" id="cargo"/>
			
			<br>
			
			<input type="submit" value="${cargo.id == 0 ? 'Cadastrar' : 'Alterar' }" />
			
			<c:if test="${cargo.id ne 0 }">
				<input type="submit" name="cancela" value="Cancelar"/>
			</c:if>
		
		</form:form>
		
		<hr>
		
		<c:if test="${not empty cargos}">
			<table border="1">
				<tr>
					<th>Codigo</th>
					<th>Cargo</th>
					<th colspan="2">Ações</th>
				</tr>
				<c:forEach var="cargo" items="${cargos }">
				<tr>
					<td>${cargo.id}</td>
					<td>${cargo.cargo}</td>
					<td><a href="${altera }${cargo.id }">Alterar</a></td>
					<td><a href="${deleta }${cargo.id }">Deletar</a></td>
				</tr>
				</c:forEach>	
			</table>
		</c:if>
	</div>

</body>
</html>