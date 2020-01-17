<%@ page language="java" contentType="text/html; charseT=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix= "spring" uri= "http://www.springframework.org/tags" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Funcionarios</title>

<spring:url value="cargo/" var= "cargo"></spring:url>
<spring:url value="funcionario/" var= "funcionario"></spring:url>
<spring:url value="alocacao/" var= "alocacao"></spring:url>
<spring:url value="relatorio/" var= "relatorio"></spring:url>

</head>
<body>

<%@include file="../jsp/head.jsp" %>
<%@include file="../jsp/menu.jsp" %>
<div class="container">
	
	<h1 class="mt5">Controle de Funcionarios</h1>
	
 <div class="row" style="background-color: #CA2727 ;">
   
    
   <div class="text-light">
    <h4 style="padding:20px;">Bem vindo ao Sistema de Formulario do Funcionario</h4>
    <h5 style="padding:20px;">Para Iniciar Preencha primeiramente algumas dessas informações para complementar no formulario principal </h5>
    <ul>
    	<li><a href="/Funcionario/tecnologia/" style="" class="list-group-item list-group-item-action">Tecnologia</a></li>
    	<li><a href="/Funcionario/alocacao/" class="list-group-item list-group-item-action">Cliente</a></li>
    	<li><a href="/Funcionario/cargo/" class="list-group-item list-group-item-action">Cargo</a></li>
    	<li><a href="/Funcionario/idioma/" class="list-group-item list-group-item-action">Idioma</a></li>
    	
    
    </ul>
    </div>
 
 </div>
</div>
</body>
</html>