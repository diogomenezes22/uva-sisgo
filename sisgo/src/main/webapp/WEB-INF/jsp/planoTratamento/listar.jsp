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
    	<script src="${rootPath}/resources/js/planoTratamento.js"></script>
	</head>

	<body>

		<%@ include file="../include/topo.jsp" %>

		<div class="container">
			<input type="hidden" id="pacienteId" value="${paciente.id}">
			<div class="formHeader">
				<h3>Listagem de Planos de Tratamento (${paciente.nome})</h3>
			</div>
			<div class="mensagemSucesso">${mensagem}</div>
			<table id="tabelaPlanoTratamento" class="table table-striped table-bordered dataTable no-footer">
				<thead>
					<th>Codigo</th>
					<th>Data de Inicio</th>
					<th>Procedimentos</th>
					<th>Data de Conclusao</th>
					<th>Valor</th>
					<th>Em Aberto</th>
					<th>Acoes</th>
				</thead>
				<tbody>
					<c:forEach items="${planosDeTratamento}" var="planoTratamento">
						<tr>
							<td>${planoTratamento.id}</td>
							<td><fmt:formatDate value="${planoTratamento.dataInicial}" pattern="dd/MM/yyyy" /></td>
							<td>${fn:length(planoTratamento.procedimentos)}</td>
							<td><fmt:formatDate value="${planoTratamento.dataConclusao}" pattern="dd/MM/yyyy" /></td>
							<td><fmt:formatNumber pattern="#,##0.00#" value="${planoTratamento.valorTotal}" /></td>							
							<td><c:choose><c:when test="${planoTratamento.emAberto}">Sim</c:when><c:otherwise>Nao</c:otherwise></c:choose></td>				
							<td class="acao">
								<form class="editar" action="${rootPath}/plano-tratamento/form/${planoTratamento.id}" method="get"><input type="image" src="${rootPath}/resources/images/editar.gif" title="Editar Plano"></form>								
								<form class="excluir" action="${rootPath}/plano-tratamento/excluir/${planoTratamento.id}" method="get"><input type="image" src="${rootPath}/resources/images/excluir.gif" title="Excluir Plano"></form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>			
    	</div>

  	</body>
</html>