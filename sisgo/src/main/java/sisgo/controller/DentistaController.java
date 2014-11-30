package sisgo.controller;

import javax.inject.Inject;

import sisgo.dao.DentistaDao;
import sisgo.model.Dentista;
import sisgo.util.Permissao;
import sisgo.util.ValidaSessao;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Path("/dentista")
@Controller
public class DentistaController {

	@Inject
	private Result result;
	@Inject
	private DentistaDao dentistaDao;	

	
	@ValidaSessao(Permissao.ADMIN)
	@Path("/listar")
	public void listar() {
		result.include("dentistas", dentistaDao.listar());
	}	
	
	@ValidaSessao(Permissao.ADMIN)
	@Path("/form")
	public void form() {}
	
	@ValidaSessao(Permissao.ADMIN)
	@Path("/form/{id}")
	public void editar(Integer id) {
		result.include("dentista", dentistaDao.carregar(id));
		result.redirectTo(this).form();
	}
	
	@Path("/salvar")
	public void salvar(Dentista dentista) {
		boolean salvo = dentistaDao.salvar(dentista);
		if(salvo)
			result.include("mensagem", "Dentista salvo com sucesso!");
		else
			result.include("erro", "Nao e possivel salvar este dentista!");
		result.redirectTo(this).listar();
	}

	@ValidaSessao(Permissao.ADMIN)
	@Path("/excluir/{id}")
	public void excluir(Integer id) {
		Dentista dentista = dentistaDao.carregar(id);
		boolean excluido = dentistaDao.excluir(dentista);
		if(excluido)
			result.include("mensagem", "Dentista excluído com sucesso!");
		else
			result.include("erro", "Nao e possivel excluir este dentista!");
		result.redirectTo(this).listar();
	}
	
}