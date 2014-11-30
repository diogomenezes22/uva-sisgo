package sisgo.dao;

import java.util.Collection;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import sisgo.model.Paciente;
import sisgo.model.PlanoTratamento;

public class PlanoTratamentoDao {

	@Inject
	private Session session;
	
	public PlanoTratamento carregar(Integer id) {
		return (PlanoTratamento) session.get(PlanoTratamento.class, id);
	}

	@SuppressWarnings("unchecked")
	public Collection<PlanoTratamento> listar() {
		return (Collection<PlanoTratamento>) session.createCriteria(PlanoTratamento.class).list();
	}	
	
	@SuppressWarnings("unchecked")
	public Collection<PlanoTratamento> listar(Paciente paciente) {
		return (Collection<PlanoTratamento>) session.createCriteria(PlanoTratamento.class)
				.add(Restrictions.eq("paciente.id", paciente.getId()))
				.addOrder(Order.desc("dataInicial"))
				.list();
	}
	
	public boolean salvar(PlanoTratamento planoTratamento) {
		
		Transaction tx = session.beginTransaction();
		try {
			session.merge(planoTratamento);
			tx.commit();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}
	}
	
	public boolean excluir(PlanoTratamento planoTratamento) {
		
		Transaction tx = session.beginTransaction();
		try {
			session.delete(planoTratamento);
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
