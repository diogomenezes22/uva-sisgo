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
    	<link href="${rootPath}/resources/css/listagem.css" rel="stylesheet">
    	<script src="${rootPath}/resources/js/paciente.js"></script>
	</head>

	<body>

		<%@ include file="../include/topo.jsp" %>
		<input type="hidden" id="pagina" value="paginaPaciente">

		<div class="container">
			<div class="formHeader">
				<h3>Listagem de Paciente</h3>
			</div>
			<div class="mensagemSucesso">${mensagem}</div>
			<table id="tabelaPaciente" class="table table-striped table-bordered dataTable no-footer">
				<thead>
					<th>Nome</th>
					<th>Sexo</th>
					<th>Data de Nascimento</th>
					<th>Celular</th>
					<th>Email</th>
					<th>Acoes</th>
				</thead>
				<tbody>
					<c:forEach items="${pacientes}" var="paciente">
						<tr>
							<td>${paciente.nome}</td>
							<td>${paciente.sexo}</td>
							<td><fmt:formatDate value="${paciente.dataNascimento}" pattern="dd/MM/yyyy" /></td>
							<td>${paciente.celular}</td>
							<td>${paciente.email}</td>						
							<td class="acao">
								<form class="editar" action="${rootPath}/paciente/form/${paciente.id}" method="get"><input type="image" src="${rootPath}/resources/images/editar.gif" title="Editar Paciente"></form>
								<form class="verPlanos" action="${rootPath}/plano-tratamento/listar/${paciente.id}" method="get"><input type="image" src="${rootPath}/resources/images/planoTratamento.png" title="Ver Planos de Tratamento"></form>								
								<form class="excluir" action="${rootPath}/paciente/excluir/${paciente.id}" method="get"><input type="image" src="${rootPath}/resources/images/excluir.gif" title="Excluir Paciente"></form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>			
    	</div>

  	</body>
</html>