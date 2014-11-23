package sisgo.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import sisgo.model.Usuario;

public class LoginDao {

	@Inject
	private Session session;
	
	public Usuario carregarUsuario(String login, String senha) {
		return (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("login", login))
				.add(Restrictions.eq("senha", senha))
				.uniqueResult();
	}
	
}
