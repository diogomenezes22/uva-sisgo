package sisgo.dao;

import java.util.Collection;

import javax.inject.Inject;

import org.hibernate.Session;

import sisgo.model.EstadoCivil;

public class EstadoCivilDao {

	@Inject
	private Session session;
	
	@SuppressWarnings("unchecked")
	public Collection<EstadoCivil> listar() {
		return (Collection<EstadoCivil>) session.createCriteria(EstadoCivil.class).list();
	}

}
