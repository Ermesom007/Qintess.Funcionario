<%@ taglib prefix= "spring" uri= "http://www.springframework.org/tags" %>
<%@ taglib prefix= "form" uri= "http://www.springframework.org/tags/form" %>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>        


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="../jsp/head.jsp" %>
<%@include file="../jsp/menu.jsp" %>
<title>Cadastro de Tecnologias</title>
<spring:url value="/tecnologia/salva/" var= "salva"></spring:url>
<spring:url value="/tecnologia/altera/" var= "altera"></spring:url>
<spring:url value="/tecnologia/deleta/" var= "deleta"></spring:url>
	
</head>
<body>
	<div class="container">
		
		<h1>Tecnologias</h1>
		
		<h3>Cadastre uma Tecnologia</h3>
		
		<form:form action="${salva}" modelAttribute="tecnologia">
			<form:hidden path="id"/>
			
			<label for="tecnologia">Tecnologia:</label><br>
			<form:input path="nome" id="tecnologia"/>
			
			<br>
			
			<input type="submit" value="${tecnologia.id == 0 ? 'Cadastrar' : 'Alterar' }" />
			
			<c:if test="${tecnologia.id ne 0 }">
				<input type="submit" name="cancela" value="Cancelar"/>
			</c:if>
		
		</form:form>
		
		<hr>
		
		<c:if test="${not empty tecnologias}">
			<table border="1">
				<tr>
					<th>Codigo</th>
					<th>tecnologia</th>
					<th colspan="2">Ações</th>
				</tr>
				<c:forEach var="tecno" items="${tecnologias }">
				<tr>
					<td>${tecno.id}</td>
					<td>${tecno.nome}</td>
					<td><a href="${altera }${tecno.id }">Alterar</a></td>
					<td><a href="${deleta }${tecno.id }">Deletar</a></td>
				</tr>
				</c:forEach>	
			</table>
		</c:if>
	</div>
	

</body>
</html>