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
    	<script src="${rootPath}/resources/js/dentista.js"></script>
	</head>

	<body>

		<%@ include file="../include/topo.jsp" %>
		<input type="hidden" id="pagina" value="paginaDentista">

		<div class="container">
			<div class="formHeader">
				<h3>Formulario de Dentista</h3>
			</div>
			<form id="dentistaForm" action="${rootPath}/dentista/salvar" method="post" class="form-horizontal" role="form">
				<input type="hidden" id="id" name="dentista.id" value="${dentista.id}">
				<div class="form-group">
					<label for="nome" class="col-sm-2 control-label">Nome</label>
					<div class="col-sm-10">
						<input type="text" id="nome" name="dentista.nome" class="form-control" placeholder="Nome" value="${dentista.nome}" required>
					</div>
				</div>
				<div class="form-group">
					<label for="cpf" class="col-sm-2 control-label">Cpf</label>
					<div class="col-sm-10">
						<input type="text" id="cpf" name="dentista.cpf" class="form-control" placeholder="CPF" value="${dentista.cpf}" required>
					</div>
				</div>
				<div class="form-group">
					<label for="cro" class="col-sm-2 control-label">Cro</label>
					<div class="col-sm-10">
						<input type="text" id="cro" name="dentista.cro" class="form-control" placeholder="CRO" value="${dentista.cro}" required>
					</div>
				</div>
				<div class="form-group">
					<label for="especialidade" class="col-sm-2 control-label">Especialidade</label>
					<div class="col-sm-10">
						<input type="text" id="especialidade" name="dentista.especialidade" class="form-control" placeholder="Especialidade" value="${dentista.especialidade}">
					</div>
				</div>								
				<div class="form-group">
					<label for="login" class="col-sm-2 control-label">Login</label>
					<div class="col-sm-10">
						<input type="text" id="login" name="dentista.login" class="form-control" placeholder="Login" value="${dentista.login}" required>
					</div>
				</div>
				<div class="form-group">
					<label for="senha" class="col-sm-2 control-label">Senha</label>
					<div class="col-sm-10">
						<input type="password" id="senha" name="dentista.senha" class="form-control" placeholder="Senha" value="${dentista.senha}" required>
					</div>
				</div>												
				<div class="form-group">
					<label class="col-sm-2 control-label">Sexo</label>
					<div class="radio">
						<label for="sexoMasculino">Masculino</label><input type="radio" id="sexoMasculino" name="dentista.sexo" value="M" <c:if test="${dentista.sexo == MASCULINO}">checked</c:if> required>
						<label for="sexoFeminino">Feminino</label><input type="radio" id="sexoFeminino" name="dentista.sexo" value="F" <c:if test="${dentista.sexo == FEMININO}">checked</c:if> required>
					</div>
				</div>								
				<div class="form-group">
					<label for="dataNascimento" class="col-sm-2 control-label">Data</label>
					<div class="col-sm-10">
						<input type="date" id="dataNascimento" name="dentista.dataNascimento" class="form-control" value="<fmt:formatDate value="${dentista.dataNascimento}" pattern="yyyy-MM-dd" />" required>
					</div>
				</div>								
				<div class="form-group">
					<label for="endereco" class="col-sm-2 control-label">Endereco</label>
					<div class="col-sm-10">
						<input type="text" id="endereco" name="dentista.endereco" class="form-control" placeholder="Endereco Completo" value="${dentista.endereco}">
					</div>
				</div>
				<div class="form-group">
					<label for="email" class="col-sm-2 control-label">Email</label>
					<div class="col-sm-10">
						<input type="email" id="email" name="dentista.email" class="form-control" placeholder="Email" value="${dentista.email}">
					</div>
				</div>
				<div class="form-group">
					<label for="telefone" class="col-sm-2 control-label">Telefone</label>
					<div class="col-sm-10">
						<input type="text" id="telefone" name="dentista.telefone" class="form-control" placeholder="Telefone" value="${dentista.telefone}">
					</div>
				</div>
				<div class="form-group">
					<label for="celular" class="col-sm-2 control-label">Celular</label>
					<div class="col-sm-10">
						<input type="text" id="celular" name="dentista.celular" class="form-control" placeholder="Celular" value="${dentista.celular}" required>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">Admin</label>
					<div class="checkbox">
						<label>
							<input type="checkbox" id="admin" name="dentista.admin" <c:if test="${dentista.admin}">checked</c:if>>
						</label>
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