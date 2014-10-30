package sisgo.dao;

import java.util.Collection;

import javax.inject.Inject;

import org.hibernate.Session;
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
	public Collection<PlanoTratamento> listar(Paciente paciente) {
		return (Collection<PlanoTratamento>) session.createCriteria(PlanoTratamento.class)
				.add(Restrictions.eq("paciente.id", paciente.getId()))
				.addOrder(Order.desc("dataInicial"))
				.list();
	}
	
	public void salvar(PlanoTratamento planoTratamento) {
		
		try {
			session.merge(planoTratamento);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(PlanoTratamento planoTratamento) {
		
		try {
			session.delete(planoTratamento);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}	
}
