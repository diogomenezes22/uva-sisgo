package sisgo.dao;

import java.util.Collection;

import javax.inject.Inject;

import org.hibernate.Session;
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
	
	public void salvar(Funcionario funcionario) {
		
		try {
			session.saveOrUpdate(funcionario);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Funcionario funcionario) {
		
		try {
			session.delete(funcionario);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}	
}
