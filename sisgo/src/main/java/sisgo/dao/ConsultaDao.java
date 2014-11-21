package sisgo.dao;

import java.util.Collection;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import sisgo.model.Consulta;

public class ConsultaDao {

	@Inject
	private Session session;
	
	public Consulta carregar(Integer id) {
		return (Consulta) session.get(Consulta.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Consulta> listar() {
		return (Collection<Consulta>) session.createCriteria(Consulta.class).addOrder(Order.asc("id")).list();
	}
	
	public void salvar(Consulta consulta) {
		
		try {
			session.save(consulta);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean atualizar(Consulta consulta) {
		
		try {
			session.update(consulta);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}	
	
	public boolean excluir(Consulta consulta) {
		
		try {
			session.delete(consulta);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}	
}
