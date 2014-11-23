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
    	<link href="${rootPath}/resources/css/listagem.css" rel="stylesheet">
    	<script src="${rootPath}/resources/js/procedimentoConsulta.js"></script>
	</head>

	<body>

		<%@ include file="../include/topo.jsp" %>

		<div class="container">
			<input type="hidden" id="consultaId" value="${consulta.id}">
			<div class="formHeader">
				<h3>Listagem de Procedimentos da Consulta (${paciente.nome})</h3>
			</div>
			<div class="mensagemSucesso">${mensagem}</div>
			<div class="mensagemErro">${erro}</div>
			<table id="tabelaProcedimentoConsulta" class="table table-striped table-bordered dataTable no-footer">
				<thead>
					<th>Codigo</th>
					<th>Procedimento</th>
					<th>Obs</th>
					<th>Acoes</th>
				</thead>
				<tbody>
					<c:forEach items="${procedimentosDaConsulta}" var="procedimentoDaConsulta">
						<tr>
							<td>${procedimentoDaConsulta.id}</td>
							<td>${procedimentoDaConsulta.procedimento.tratamento.nome}</td>
							<td>${procedimentoDaConsulta.obs}</td>				
							<td class="acao">
								<form class="editar" action="${rootPath}/procedimento-consulta/${consulta.id}/form/${procedimentoDaConsulta.id}" method="get"><input type="image" src="${rootPath}/resources/images/editar.gif" title="Editar Procedimento"></form>								
								<form class="excluir" action="${rootPath}/procedimento-consulta/excluir/${procedimentoDaConsulta.id}" method="get"><input type="image" src="${rootPath}/resources/images/excluir.gif" title="Excluir Procedimento"></form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>			
    	</div>

  	</body>
</html>