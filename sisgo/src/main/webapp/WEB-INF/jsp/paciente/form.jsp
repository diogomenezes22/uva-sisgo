<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="description" content="">
	    <meta name="author" content="">
	    <link rel="icon" href="../../favicon.ico">

    	<title>SISGO</title>

    	<%@ include file="../include/geral.jsp" %>
    	<link href="${rootPath}/resources/css/form.css" rel="stylesheet">
	</head>

	<body>

		<%@ include file="../include/topo.jsp" %>

		<div class="container">
			<div class="formHeader">
				<h3>Formulario de Paciente</h3>
			</div>
			<form id="pacienteForm" action="${rootPath}/paciente/salvar" method="post" class="form-horizontal" role="form">
				<input type="hidden" id="id" name="paciente.id" value="${paciente.id}">
				<div class="form-group">
					<label for="nome" class="col-sm-2 control-label">Nome</label>
					<div class="col-sm-10">
						<input type="text" id="nome" name="paciente.nome" class="form-control" placeholder="Nome" value="${paciente.nome}">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">Sexo</label>
					<div class="radio">
						<label for="sexoMasculino">Masculino</label><input type="radio" id="sexoMasculino" name="paciente.sexo" value="M" <c:if test="${paciente.sexo == MASCULINO}">checked</c:if>>
						<label for="sexoFeminino">Feminino</label><input type="radio" id="sexoFeminino" name="paciente.sexo" value="F" <c:if test="${paciente.sexo == FEMININO}">checked</c:if>>
					</div>
				</div>
				<div class="form-group">
					<label for="profissao" class="col-sm-2 control-label">Profissao</label>
					<div class="col-sm-10">
						<input type="text" id="nome" name="paciente.profissao" class="form-control" placeholder="Profissao" value="${paciente.profissao}">
					</div>
				</div>
				<div class="form-group">
					<label for="profissao" class="col-sm-2 control-label">Estado Civil</label>
					<div class="col-sm-10">
						<select id="estadoCivil" name="paciente.estadoCivil.id" class="form-control">
							<c:forEach items="${estadosCivis}" var="estadoCivil">
								<option value="${estadoCivil.id}" <c:if test="${paciente.estadoCivil.id == estadoCivil.id}">selected</c:if>>${estadoCivil.nome}</option>
							</c:forEach>
						</select>
					</div>
				</div>								
				<div class="form-group">
					<label for="dataNascimento" class="col-sm-2 control-label">Data</label>
					<div class="col-sm-10">
						<input type="date" id="dataNascimento" name="paciente.dataNascimento" class="form-control" value="<fmt:formatDate value="${paciente.dataNascimento}" pattern="yyyy-MM-dd" />">
					</div>
				</div>								
				<div class="form-group">
					<label for="endereco" class="col-sm-2 control-label">Endereco</label>
					<div class="col-sm-10">
						<input type="text" id="endereco" name="paciente.endereco" class="form-control" placeholder="Endereco Completo" value="${paciente.endereco}">
					</div>
				</div>
				<div class="form-group">
					<label for="email" class="col-sm-2 control-label">Email</label>
					<div class="col-sm-10">
						<input type="email" id="email" name="paciente.email" class="form-control" placeholder="Email" value="${paciente.email}">
					</div>
				</div>
				<div class="form-group">
					<label for="telefone" class="col-sm-2 control-label">Telefone</label>
					<div class="col-sm-10">
						<input type="text" id="telefone" name="paciente.telefone" class="form-control" placeholder="Telefone" value="${paciente.telefone}">
					</div>
				</div>
				<div class="form-group">
					<label for="celular" class="col-sm-2 control-label">Celular</label>
					<div class="col-sm-10">
						<input type="text" id="celular" name="paciente.celular" class="form-control" placeholder="Celular" value="${paciente.celular}">
					</div>
				</div>
				<div class="form-group">
					<label for="obs" class="col-sm-2 control-label">Obs</label>
					<div class="col-sm-10">
						<input type="text" id="obs" name="paciente.obs" class="form-control" placeholder="Obs" value="${paciente.obs}">
					</div>
				</div>				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-success">Salvar</button>
					</div>
				</div>
			</form>			
    	</div>

  	</body>
</html>