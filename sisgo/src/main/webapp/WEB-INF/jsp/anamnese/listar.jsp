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
    	<script src="${rootPath}/resources/js/anamnese.js"></script>
	</head>

	<body>

		<%@ include file="../include/topo.jsp" %>

		<div class="container">
			<input type="hidden" id="pacienteId" value="${paciente.id}">
			<div class="formHeader">
				<h3>Listagem de Anamneses (${paciente.nome})</h3>
			</div>
			<div class="mensagemSucesso">${mensagem}</div>
			<table id="tabelaAnamnese" class="table table-striped table-bordered dataTable no-footer">
				<thead>
					<th>Codigo</th>
					<th>Data de Preenchimento</th>
					<th>Acoes</th>
				</thead>
				<tbody>
					<c:forEach items="${anamneses}" var="anamnese">
						<tr>
							<td>${anamnese.id}</td>
							<td><fmt:formatDate value="${anamnese.dataPreenchimento}" pattern="dd/MM/yyyy" /></td>
							<td class="acao">
								<form class="editar" action="${rootPath}/anamnese/form/${anamnese.id}" method="get"><input type="image" src="${rootPath}/resources/images/editar.gif" title="Editar Anamnese"></form>								
								<form class="excluir" action="${rootPath}/anamnese/excluir/${anamnese.id}" method="get"><input type="image" src="${rootPath}/resources/images/excluir.gif" title="Excluir Anamnese"></form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>			
    	</div>

  	</body>
</html>