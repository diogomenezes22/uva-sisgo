package sisgo.dao;

import java.util.Collection;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import sisgo.model.Paciente;

public class PacienteDao {

	@Inject
	private Session session;
	
	public Paciente carregar(Integer id) {
		return (Paciente) session.get(Paciente.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Paciente> listar() {
		return (Collection<Paciente>) session.createCriteria(Paciente.class).addOrder(Order.asc("nome")).list();
	}
	
	public void salvar(Paciente paciente) {
	
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(paciente);
			tx.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	
	public boolean excluir(Paciente paciente) {
		
		Transaction tx = session.beginTransaction();
		try {
			session.delete(paciente);
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
