package sisgo.dao;

import java.util.Collection;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import sisgo.model.Paciente;
import sisgo.model.Anamnese;

public class AnamneseDao {

	@Inject
	private Session session;
	
	public Anamnese carregar(Integer id) {
		return (Anamnese) session.get(Anamnese.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Anamnese> listar(Paciente paciente) {
		return (Collection<Anamnese>) session.createCriteria(Anamnese.class)
				.add(Restrictions.eq("paciente.id", paciente.getId()))
				.addOrder(Order.desc("dataPreenchimento"))
				.list();
	}
	
	public void salvar(Anamnese anamnese) {
		
		Transaction tx = session.beginTransaction();
		
		try {
			session.merge(anamnese);
			tx.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	
	public void excluir(Anamnese anamnese) {
		
		Transaction tx = session.beginTransaction();
		try {
			session.delete(anamnese);
			tx.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}	
}
