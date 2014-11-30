<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<!DOCTYPE html>
<html lang="pt-br">
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
    	<script src="${rootPath}/resources/js/funcionario.js"></script>
	</head>

	<body>

		<%@ include file="../include/topo.jsp" %>
		<input type="hidden" id="pagina" value="paginaFuncionario">

		<div class="container">
			<div class="formHeader">
				<h3>Formulario de Funcionario</h3>
			</div>
			<form id="funcionarioForm" action="${rootPath}/funcionario/salvar" method="post" class="form-horizontal" role="form">
				<input type="hidden" id="id" name="funcionario.id" value="${funcionario.id}">
				<c:if test="${not empty funcionario.id}">
					<div class="form-group">
						<label class="col-sm-2 control-label">Codigo</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" value="${funcionario.id}" readonly>
						</div>
					</div>				
				</c:if>	
				<div class="form-group">
					<label for="nome" class="col-sm-2 control-label">Nome</label>
					<div class="col-sm-10">
						<input type="text" id="nome" name="funcionario.nome" class="form-control" placeholder="Nome" value="${funcionario.nome}" required>
					</div>
				</div>
				<div class="form-group">
					<label for="cpf" class="col-sm-2 control-label">Cpf</label>
					<div class="col-sm-10">
						<input type="text" id="cpf" name="funcionario.cpf" class="form-control" placeholder="CPF" value="${funcionario.cpf}" required>
					</div>
				</div>
				<div class="form-group">
					<label for="dataAdmissao" class="col-sm-2 control-label">Admissao</label>
					<div class="col-sm-10">
						<input type="date" id="dataAdmissao" name="funcionario.dataAdmissao" class="form-control" value="<fmt:formatDate value="${funcionario.dataAdmissao}" pattern="yyyy-MM-dd" />" required>
					</div>
				</div>												
				<div class="form-group">
					<label for="login" class="col-sm-2 control-label">Login</label>
					<div class="col-sm-10">
						<input type="text" id="login" name="funcionario.login" class="form-control" placeholder="Login" value="${funcionario.login}" required>
					</div>
				</div>
				<div class="form-group">
					<label for="senha" class="col-sm-2 control-label">Senha</label>
					<div class="col-sm-10">
						<input type="password" id="senha" name="funcionario.senha" class="form-control" placeholder="Senha" value="${funcionario.senha}" required>
					</div>
				</div>												
				<div class="form-group">
					<label class="col-sm-2 control-label">Sexo</label>
					<div class="radio">
						<label for="sexoMasculino">Masculino</label><input type="radio" id="sexoMasculino" name="funcionario.sexo" value="M" <c:if test="${funcionario.sexo == MASCULINO}">checked</c:if> required>
						<label for="sexoFeminino">Feminino</label><input type="radio" id="sexoFeminino" name="funcionario.sexo" value="F" <c:if test="${funcionario.sexo == FEMININO}">checked</c:if> required>
					</div>
				</div>								
				<div class="form-group">
					<label for="dataNascimento" class="col-sm-2 control-label">Data Nasc.</label>
					<div class="col-sm-10">
						<input type="date" id="dataNascimento" name="funcionario.dataNascimento" class="form-control" value="<fmt:formatDate value="${funcionario.dataNascimento}" pattern="yyyy-MM-dd" />" required>
					</div>
				</div>								
				<div class="form-group">
					<label for="endereco" class="col-sm-2 control-label">Endereco</label>
					<div class="col-sm-10">
						<input type="text" id="endereco" name="funcionario.endereco" class="form-control" placeholder="Endereco Completo" value="${funcionario.endereco}">
					</div>
				</div>
				<div class="form-group">
					<label for="email" class="col-sm-2 control-label">Email</label>
					<div class="col-sm-10">
						<input type="email" id="email" name="funcionario.email" class="form-control" placeholder="Email" value="${funcionario.email}">
					</div>
				</div>
				<div class="form-group">
					<label for="telefone" class="col-sm-2 control-label">Telefone</label>
					<div class="col-sm-10">
						<input type="text" id="telefone" name="funcionario.telefone" class="form-control" placeholder="Telefone" value="${funcionario.telefone}">
					</div>
				</div>
				<div class="form-group">
					<label for="celular" class="col-sm-2 control-label">Celular</label>
					<div class="col-sm-10">
						<input type="text" id="celular" name="funcionario.celular" class="form-control" placeholder="Celular" value="${funcionario.celular}" required>
					</div>
				</div>
				<div class="form-group">
					<label for="dataDemissao" class="col-sm-2 control-label">Demissao</label>
					<div class="col-sm-10">
						<input type="date" id="dataDemissao" name="funcionario.dataDemissao" class="form-control" value="<fmt:formatDate value="${funcionario.dataDemissao}" pattern="yyyy-MM-dd" />">
					</div>
				</div>
				<div class="form-group">
					<label for="salario" class="col-sm-2 control-label">Salario</label>
					<div class="col-sm-10">
						<input type="text" id="salario" name="funcionario.salario" class="form-control" placeholder="Salario" value="<fmt:formatNumber type="number" minFractionDigits="2" value="${funcionario.salario}" />" required>
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