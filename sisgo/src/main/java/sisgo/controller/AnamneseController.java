package sisgo.controller;

import java.util.Calendar;

import javax.inject.Inject;

import sisgo.dao.AnamneseDao;
import sisgo.dao.PacienteDao;
import sisgo.model.Anamnese;
import sisgo.model.Paciente;
import sisgo.util.Permissao;
import sisgo.util.ValidaSessao;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Path("/anamnese")
@Controller
public class AnamneseController {

	@Inject
	private Result result;
	@Inject
	private AnamneseDao anamneseDao;
	@Inject
	private PacienteDao pacienteDao;	


	public void form() {}			

	@ValidaSessao(Permissao.DENTISTA)
	@Path("/paciente/{paciente.id}/form")
	public void form(Paciente paciente) {
		result.include("paciente", pacienteDao.carregar(paciente.getId()));
		result.redirectTo(this).form();
	}
	
	@ValidaSessao(Permissao.DENTISTA)
	@Path("/form/{anamnese.id}")
	public void form(Anamnese anamnese) {
		anamnese = anamneseDao.carregar(anamnese.getId());
		result.include("paciente", anamnese.getPaciente());
		result.include("anamnese", anamnese);
		result.redirectTo(this).form();
	}	
	
	@ValidaSessao(Permissao.DENTISTA)
	@Path("/listar/{paciente.id}")
	public void listar(Paciente paciente) {
		result.include("paciente", pacienteDao.carregar(paciente.getId()));
		result.include("anamneses", anamneseDao.listar(paciente));
	}	
	
	@Path("/salvar")
	public void salvar(Anamnese anamnese) {
		prepareSave(anamnese);
		anamneseDao.salvar(anamnese);		
		result.include("mensagem", "Anamnese salva com sucesso!");
		result.redirectTo(this).listar(anamnese.getPaciente());
	}
	
	@Path("/excluir/{id}")
	public void excluir(Integer id) {
		Anamnese anamnese = anamneseDao.carregar(id);
		Paciente paciente = anamnese.getPaciente();
		anamneseDao.excluir(anamnese);
		result.include("mensagem", "Anamnese excluída com sucesso!");
		result.redirectTo(this).listar(paciente);
	}
	
	private void prepareSave(Anamnese anamnese) {
		anamnese.setDataPreenchimento(Calendar.getInstance().getTime());
	}

}