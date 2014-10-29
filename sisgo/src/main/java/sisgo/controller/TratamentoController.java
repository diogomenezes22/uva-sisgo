package sisgo.controller;

import javax.inject.Inject;

import sisgo.dao.TratamentoDao;
import sisgo.model.Tratamento;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Path("/tratamento")
@Controller
public class TratamentoController {

	@Inject
	private Result result;
	@Inject
	private TratamentoDao tratamentoDao;

	
	@Path("/listar")
	public void listar() {
		result.include("tratamentos", tratamentoDao.listar());
	}	
	
	@Path("/form")
	public void form() {}
	
	@Path("/form/{id}")
	public void editar(Integer id) {
		result.include("tratamento", tratamentoDao.carregar(id));
		result.redirectTo(this).form();
	}
	
	@Path("/salvar")
	public void salvar(Tratamento tratamento) {
		tratamentoDao.salvar(tratamento);
		result.include("mensagem", "Tratamento salvo com sucesso!");
		result.redirectTo(this).listar();
	}

	@Path("/excluir/{id}")
	public void excluir(Integer id) {
		Tratamento tratamento = tratamentoDao.carregar(id);
		tratamentoDao.excluir(tratamento);
		result.include("mensagem", "Tratamento excluído com sucesso!");
		result.redirectTo(this).listar();
	}
	
}