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
    	<link href="${rootPath}/resources/css/relatorioAnalitico.css" rel="stylesheet">
    	<script src="${rootPath}/resources/js/relatorioTratamentosRealizados.js"></script>
	</head>

	<body>

		<c:set var="totalPlanos" value="0"></c:set>

		<table>
			<tr>
				<td colspan="3" class="cabecalho">
					<div class="logo"><img src="${rootPath}/resources/images/logoSisgo.png" />SISGO</div>
					<div class="nomeRelatorio">Relatório de Tratamentos Realizados</div>
				</td>
			</tr>
			<tr>
				<td colspan="3" class="cabecalho2">					
					<div class="emissao">Emitido em <fmt:formatDate value="${dataEmissao}" pattern="dd/MM/yyyy 'às' HH:mm" /> por ${sessaoUsuario.usuario.nome}</div>
				</td>
			</tr>				
			<c:forEach items="${relatorio.tratamentos}" var="tratamento">
				<c:set var="totalPlanos" value="${totalPlanos + fn:length(tratamento.planos)}"></c:set>
				<tr class="linhaAgrupamento">
					<td colspan="2">${tratamento.nome}</td>
					<td colspan="1" style="text-align: right;">${fn:length(tratamento.planos)} planos</td>
				</tr>
				<tr class="linhaTh">
					<td>Data</td>
					<td>Paciente</td>
					<td>Junto com outros tratamentos</td>
				</tr>	
				<c:forEach items="${tratamento.planos}" var="plano">
					<tr>
						<td><fmt:formatDate value="${plano.dataInicial}" pattern="dd/MM/yyyy" /></td>
						<td>${plano.paciente.nome}</td>
						<td>${fn:length(plano.procedimentos) - 1} <c:if test="${fn:length(plano.procedimentos) > 1}">( <c:forEach items="${plano.procedimentos}" var="procedimento"><c:if test="${procedimento.tratamento.id != tratamento.id}">${procedimento.tratamento.nome}; </c:if></c:forEach>)</c:if></td>						
					</tr>
				</c:forEach>
			</c:forEach>
			<tr class="total">
				<td colspan="2">Total</td>
				<td colspan="1" style="text-align: right;">${totalPlanos} planos</td>				
			</tr>			
		</table>

  	</body>
</html>