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
    	<script src="${rootPath}/resources/js/tratamento.js"></script>
	</head>

	<body>

		<%@ include file="../include/topo.jsp" %>
		<input type="hidden" id="pagina" value="paginaTratamento">

		<div class="container">
			<div class="formHeader">
				<h3>Formulario de Tratamento</h3>
			</div>
			<form id="tratamentoForm" action="${rootPath}/tratamento/salvar" method="post" class="form-horizontal" role="form">
				<input type="hidden" id="id" name="tratamento.id" value="${tratamento.id}">
				<c:if test="${not empty tratamento.id}">
					<div class="form-group">
						<label class="col-sm-2 control-label">Codigo</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" value="${tratamento.id}" readonly>
						</div>
					</div>				
				</c:if>	
				<div class="form-group">
					<label for="nome" class="col-sm-2 control-label">Nome</label>
					<div class="col-sm-10">
						<input type="text" id="nome" name="tratamento.nome" class="form-control" placeholder="Nome" value="${tratamento.nome}" required>
					</div>
				</div>
				<div class="form-group">
					<label for="valor" class="col-sm-2 control-label">Valor</label>
					<div class="col-sm-10">
						<input type="text" id="valor" name="tratamento.valor" class="form-control" placeholder="Valor" value="${tratamento.valor}" required>
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