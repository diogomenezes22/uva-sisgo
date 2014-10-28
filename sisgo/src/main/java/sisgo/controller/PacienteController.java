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

	@Path("/form")
	public void form() {
		result.include("estadosCivis", estadoCivilDao.list());
	}
	
	@Path("/form/{id}")
	public void editar(Integer id) {
		result.include("paciente", pacienteDao.load(id));
		result.redirectTo(this).form();
	}
	
	@Path("/salvar")
	public void salvar(Paciente paciente) {
		pacienteDao.salvar(paciente);
		result.redirectTo(this).form();
	}
	
}