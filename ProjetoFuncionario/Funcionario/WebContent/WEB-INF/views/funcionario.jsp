<%@ taglib prefix= "spring" uri= "http://www.springframework.org/tags" %>
<%@ taglib prefix= "form" uri= "http://www.springframework.org/tags/form" %>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>        


<!DOCTYPE html>
<html>
<head>
	<script src="jquery-3.4.1.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<%@include file="../jsp/head.jsp" %>
	
	<meta charset="UTF-8">
	
	<title>Cadastro de Funcionario</title>
	
	 
	<spring:url value="/funcionario/salva" var= "salva"></spring:url>
	<spring:url value="/funcionario/altera/" var= "altera"></spring:url>
	<spring:url value="/funcionario/deleta/" var= "deleta"></spring:url>
	 
	 
</head>
<body>
<%@include file="../jsp/menu.jsp" %>
	
	<div class="container">
	
		<h1>Funcionarios</h1>
	
			<h3 class="mb-3">Cadastro de Funcionario</h3>
			
			
			
			
			
			<form:form class="mt-3"  action="${salva}"  method="get"  modelAttribute="funcionario">
			
			
			
		<div class="form-group row">
				<label for="Atua" class="col-sm-2 col-form-label">Atua na Area Tecnica</label>
				<form:select path=""  onchange="tecnico()" name="atua" id="atua" required="true">
					
						<form:option value="1">Sim</form:option>
						<form:option value="0">Não</form:option>
									
				</form:select>
			</div>
			<div class="form-group row">	
				<form:hidden path="id"/>
				
				<label for="nome" class="col-sm-2 col-form-label">Nome</label>
				<form:input required="true" class="col-sm-6" path="nome" id="nome" />
			</div>
			
			<div class="form-group row">	

				<label for="email" class="col-sm-2 col-form-label">Email</label>
				<form:input required="true" class="col-sm-6" path="email" id="email"/>
			</div>
			
			<div class="form-group row">	

				<label for="endereco" class="col-sm-2 col-form-label">Endereço:</label>
				<form:input required="true" class="col-sm-6" path="endereco" id="endereco"/>
			</div>
				
			<div class="form-group row">	

				<label for="cidade" class="col-sm-2 col-form-label">Cidade</label>
				<form:input required="true" class="col-sm-6" path="cidade" id="cidade"/>
			</div>
				
			<div class="form-group row">	

				<label for="estado" class="col-sm-2 col-form-label">Estado</label>
				<form:input required="true" class="col-sm-6" path="estado" id="estado"/>
			</div>
					
			<div class="form-group row">	
				<label for="alocacao" class="col-sm-2 col-form-label">Alocação</label>
				<form:select path="iddAlocacao" name="alocacao">
					<c:forEach var="alocacao" items="${alocacoes}">
	      				<form:option value="${alocacao.id}">${alocacao.cliente}</form:option>
	      			</c:forEach>	
    			</form:select>
			</div>
			<hr/>
			<div id="aviso"></div>
			<div class="form-group row">	
				<label for="tecnologia" class="col-sm-2 col-form-label">Tecnologia ou Ramo com o qual trabalha</label>
				<form:select path="tecnologia" name="tecnologia" id="tecnologia">
					<c:forEach var="tecnologia" items="${tecnologias}">
						<form:option value="${tecnologia.id}">${tecnologia.nome}</form:option>				
					</c:forEach>
				</form:select>
			</div>	
				
					
			<div class="form-group row">	
				<label for="cargo" class="col-sm-2 col-form-label">Cargo</label>
				<form:select path="iddCargo" name="cargo" id="cargo" disabled="true">
					<c:forEach var="cargo" items="${cargos}">
						<form:option value="${cargo.id}">${cargo.cargo}</form:option>				
					</c:forEach>
				</form:select>
			</div>
			<hr/>
				 
			<div class="form-group row">
				<label for="formacao" class="col-sm-2 col-form-label">Formação Academica</label>
				<form:select path="formacaoAcademica" name="formacao" id="formacao">
					
						<form:option value="Ensino Medio">Ensino Medio</form:option>
						<form:option value="Ensino Superior">Ensino Superior</form:option>
						<form:option value="Pos">Pós</form:option>
						<form:option value="MBA">MBA</form:option>				
						<form:option value="Mestrado">Mestrado</form:option>
						<form:option value="Doutorado">Doutorado</form:option>				
				</form:select>
			</div>
			
			
			<div class="form-group row">	
				<label for="experiencia" class="col-sm-2 col-form-label">Anos de Experiencia</label>
				<form:select path="anoExperiencia" name="experiencia" id="experiencia">
					
						<form:option value="1">1 ano</form:option>
						<form:option value="2">2 anos</form:option>
						<form:option value="3">3 anos</form:option>
						<form:option value="4">4 anos</form:option>				
						<form:option value="+5">5 anos ou mais</form:option>
										
				</form:select>
			</div>
				
			<div class="form-group row">	
				<label for="certificacao"  class="col-sm-2 col-form-label">Certificações </label>
				<form:textarea path="certificacoes" id="certificacao"/>
			</div>
			
				
			<div class="form-group row">	
				<label for="outroConhecimento" class="col-sm-2 col-form-label">Outro Conhecimento</label>
				<form:select path="outroConhecimento" name="outroConhecimento" id="outroConhecimento">
					<c:forEach var="tecnologia" items="${tecnologias}">
						<form:option value="${tecnologia.id}">${tecnologia.nome}</form:option>				
					</c:forEach>
				</form:select>
			</div>	
				
			<div class="form-group row">	
				<label for="idiomas" class="col-sm-2 col-form-label">Idiomas:</label>
				<form:select required="true" class="select-multiple" path="idiomas" name="idiomas" id="idiomas" multiple="multiple">
					<c:forEach var="idioma" items="${idiomas}">
						<form:option value="${idioma.id}">${idioma.idioma}</form:option>				
					</c:forEach>
				</form:select>
			</div>		
				
				<hr>
				
				
			<h5>Cadastro de Dependentes(filhos)</h5>
			
			
				<div id="filho">
					<a href="#" class="btn btn-danger" data-text="Não Possuo Filhos" data-event="click"  onclick="tenhoFilho();" 
					data-toggle-form-edit="#form-que-alterna" title="Possuo filho(s)">Não Possuo filhos</a>
				</div>
				
			
			<hr>
			<h5>Que beneficios gostaria de ter?</h5>
			<div class="form-group row">	
				<label for="beneficios" class="col-sm-2 col-form-label">Beneficios</label>
				<form:select path="beneficios" name="beneficios" id="beneficios" multiple="multiple">
					<c:forEach var="beneficio" items="${beneficios}">
						<form:option value="${beneficio.id}">${beneficio.descricao}</form:option>				
					</c:forEach>
				</form:select>
			</div>
			<hr>
				
			<h5>Temas que tem interesse Aprender</h5>
				
			<div class="form-group row">	
				<label for="idiomasAprender" class="col-sm-2 col-form-label">Idiomas:</label>
				<form:select required="true" class="select-multiple" path="idiomasAprender" name="idiomasAprender" id="idiomasAprender" multiple="multiple">
					<c:forEach var="idioma" items="${idiomas}">
						<form:option value="${idioma.id}">${idioma.idioma}</form:option>				
					</c:forEach>
				</form:select>
			</div>	
			<hr>
			<div  class="form-group row">	
				<label for="tecnologiasAprender" class="col-sm-2 col-form-label">Tecnologias:</label>
				<form:select required="true" path="tecnologiasAprender" name="tecnologiasAprender" id="tecnologiasAprender">
					<c:forEach var="tecnologia" items="${tecnologias}">
						<form:option value="${tecnologia.id}">${tecnologia.nome}</form:option>				
					</c:forEach>
				</form:select>
			</div>	
					
			<hr>
				
			<h5>Temas que tem interesse em Ensinar</h5>
				
			<div class="form-group row">	
				<label for="idiomas" class="col-sm-2 col-form-label">Idiomas:</label>
				<form:select required="true" class="select-multiple" path="idiomasEnsinar" name="idiomasEnsinar" id="idiomas" multiple="multiple">
					<c:forEach var="idioma" items="${idiomas}">
						<form:option value="${idioma.id}">${idioma.idioma}</form:option>				
					</c:forEach>
				</form:select>
			</div>	
			
			<div class="form-group row">	
				<label for="tecnologiasEnsinar" class="col-sm-2 col-form-label">Tecnologias:</label>
				<form:select required="true" path="tecnologiasEnsinar" name="tecnologiasEnsinar" id="tecnologiasEnsinar">
					<c:forEach var="tecnologia" items="${tecnologias}">
						<form:option value="${tecnologia.id}">${tecnologia.nome}</form:option>				
					</c:forEach>
				</form:select>
			</div>	
				
				<hr>
				
				<input class="btn btn-outline-success" type="submit" value="${funcionario.id == 0 ? 'Cadastrar' : 'Alterar' }"/>
				
				
				<c:if test="${funcionario.id ne 0}">
					<input type="submit" name="cancela" value="Cancelar"/>
				</c:if>		
			
			</form:form>
			
			
				
				
				
				
				
				
				
				
				
			<hr>
			
			<c:if test="${not empty funcionarios}">
				<table border="1">
					<tr>
						<th>Codigo</th>
						<th>Nome</th>
						<th>Alocação</th>
						<th>Cargo</th>
						<th>Formação Academica</th>
						<th>Trabalha com</th>
						<th>Certificações</th>
						
						
						<th colspan="2">Ações</th>				
					</tr>
					<c:forEach var="funcionario" items="${funcionarios}">
					<tr>
						<td>${funcionario.id}</td>
						<td>${funcionario.nome}</td>
						<td>${funcionario.alocacao.cliente}</td>
						<td>${funcionario.cargo.cargo}</td>
						<td>${funcionario.formacaoAcademica}</td>
						<td>${funcionario.tecnologia.nome}</td>
						<td>${funcionario.certificacoes}</td>
						
					
						<td><a href="${altera} ${funcionario.id}">Alterar</a></td>
						<td><a href="${deleta} ${funcionario.id}">Deletar</a></td>
		
					</tr>	
					</c:forEach>
				</table>
			</c:if>

		</div>
		
	
