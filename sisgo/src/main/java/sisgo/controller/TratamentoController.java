package sisgo.controller;

import javax.inject.Inject;

import sisgo.dao.TratamentoDao;
import sisgo.model.Tratamento;
import sisgo.util.Permissao;
import sisgo.util.ValidaSessao;
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

	
	@ValidaSessao(Permissao.ADMIN)
	@Path("/listar")
	public void listar() {
		result.include("tratamentos", tratamentoDao.listar());
	}	
	
	@ValidaSessao(Permissao.ADMIN)
	@Path("/form")
	public void form() {}
	
	@ValidaSessao(Permissao.ADMIN)
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

	@ValidaSessao(Permissao.ADMIN)
	@Path("/excluir/{id}")
	public void excluir(Integer id) {
		Tratamento tratamento = tratamentoDao.carregar(id);
		boolean excluido = tratamentoDao.excluir(tratamento);
		if(excluido)
			result.include("mensagem", "Tratamento excluído com sucesso!");
		else
			result.include("erro", "Nao e possivel excluir este tratamento!");
		result.redirectTo(this).listar();
	}
	
}