package sisgo.controller;

import javax.inject.Inject;

import sisgo.dao.LoginDao;
import sisgo.model.Usuario;
import sisgo.util.SessaoUsuario;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class LoginController {

	@Inject
	private Result result;
	@Inject
	private SessaoUsuario usuarioSessao;	
	@Inject
	private LoginDao loginDao;	

	@Path("/")
	public void login() {}
	
	@Path("/logar")
	public void logar(String login, String senha) {
		usuarioSessao.setUsuario(null);
		Usuario usuario = loginDao.carregarUsuario(login, senha);
		if(usuario == null) {
			result.include("erro", "Usuario nao encontrado!");
			result.redirectTo(this).login();
		}
		else {
			usuarioSessao.setUsuario(usuario);
			result.redirectTo(IndexController.class).index();
		}
	}
	
}