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
    	<script src="${rootPath}/resources/js/tratamento.js"></script>
	</head>

	<body>

		<%@ include file="../include/topo.jsp" %>

		<div class="container">
			<div class="formHeader">
				<h3>Listagem de Tratamentos</h3>
			</div>
			<div class="mensagemSucesso">${mensagem}</div>
			<table id="tabelaTratamento" class="table table-striped table-bordered dataTable no-footer">
				<thead>
					<th>Nome</th>
					<th>Valor</th>
					<th>Acoes</th>
				</thead>
				<tbody>
					<c:forEach items="${tratamentos}" var="tratamento">
						<tr>
							<td>${tratamento.nome}</td>
							<td>${tratamento.valor}</td>						
							<td class="acao">
								<form class="editar" action="${rootPath}/tratamento/form/${tratamento.id}" method="get"><input type="image" src="${rootPath}/resources/images/editar.gif" title="Editar Tratamento"></form>
								<form class="excluir" action="${rootPath}/tratamento/excluir/${tratamento.id}" method="get"><input type="image" src="${rootPath}/resources/images/excluir.gif" title="Excluir Tratamento"></form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>			
    	</div>

  	</body>
</html>