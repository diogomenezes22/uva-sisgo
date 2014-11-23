package sisgo.controller;

import javax.inject.Inject;

import sisgo.dao.LoginDao;
import sisgo.model.Dentista;
import sisgo.model.Funcionario;
import sisgo.model.Usuario;
import sisgo.util.Permissao;
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
		usuarioSessao.deslogar();
		Usuario usuario = loginDao.carregarUsuario(login, senha);
		if(usuario == null)
			usuarioNaoEncontrado();
		else {
			logarUsuario(usuario);
			result.redirectTo(IndexController.class).index();
		}

	}
	
	@Path("/deslogar")
	public void deslogar() {
		usuarioSessao.deslogar();
		result.redirectTo(this).login();
	}	

	private void logarUsuario(Usuario usuario) {
		
		if(usuario instanceof Funcionario)
			usuarioSessao.logar(usuario, Permissao.FUNCIONARIO);
		else {
			if(((Dentista)usuario).isAdmin())
				usuarioSessao.logar(usuario, Permissao.ADMIN);
			else
				usuarioSessao.logar(usuario, Permissao.DENTISTA);
		}

	}

	private void usuarioNaoEncontrado() {
		result.include("erro", "Usuario nao encontrado!");
		result.redirectTo(this).login();
	}
	
}