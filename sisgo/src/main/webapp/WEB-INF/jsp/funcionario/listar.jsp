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
    	<script src="${rootPath}/resources/js/funcionario.js"></script>
	</head>

	<body>

		<%@ include file="../include/topo.jsp" %>

		<div class="container">
			<div class="formHeader">
				<h3>Listagem de Funcionario</h3>
			</div>
			<div class="mensagemSucesso">${mensagem}</div>
			<table id="tabelaFuncionario" class="table table-striped table-bordered dataTable no-footer">
				<thead>
					<th>Nome</th>
					<th>Login</th>
					<th>Data de Nascimento</th>
					<th>Celular</th>
					<th>Admissao</th>
					<th>Salario</th>
					<th>Acoes</th>
				</thead>
				<tbody>
					<c:forEach items="${funcionarios}" var="funcionario">
						<tr>
							<td>${funcionario.nome}</td>
							<td>${funcionario.login}</td>
							<td><fmt:formatDate value="${funcionario.dataNascimento}" pattern="dd/MM/yyyy" /></td>
							<td>${funcionario.celular}</td>
							<td><fmt:formatDate value="${funcionario.dataAdmissao}" pattern="dd/MM/yyyy" /></td>
							<td>${funcionario.salario}</td>						
							<td class="acao">
								<form id="editar" action="${rootPath}/funcionario/form/${funcionario.id}" method="get"><input type="image" src="${rootPath}/resources/images/editar.gif" title="Editar Funcionario"></form>
								<form id="excluir" action="${rootPath}/funcionario/excluir/${funcionario.id}" method="get"><input type="image" src="${rootPath}/resources/images/excluir.gif" title="Excluir Funcionario"></form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>			
    	</div>

  	</body>
</html>