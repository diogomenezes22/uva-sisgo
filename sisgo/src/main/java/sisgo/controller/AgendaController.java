package sisgo.controller;

import java.util.Collection;

import javax.inject.Inject;

import sisgo.dao.ConsultaDao;
import sisgo.dao.DentistaDao;
import sisgo.dao.PacienteDao;
import sisgo.model.Consulta;
import sisgo.model.Dentista;
import sisgo.model.Paciente;
import sisgo.util.Permissao;
import sisgo.util.SessaoUsuario;
import sisgo.util.TransformadorConsultaVO;
import sisgo.util.TransformadorSugestaoDentista;
import sisgo.util.TransformadorSugestaoPaciente;
import sisgo.util.ValidaSessao;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Path("/agenda")
@Controller
public class AgendaController {

	@Inject
	private Result result;
	@Inject
	private SessaoUsuario sessaoUsuario;	
	@Inject
	private ConsultaDao consultaDao;
	@Inject
	private PacienteDao pacienteDao;
	@Inject
	private DentistaDao dentistaDao;
	@Inject
	private TransformadorConsultaVO transformadorConsultaVO;	
	@Inject
	private TransformadorSugestaoPaciente transformadorSugestaoPaciente;
	@Inject
	private TransformadorSugestaoDentista transformadorSugestaoDentista;	
	
	@ValidaSessao(Permissao.FUNCIONARIO)
	@Path("/")
	public void agenda() {}

	@Path("/carregar-consultas")
	public void carregarConsultas() {
		Collection<Consulta> consultas = consultaDao.listar();
		result.use(Results.json()).withoutRoot().from(transformadorConsultaVO.transformar(consultas)).serialize();
	}
	
	@Path("/carregar-consulta/{consulta.id}")
	public void carregarConsultas(Consulta consulta) {
		consulta = consultaDao.carregar(consulta.getId());
		result.use(Results.json()).withoutRoot().from(consulta).include("usuario").serialize();
	}		
	
	@Path("/carregar-pacientes")
	public void carregarPacientes() {
		Collection<Paciente> pacientes = pacienteDao.listar();
		result.use(Results.json()).withoutRoot().from(transformadorSugestaoPaciente.transformar(pacientes)).serialize();
	}
	
	@Path("/carregar-dentistas")
	public void carregarDentistas() {
		Collection<Dentista> dentistas = dentistaDao.listar();
		result.use(Results.json()).withoutRoot().from(transformadorSugestaoDentista.transformar(dentistas)).serialize();
	}	

	@Path("/salvar")
	public void salvar(Consulta consulta) {
		prepareSave(consulta);
		consultaDao.salvar(consulta);
		result.use(Results.json()).withoutRoot().from(consulta.getId()).serialize();
	}

	@Path("/atualizar")
	public void atualizar(Consulta consulta) {
		prepareSave(consulta);
		boolean atualizado = consultaDao.atualizar(consulta);
		result.use(Results.json()).withoutRoot().from(atualizado).serialize();
	}	
	
	@Path("/excluir/{consulta.id}")
	public void excluir(Consulta consulta) {
		consulta = consultaDao.carregar(consulta.getId());
		result.use(Results.json()).withoutRoot().from(consultaDao.excluir(consulta)).serialize();
	}	
	
	private void prepareSave(Consulta consulta) {
		consulta.setUsuario(sessaoUsuario.getUsuario());		
	}	

}