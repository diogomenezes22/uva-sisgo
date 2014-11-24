<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<input type="hidden" id="rootPath" value="${rootPath}">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">SISGO</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="pagina paginaPrincipal active"><a href="${rootPath}/principal">Home</a></li>
				<li class="pagina paginaAgenda"><a href="${rootPath}/agenda/">Agenda</a></li>
				<li class="pagina paginaPaciente"><a href="${rootPath}/paciente/listar">Pacientes</a></li>
				<li class="pagina paginaDentista"><a href="${rootPath}/dentista/listar">Dentistas</a></li>
				<li class="pagina paginaFuncionario"><a href="${rootPath}/funcionario/listar">Funcionarios</a></li>
				<li class="pagina paginaTratamento"><a href="${rootPath}/tratamento/listar">Tratamentos</a></li>
				<li class="dropdown pagina paginaRelatorios">
          			<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Relatorios <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
            			<li><a href="${rootPath}/relatorio/consultas-mensais">Consultas Mensais</a></li>
            			<li><a href="${rootPath}/relatorio/tratamentos-realizados">Tratamentos Realizados</a></li>
          			</ul>
        		</li>          			
				<li><a href="${rootPath}/deslogar">Deslogar</a></li>
			</ul>
		</div>
	</div>
</div>
