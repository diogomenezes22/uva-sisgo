package sisgo.controller;

import javax.inject.Inject;

import sisgo.dao.DentistaDao;
import sisgo.model.Dentista;
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

	
	@Path("/listar")
	public void listar() {
		result.include("dentistas", dentistaDao.listar());
	}	
	
	@Path("/form")
	public void form() {}
	
	@Path("/form/{id}")
	public void editar(Integer id) {
		result.include("dentista", dentistaDao.carregar(id));
		result.redirectTo(this).form();
	}
	
	@Path("/salvar")
	public void salvar(Dentista dentista) {
		dentistaDao.salvar(dentista);
		result.include("mensagem", "Dentista salvo com sucesso!");
		result.redirectTo(this).listar();
	}

	@Path("/excluir/{id}")
	public void excluir(Integer id) {
		Dentista dentista = dentistaDao.carregar(id);
		dentistaDao.excluir(dentista);
		result.include("mensagem", "Dentista excluído com sucesso!");
		result.redirectTo(this).listar();
	}
	
}