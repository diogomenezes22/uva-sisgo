package sisgo.dao;

import javax.inject.Inject;

import org.hibernate.Session;

import sisgo.model.Paciente;

public class PacienteDao {

	@Inject
	private Session session;
	
	public Paciente load(Integer id) {
		return (Paciente) session.get(Paciente.class, id);
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
