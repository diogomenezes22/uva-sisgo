package sisgo.dao;

import java.util.Collection;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import sisgo.model.Dentista;

public class DentistaDao {

	@Inject
	private Session session;
	
	public Dentista carregar(Integer id) {
		return (Dentista) session.get(Dentista.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Dentista> listar() {
		return (Collection<Dentista>) session.createCriteria(Dentista.class).addOrder(Order.asc("nome")).list();
	}
	
	public void salvar(Dentista dentista) {
		
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(dentista);
			tx.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	
	public boolean excluir(Dentista dentista) {
		
		Transaction tx = session.beginTransaction();
		try {
			session.delete(dentista);
			tx.commit();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}
	}	
}
