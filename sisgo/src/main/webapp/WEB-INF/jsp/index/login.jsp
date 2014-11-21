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
	    <link href="${rootPath}/resources/css/login.css" rel="stylesheet">

  	</head>

  	<body>

		<%@ include file="../include/topo-login.jsp" %>

    	<div class="container">

      		<form action="${rootPath}/principal" class="form-signin" role="form">
        		<h2 class="form-signin-heading">Faça seu login</h2>
        		<input type="text" class="form-control" placeholder="Login" required autofocus>
        		<input type="password" class="form-control" placeholder="Senha" required>
        		<button class="btn btn-lg btn-success btn-block" type="submit">Acessar</button>
      		</form>

    	</div>

  	</body>
</html>
