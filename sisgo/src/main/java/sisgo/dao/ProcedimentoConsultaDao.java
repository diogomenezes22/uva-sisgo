package sisgo.dao;

import java.util.Collection;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.Transaction;
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
		
		Transaction tx = session.beginTransaction();
		try {
			session.merge(procedimentoConsulta);
			tx.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	
	public boolean excluir(ProcedimentoConsulta procedimentoConsulta) {
		
		Transaction tx = session.beginTransaction();
		try {
			session.delete(procedimentoConsulta);
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
