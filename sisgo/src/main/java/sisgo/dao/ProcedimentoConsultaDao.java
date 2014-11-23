package sisgo.dao;

import java.util.Collection;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import sisgo.model.Consulta;
import sisgo.model.ProcedimentoConsulta;

public class ProcedimentoConsultaDao {

	@Inject
	private Session session;
	
	public ProcedimentoConsulta carregar(Integer id) {
		return (ProcedimentoConsulta) session.get(ProcedimentoConsulta.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public Collection<ProcedimentoConsulta> listar(Consulta consulta) {	
		return (Collection<ProcedimentoConsulta>) session.createCriteria(ProcedimentoConsulta.class)
				.add(Restrictions.eq("consulta.id", consulta.getId()))
				.list();
	}
	
	public void salvar(ProcedimentoConsulta procedimentoConsulta) {
		
		try {
			session.merge(procedimentoConsulta);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(ProcedimentoConsulta procedimentoConsulta) {
		
		try {
			session.delete(procedimentoConsulta);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}	
}
