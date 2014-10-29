package sisgo.dao;

import java.util.Collection;

import javax.inject.Inject;

import org.hibernate.Session;
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
		
		try {
			session.saveOrUpdate(paciente);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
