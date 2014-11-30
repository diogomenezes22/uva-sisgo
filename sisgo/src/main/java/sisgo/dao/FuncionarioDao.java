package sisgo.dao;

import java.util.Collection;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import sisgo.model.Funcionario;

public class FuncionarioDao {

	@Inject
	private Session session;
	
	public Funcionario carregar(Integer id) {
		return (Funcionario) session.get(Funcionario.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Funcionario> listar() {
		return (Collection<Funcionario>) session.createCriteria(Funcionario.class).addOrder(Order.asc("nome")).list();
	}
	
	public boolean salvar(Funcionario funcionario) {
		
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(funcionario);
			tx.commit();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}
	}
	
	public boolean excluir(Funcionario funcionario) {
		
		Transaction tx = session.beginTransaction();
		try {
			session.delete(funcionario);
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
