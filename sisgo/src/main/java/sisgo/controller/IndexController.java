package sisgo.controller;

import java.util.Collection;

import javax.inject.Inject;

import sisgo.dao.ConsultaDao;
import sisgo.model.Consulta;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class IndexController {

	@Inject
	private Result result;
	@Inject
	private ConsultaDao consultaDao;	
	
	@Path("/principal")
	public void index() {
		Collection<Consulta> consultasDoDia = consultaDao.listarConsultasDoDia();
		result.include("consultasDoDia", consultasDoDia);
	}
	
}