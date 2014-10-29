package sisgo.dao;

import java.util.Collection;

import javax.inject.Inject;

import org.hibernate.Session;
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
		
		try {
			session.saveOrUpdate(tratamento);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Tratamento tratamento) {
		
		try {
			session.delete(tratamento);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}		
}
