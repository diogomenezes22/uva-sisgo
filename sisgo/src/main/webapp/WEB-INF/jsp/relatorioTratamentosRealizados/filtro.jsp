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
    	<link href="${rootPath}/resources/css/relatorio.css" rel="stylesheet">
    	<script src="${rootPath}/resources/js/highcharts.js"></script>
    	<script src="${rootPath}/resources/js/relatorioTratamentosRealizados.js"></script>
	</head>

	<body>

		<%@ include file="../include/topo.jsp" %>
		<input type="hidden" id="pagina" value="paginaRelatorio">

		<div class="container">
			<div class="formHeader">
				<h3>Relatório de Tratamentos Realizados</h3>
			</div>
			<form class="form-inline" role="form">
  				<div class="form-group">
    				<div class="input-group">
      					<label class="sr-only" for="ano">Ano</label>
						<select id="ano" name="ano" class="form-control">
							<c:forEach items="${anos}" var="ano">
								<option value="${ano}">${ano}</option>
							</c:forEach>
						</select>
    				</div>
  				</div>
  				<button type="button" id="gerarRelatorioSintetico" class="btn btn-success">Gerar</button>
			</form>			

			<div id="graficoRelatorio" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto">				
			</div>
			<div class="divBotaoGerarRelatorioAnalitico">
				<button type="button" id="gerarRelatorioAnalitico" class="btn btn-success botaoGerarRelatorioAnalitico">Gerar Relatorio Analitico</button>
			</div>						
    	</div>

  	</body>
</html>