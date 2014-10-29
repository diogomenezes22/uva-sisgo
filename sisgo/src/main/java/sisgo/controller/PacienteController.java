package sisgo.controller;

import javax.inject.Inject;

import sisgo.dao.EstadoCivilDao;
import sisgo.dao.PacienteDao;
import sisgo.model.Paciente;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Path("/paciente")
@Controller
public class PacienteController {

	@Inject
	private Result result;
	@Inject
	private PacienteDao pacienteDao;
	@Inject
	private EstadoCivilDao estadoCivilDao;	

	
	@Path("/listar")
	public void listar() {
		result.include("pacientes", pacienteDao.listar());
	}	
	
	@Path("/form")
	public void form() {
		result.include("estadosCivis", estadoCivilDao.listar());
	}
	
	@Path("/form/{id}")
	public void editar(Integer id) {
		result.include("paciente", pacienteDao.carregar(id));
		result.redirectTo(this).form();
	}
	
	@Path("/salvar")
	public void salvar(Paciente paciente) {
		pacienteDao.salvar(paciente);
		result.include("mensagem", "Paciente salvo com sucesso!");
		result.redirectTo(this).listar();
	}

	@Path("/excluir/{id}")
	public void excluir(Integer id) {
		Paciente paciente = pacienteDao.carregar(id);
		pacienteDao.excluir(paciente);
		result.include("mensagem", "Paciente excluído com sucesso!");
		result.redirectTo(this).listar();
	}
	
}