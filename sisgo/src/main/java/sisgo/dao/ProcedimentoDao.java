package sisgo.dao;

import java.util.Collection;

import javax.inject.Inject;

import org.hibernate.Session;

import sisgo.model.Procedimento;

public class ProcedimentoDao {

	@Inject
	private Session session;
	
	@SuppressWarnings("unchecked")
	public Collection<Procedimento> carregar() {
		return (Collection<Procedimento>) session.createCriteria(Procedimento.class).list();
	}
		
}
