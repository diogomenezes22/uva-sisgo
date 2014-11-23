<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	</head>

	<body>

		<%@ include file="../include/topo.jsp" %>
		<input type="hidden" id="pagina" value="paginaPrincipal">

		<div class="container">
			<div class="template">
				<div id="bemVindo">
					<p class="lead">Olá, ${sessaoUsuario.usuario.nome}!</p>
					<h1>Bem vindo ao sistema odontológico SISGO</h1>
					<p class="lead">
						<c:choose>
							<c:when test="${empty consultasDoDia}">
								Nao temos nenhuma consulta marcada para hoje!
							</c:when>
							<c:otherwise>
								Hoje temos ${fn:length(consultasDoDia)} consultas marcadas!	
							</c:otherwise>
						</c:choose>						
					</p>
				</div>
			</div>
    	</div>

  	</body>
</html>
