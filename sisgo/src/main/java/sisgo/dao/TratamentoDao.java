package sisgo.dao;

import java.util.Collection;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import sisgo.model.Tratamento;

public class TratamentoDao {

	@Inject
	private Session session;
	
	public Tratamento carregar(Integer id) {
		return (Tratamento) session.get(Tratamento.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Tratamento> listar() {
		return (Collection<Tratamento>) session.createCriteria(Tratamento.class).addOrder(Order.asc("nome")).list();
	}
	
	public void salvar(Tratamento tratamento) {
		
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(tratamento);
			tx.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	
	public boolean excluir(Tratamento tratamento) {
		
		Transaction tx = session.beginTransaction();
		try {
			session.delete(tratamento);
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
