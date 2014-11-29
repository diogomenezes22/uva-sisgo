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
    	<script src="${rootPath}/resources/js/relatorioConsultasMensais.js"></script>
	</head>

	<body>

		<c:set var="totalConsultas" value="0"></c:set>

		<table>
			<tr>
				<td colspan="4" class="cabecalho">
					<div class="logo"><img src="${rootPath}/resources/images/logoSisgo.png" />SISGO</div>
					<div class="nomeRelatorio">Relatório de Consultas Mensais</div>
				</td>
			</tr>
			<tr>
				<td colspan="4" class="cabecalho2">					
					<div class="emissao">Emitido em <fmt:formatDate value="${dataEmissao}" pattern="dd/MM/yyyy 'às' HH:mm" /> por ${sessaoUsuario.usuario.nome}</div>
				</td>
			</tr>				
			<c:forEach items="${relatorio.meses}" var="mes">
				<c:set var="totalConsultas" value="${totalConsultas + fn:length(mes.consultas)}"></c:set>
				<tr class="linhaAgrupamento">
					<td colspan="2">${mes.nome} / ${ano}</td>
					<td colspan="2" style="text-align: right;">${fn:length(mes.consultas)} consultas</td>
				</tr>
				<tr class="linhaTh">
					<td>Data/Hora</td>
					<td>Paciente</td>
					<td>Dentista</td>
					<td>Marcado Por</td>
				</tr>	
				<c:forEach items="${mes.consultas}" var="consulta">
					<tr>
						<td><fmt:formatDate value="${consulta.dataInicial}" pattern="dd/MM/yyyy HH:mm" /></td>
						<td>${consulta.paciente.nome}</td>
						<td>${consulta.dentista.nome}</td>
						<td>${consulta.usuario.nome}</td>
					</tr>
					<tr>
						<td colspan="4"><c:if test="${not empty consulta.obs}">--</c:if>${consulta.obs}</td>
					</tr>					
				</c:forEach>
			</c:forEach>
			<tr class="total">
				<td colspan="2">Total</td>
				<td colspan="2" style="text-align: right;">${totalConsultas} consultas</td>				
			</tr>			
		</table>

  	</body>
</html>