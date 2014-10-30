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
    	<script src="${rootPath}/resources/js/dentista.js"></script>
	</head>

	<body>

		<%@ include file="../include/topo.jsp" %>
		<input type="hidden" id="pagina" value="paginaDentista">

		<div class="container">
			<div class="formHeader">
				<h3>Listagem de Dentista</h3>
			</div>
			<div class="mensagemSucesso">${mensagem}</div>
			<table id="tabelaDentista" class="table table-striped table-bordered dataTable no-footer">
				<thead>
					<th>Nome</th>
					<th>CRO</th>
					<th>Login</th>
					<th>Data de Nascimento</th>
					<th>Celular</th>
					<th>Admin</th>
					<th>Acoes</th>
				</thead>
				<tbody>
					<c:forEach items="${dentistas}" var="dentista">
						<tr>
							<td>${dentista.nome}</td>
							<td>${dentista.cro}</td>
							<td>${dentista.login}</td>
							<td><fmt:formatDate value="${dentista.dataNascimento}" pattern="dd/MM/yyyy" /></td>
							<td>${dentista.celular}</td>
							<td><c:choose><c:when test="${dentista.admin}">Sim</c:when><c:otherwise>Nao</c:otherwise></c:choose></td>						
							<td class="acao">
								<form class="editar" action="${rootPath}/dentista/form/${dentista.id}" method="get"><input type="image" src="${rootPath}/resources/images/editar.gif" title="Editar Dentista"></form>
								<form class="excluir" action="${rootPath}/dentista/excluir/${dentista.id}" method="get"><input type="image" src="${rootPath}/resources/images/excluir.gif" title="Excluir Dentista"></form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>			
    	</div>

  	</body>
</html>