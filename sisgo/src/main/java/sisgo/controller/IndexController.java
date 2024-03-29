package sisgo.controller;

import java.util.Collection;

import javax.inject.Inject;

import sisgo.dao.ConsultaDao;
import sisgo.model.Consulta;
import sisgo.util.Permissao;
import sisgo.util.ValidaSessao;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class IndexController {

	@Inject
	private Result result;
	@Inject
	private ConsultaDao consultaDao;	
	
	@ValidaSessao(Permissao.FUNCIONARIO)
	@Path("/principal")
	public void index() {
		Collection<Consulta> consultasDoDia = consultaDao.listarConsultasDoDia();
		result.include("consultasDoDia", consultasDoDia);
	}
	
}