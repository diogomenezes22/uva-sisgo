package sisgo.util;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import sisgo.model.Usuario;

@SessionScoped
@Named("sessaoUsuario")
public class SessaoUsuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	
	private Permissao nivelPermissao;

	public Usuario getUsuario() {
		return usuario;
	}

	public Permissao getNivelPermissao() {
		return nivelPermissao;
	}

	public void logar(Usuario usuario, Permissao nivelPermissao) {
		this.usuario = usuario;
		this.nivelPermissao = nivelPermissao;
	}
	
	public boolean logado() {
		return usuario != null;
	}
	
	public void deslogar() {
		this.usuario = null;
		this.nivelPermissao = null;
	}	
	
}
