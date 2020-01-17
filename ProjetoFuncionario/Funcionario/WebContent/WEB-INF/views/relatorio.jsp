<%@ taglib prefix= "spring" uri= "http://www.springframework.org/tags" %>
<%@ taglib prefix= "form" uri= "http://www.springframework.org/tags/form" %>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>        


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagina de Relatorios</title>
<%@include file="../jsp/head.jsp" %>
<%@include file="../jsp/menu.jsp" %>
</head>
<body>
	
	<div class="container">
		<h1 class="title">Relatorios</h1>
			<h3>Por Funcionarios</h3>
		
			
				<div class="card mt-3">
				     <div class="card-header">
				         <h2>Funcionarios</h2>
				     </div><!-- fim .card-header -->
				
				     <div class="card-body">
				     	<dt>${funcionarios.size()} Funcionarios Cadastrados</dt>
						<c:forEach var="funcionarios" items="${funcionarios}">
						
						 <dl>
				             <dt>${funcionario.anoExperiencia}</dt>
				            
				             <dd> </dd>
							
				         </dl>
				    		</c:forEach>
					</div><!-- fim .card-body -->
				</div><!-- fim .card -->
		<hr>
		<h3>Dados Especificos</h3>		
		<div class="card-group">
				<div class="card mt-3">
				     <div class="card-header">
				         <h2>Por Tecnologia</h2>
				     </div><!-- fim .card-header -->
				
				     <div class="card-body">
							<c:forEach var="tecnologia" items="${tecnologias}">
						 
						 	<dt>${tecnologia.nome}</dt>
						 <dl>
						 	
				             <dd>${tecnologia.funcionarios.size()} Funcionarios Trabalham com essa Idioma</dd>
				             
				               <dd>${tecnologia.funcionariosDeInteresse.size()} Funcionarios que alegam conhecer Essa ferramenta</dd>
				            	
				             <dd>${tecnologia.professores.size()} Funcionarios estão dispostos a ensinar esse Idioma</dd>
				             
				             <dd>${tecnologia.alunos.size()} Funcionarios estão dispostos a aprender esse Idioma</dd>
							
				         </dl>
				    		</c:forEach>
					</div><!-- fim .card-body -->
				</div><!-- fim .card -->
				
				
				
				<div class="card mt-3">
				     <div class="card-header">
				         <h2>Por Idioma</h2>
				     </div><!-- fim .card-header -->
				
				     <div class="card-body">
							<c:forEach var="idioma" items="${idiomas}">
						 
						 	<dt>${idioma.idioma}</dt>
						 <dl>
						 	
				             <dd>${idioma.funcionarios.size()} Funcionarios alegam Saber esse Idioma</dd>
				            	
				             <dd>${idioma.professores.size()} Funcionarios estão dispostos a ensinar esse Idioma</dd>
				             
				             <dd>${idioma.alunos.size()} Funcionarios estão dispostos a aprender esse Idioma</dd>
							
				         </dl>
				    		</c:forEach>
					</div><!-- fim .card-body -->
				</div><!-- fim .card -->
		
			</div>
			
		<h2>Por Clientes</h2>
		<div class="card-group">
			<c:forEach var="alocacao" items="${alocacoes}">
				<div class="card mt-3">
				     <div class="card-header">
				         <h2>${alocacao.cliente}</h2>
				     </div><!-- fim .card-header -->
				
				     <div class="card-body">
					
						 <dl>
				             <dt>Funcionarios</dt>
				            
				             <dd>${alocacao.funcionarios.size()}</dd>
							
				         </dl>
				    
					</div><!-- fim .card-body -->
				</div><!-- fim .card -->
			</c:forEach>
		</div>
		
		
		
		<hr>
		<h2>Por Cargos</h2>
		
			
				<div class="card mt-3">
				     <div class="card-header">
				         <h2>Cargos</h2>
				     </div><!-- fim .card-header -->
				
				     <div class="card-body">
						<c:forEach var="cargo" items="${cargos}">
						 <dl>
				             <dt>${cargo.cargo}</dt>
				            
				             <dd>${cargo.funcionarios.size()} Funcionario Nessa Funcão</dd>
							
				         </dl>
				    	</c:forEach>
					</div><!-- fim .card-body -->
				</div><!-- fim .card -->
			
			
			<hr>
		<h2>Por Beneficios</h2>
		
			
				<div class="card mt-3">
				     <div class="card-header">
				         <h2>Beneficios</h2>
				     </div><!-- fim .card-header -->
				
				     <div class="card-body">
						<c:forEach var="beneficio" items="${beneficios}">
						
						 <dl>
				             <dt>${beneficio.descricao}</dt>
				            
				             <dd>${beneficio.funcionarios.size()} Funcionarios querem ter esse Beneficio</dd>
							
				         </dl>
				    		</c:forEach>
					</div><!-- fim .card-body -->
				</div><!-- fim .card -->
			
		
	</div>
</body>
</html>