</body>
<script type="text/javascript">
			

			function tecnico() {
				var atua = document.getElementById("atua").value;
				
				if(atua == 1){
					document.getElementById("tecnologia").disabled = false;
					document.getElementById("cargo").disabled = true;
					html="<p class='text-danger'>*necessario o prenchimento apenas da Tecnologia</p>"
					document.getElementById("aviso").innerHTML= html;
				}else if(atua ==0){
					
				 	document.getElementById("cargo").disabled = false;
				 	document.getElementById("tecnologia").disabled = true;
				 	html="<p class='text-danger'>*necessario o prenchimento apenas de cargo</p>"
				 	document.getElementById("aviso").innerHTML= html; 
				}
				
			};
			function adicionaCampo(){
				
				idContador++;
				
				var idCampo = "filhos"+idContador;
				var idForm = "formExtra"+idContador;
			
				var html1 = "";
				
				html1 += "<div style='margin-top: 8px;' class='input-group'  class='input-group' id='"+idForm+"'>";
				html1 += "<input type='text' id='"+idCampo+"'  required='true' name='filhos' path='filhos' class='form-control novoCampo col-sm-6'   placeholder='Insira a idade do seu filho(a)'/>";
				html1 += "<span class='input-group-btn'>";
				html1 +=	"<button class='btn' onclick='exclui("+idForm+")' type='button'><span class='fa fa-trash'></span></button>";
				html1 += "</span>";
				html1 += "</div>";
				
				$("#imendaHTMLFilho").append(html1);
			}
		$( document ).ready(function() {
			
			$("#btnAdd").click(function(e){
				e.preventDefault();
				document.getElementById("filho").innerHTML ="";
				adicionaCampo();
			})
		
			
			
			$(".btnExcluir").click(function(){
				console.log("clicou");
				$(this).slideUp(200);
			})
			
			$("#btnSalvar").click(function(){
			
			var mensagem = "";
			var novosCampos = [];
			var camposNulos = false;
			
				$('.campoDefault').each(function(){
					if($(this).val().length < 1){
						camposNulos = true;
					}
				});
				$('.novoCampo').each(function(){
					if($(this).is(":visible")){
						if($(this).val().length < 1){
							camposNulos = true;
						}
						//novosCampos.push($(this).val());
						mensagem+= $(this).val()+"\n";
					}
				});
				
				if(camposNulos == true){
					alert("Atenção: existem campos nulos");
				}else{
					alert("Novos campos adicionados: \n\n "+mensagem);
				}
				
				novosCampos = [];
			})
			
		});
			
			$(document).ready(function() {
				$('select').formSelect();
			});
			
			
			function tenhoFilho(){
				
				var html ="";
				
				html+=  "<a href='#' class='btn btn-success mb-3' data-text='Possuo Filhos' data-event='click'  onclick='naoTenhoFilho();' data-toggle-form-edit=''#form-que-alterna' title='Possuo filho(s)'>Possuo filhos</a>";
			
				  
				html+=	"<div  class='col-sm-6 mt-3'>";
				html+=	"<label>Filho:</label>";
				html+=	"<input  path='filhos' name='filhos'  required='true' class='form-control novoCampo col-sm-6'   placeholder='Insira a idade do seu filho'/>";
					
				html+=	"<div id='imendaHTMLFilho'></div>";
					
				html+=	"<a href='#'  id='btnAdd' onclick='adicionaCampo();' ><i class='fa fa-plus'></i> Adicionar mais um(a)</a>";
				html+=	"</div>";
				
				document.getElementById("filho").innerHTML= html;  
			}

			function naoTenhoFilho(){

				
					document.getElementById("filho").innerHTML =
					"<a href='#' class='btn btn-danger' data-text='Não Possuo Filhos' data-event='click'  onclick='tenhoFilho();' data-toggle-form-edit=''#form-que-alterna' title='Possuo filho(s)'>Não Possuo filhos</a>";
			}
			
			var idContador = 0;
			
			
			function exclui(id){
				var campo = $("#"+id.id);
				campo.hide(200);
			}

		
			
	
		</script>
</html>