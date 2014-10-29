package sisgo.controller;

import javax.inject.Inject;

import sisgo.dao.FuncionarioDao;
import sisgo.model.Funcionario;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Path("/funcionario")
@Controller
public class FuncionarioController {

	@Inject
	private Result result;
	@Inject
	private FuncionarioDao funcionarioDao;	

	
	@Path("/listar")
	public void listar() {
		result.include("funcionarios", funcionarioDao.listar());
	}	
	
	@Path("/form")
	public void form() {}
	
	@Path("/form/{id}")
	public void editar(Integer id) {
		result.include("funcionario", funcionarioDao.carregar(id));
		result.redirectTo(this).form();
	}
	
	@Path("/salvar")
	public void salvar(Funcionario funcionario) {
		funcionarioDao.salvar(funcionario);
		result.include("mensagem", "Funcionario salvo com sucesso!");
		result.redirectTo(this).listar();
	}

	@Path("/excluir/{id}")
	public void excluir(Integer id) {
		Funcionario funcionario = funcionarioDao.carregar(id);
		funcionarioDao.excluir(funcionario);
		result.include("mensagem", "Funcionario excluído com sucesso!");
		result.redirectTo(this).listar();
	}
	
}