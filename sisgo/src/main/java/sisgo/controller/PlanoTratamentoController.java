package sisgo.controller;

import javax.inject.Inject;

import sisgo.dao.PacienteDao;
import sisgo.dao.PlanoTratamentoDao;
import sisgo.dao.TratamentoDao;
import sisgo.model.Paciente;
import sisgo.model.PlanoTratamento;
import sisgo.model.Procedimento;
import sisgo.util.Permissao;
import sisgo.util.ValidaSessao;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Path("/plano-tratamento")
@Controller
public class PlanoTratamentoController {

	@Inject
	private Result result;
	@Inject
	private PlanoTratamentoDao planoTratamentoDao;
	@Inject
	private TratamentoDao tratamentoDao;	
	@Inject
	private PacienteDao pacienteDao;	


	public void form() {
		result.include("tratamentos", tratamentoDao.listar());
	}			

	@ValidaSessao(Permissao.DENTISTA)	
	@Path("/paciente/{paciente.id}/form")
	public void form(Paciente paciente) {
		result.include("paciente", pacienteDao.carregar(paciente.getId()));
		result.redirectTo(this).form();
	}
	
	@ValidaSessao(Permissao.DENTISTA)
	@Path("/form/{planoTratamento.id}")
	public void form(PlanoTratamento planoTratamento) {
		planoTratamento = planoTratamentoDao.carregar(planoTratamento.getId());
		result.include("paciente", planoTratamento.getPaciente());
		result.include("planoTratamento", planoTratamento);
		result.redirectTo(this).form();
	}	
	
	@ValidaSessao(Permissao.DENTISTA)
	@Path("/listar/{paciente.id}")
	public void listar(Paciente paciente) {
		result.include("paciente", pacienteDao.carregar(paciente.getId()));
		result.include("planosDeTratamento", planoTratamentoDao.listar(paciente));
	}	
	
	@Path("/salvar")
	public void salvar(PlanoTratamento planoTratamento) {
		prepareSave(planoTratamento);
		planoTratamentoDao.salvar(planoTratamento);		
		result.include("mensagem", "Plano de Tratamento salvo com sucesso!");
		result.redirectTo(this).listar(planoTratamento.getPaciente());
	}
	
	@ValidaSessao(Permissao.DENTISTA)
	@Path("/excluir/{id}")
	public void excluir(Integer id) {
		PlanoTratamento planoTratamento = planoTratamentoDao.carregar(id);
		Paciente paciente = planoTratamento.getPaciente();
		boolean excluido = planoTratamentoDao.excluir(planoTratamento);
		if(excluido)
			result.include("mensagem", "Plano de Tratamento excluído com sucesso!");
		else
			result.include("erro", "Nao e possivel excluir este plano de tratamento!");
		result.redirectTo(this).listar(paciente);
	}	
	
	
	private void prepareSave(PlanoTratamento planoTratamento) {
		if(planoTratamento.getProcedimentos() != null)
			for (Procedimento procedimento : planoTratamento.getProcedimentos())
				procedimento.setPlanoTratamento(planoTratamento);
	}		
}