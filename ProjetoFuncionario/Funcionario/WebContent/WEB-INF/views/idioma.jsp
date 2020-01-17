<%@ taglib prefix= "spring" uri= "http://www.springframework.org/tags" %>
<%@ taglib prefix= "form" uri= "http://www.springframework.org/tags/form" %>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>        


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<spring:url value="/idioma/salva/" var= "salva"></spring:url>
<spring:url value="/idioma/altera/" var= "altera"></spring:url>
<spring:url value="/idioma/deleta/" var= "deleta"></spring:url>
	
	

<title>Cadastro de Idiomas</title>
</head>
<body>
<%@include file="../jsp/head.jsp" %>
<%@include file="../jsp/menu.jsp" %>
	<div class="container">
		
		<h1>Idiomas</h1>
		
		<h3>Cadastre um idioma</h3>
		
		<form:form action="${salva}" modelAttribute="idioma">
			<form:hidden path="id"/>
			
			<label for="idioma">Idioma</label><br>
			<form:input path="idioma" id="idioma"/>
			
			<br>
			
			<input type="submit" value="${idioma.id == 0 ? 'Cadastrar' : 'Alterar' }" />
			
			<c:if test="${idioma.id ne 0 }">
				<input type="submit" name="cancela" value="Cancelar"/>
			</c:if>
		
		</form:form>
		
		<hr>
		
		<c:if test="${not empty idiomas}">
			<table border="1">
				<tr>
					<th>Codigo</th>
					<th>Cargo</th>
					<th colspan="2">Ações</th>
				</tr>
				<c:forEach var="idioma" items="${idiomas }">
				<tr>
					<td>${idioma.id}</td>
					<td>${idioma.idioma}</td>
					<td><a href="${altera }${idioma.id }">Alterar</a></td>
					<td><a href="${deleta }${idioma.id }">Deletar</a></td>
				</tr>
				</c:forEach>	
			</table>
		</c:if>
	</div>

</body>
</html>