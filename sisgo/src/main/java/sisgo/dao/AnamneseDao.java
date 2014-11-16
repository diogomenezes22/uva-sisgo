package sisgo.dao;

import java.util.Collection;

import javax.inject.Inject;

import org.hibernate.Session;
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
		
		try {
			session.merge(anamnese);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Anamnese anamnese) {
		
		try {
			session.delete(anamnese);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}	
}
