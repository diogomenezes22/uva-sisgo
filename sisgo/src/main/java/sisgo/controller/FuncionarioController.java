package sisgo.controller;

import javax.inject.Inject;

import sisgo.dao.FuncionarioDao;
import sisgo.model.Funcionario;
import sisgo.util.Permissao;
import sisgo.util.ValidaSessao;
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

	
	@ValidaSessao(Permissao.ADMIN)
	@Path("/listar")
	public void listar() {
		result.include("funcionarios", funcionarioDao.listar());
	}	
	
	@ValidaSessao(Permissao.ADMIN)
	@Path("/form")
	public void form() {}
	
	@ValidaSessao(Permissao.ADMIN)
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

	@ValidaSessao(Permissao.ADMIN)
	@Path("/excluir/{id}")
	public void excluir(Integer id) {
		Funcionario funcionario = funcionarioDao.carregar(id);
		boolean excluido = funcionarioDao.excluir(funcionario);
		if(excluido)
			result.include("mensagem", "Funcionario excluído com sucesso!");
		else
			result.include("erro", "Nao e possivel excluir este funcionario!");
		result.redirectTo(this).listar();
	}
	
}