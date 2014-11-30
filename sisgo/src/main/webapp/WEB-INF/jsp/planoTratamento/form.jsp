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
    	<link href="${rootPath}/resources/css/formPlanoTratamento.css" rel="stylesheet">
    	<script src="${rootPath}/resources/js/planoTratamento.js"></script>
	</head>

	<body>

		<%@ include file="../include/topo.jsp" %>

		<div class="container">
			<div class="formHeader">
				<h3>Formulario de Plano de Tratamento</h3>
			</div>
			<form id="planoTratamentoForm" action="${rootPath}/plano-tratamento/salvar" method="post" class="form-horizontal" role="form">
				<input type="hidden" id="id" name="planoTratamento.id" value="${planoTratamento.id}">
				<input type="hidden" id="id" name="planoTratamento.paciente.id" value="${paciente.id}">
				<c:if test="${not empty planoTratamento.id}">
					<div class="form-group">
						<label class="col-sm-2 control-label">Codigo</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" value="${planoTratamento.id}" readonly>
						</div>
					</div>				
				</c:if>				
				<div class="form-group">
					<label for="dataInicial" class="col-sm-2 control-label">Data de Inicio</label>
					<div class="col-sm-10">
						<input type="date" id="dataInicial" name="planoTratamento.dataInicial" class="form-control" value="<fmt:formatDate value="${planoTratamento.dataInicial}" pattern="yyyy-MM-dd" />" required>
					</div>
				</div>
				<div class="form-group">
					<label for="dataConclusao" class="col-sm-2 control-label">Data de Conclusao</label>
					<div class="col-sm-10">
						<input type="date" id="dataConclusao" name="planoTratamento.dataConclusao" class="form-control" value="<fmt:formatDate value="${planoTratamento.dataConclusao}" pattern="yyyy-MM-dd" />">
					</div>
				</div>																			
				<div class="form-group">
					<label for="obs" class="col-sm-2 control-label">Obs</label>
					<div class="col-sm-10">
						<input type="text" id="obs" name="planoTratamento.obs" class="form-control" placeholder="Obs" value="${planoTratamento.obs}">
					</div>
				</div>			
				<div class="form-group">
					<label class="col-sm-2 control-label">Em Aberto</label>
					<div class="checkbox">
						<label>
							<input type="checkbox" id="emAberto" name="planoTratamento.emAberto" <c:if test="${planoTratamento.emAberto}">checked</c:if>>
						</label>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">Tratamentos</label>
					<div class="checkbox opcoesTratamentos">
						<c:forEach items="${tratamentos}" var="tratamento" varStatus="t">
							<c:if test="${t.index != 0 && t.index % 5 == 0}"><br /></c:if>
							<label class="tratamento">
								${tratamento.nome} <input type="checkbox" name="planoTratamento.procedimentos[${t.index}].tratamento.id" class="opcaoTratamento" value="${tratamento.id}" <c:if test="${not empty planoTratamento.mapaProcedimentos[tratamento.id]}">checked</c:if>>
								<c:forEach items="${planoTratamento.procedimentos}" var="procedimento">
									<c:if test="${procedimento.tratamento.id == tratamento.id}">
										<input type="hidden" name="planoTratamento.procedimentos[${t.index}].id" value="${procedimento.id}">
									</c:if>
								</c:forEach>								
								<input type="hidden" class="valorTratamento" value="${tratamento.valor}">
							</label>
						</c:forEach>
					</div>
				</div>
				<div class="form-group">
					<label for="valorTotal" class="col-sm-2 control-label">Valor Total</label>
					<div class="col-sm-10">
						<input type="text" id="valorTotal" name="planoTratamento.valorTotal" class="form-control" placeholder="Valor do Tratamento" value="<fmt:formatNumber pattern="#,##0.00#" value="${planoTratamento.valorTotal}" />" required>
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