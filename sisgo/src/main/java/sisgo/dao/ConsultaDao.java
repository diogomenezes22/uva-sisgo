package sisgo.dao;

import java.util.Calendar;
import java.util.Collection;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;

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
	
	@SuppressWarnings("unchecked")
	public Collection<Consulta> listarPorAno(Integer ano) {
		return (Collection<Consulta>) session.createCriteria(Consulta.class)
				.add(Restrictions.sqlRestriction("extract (year from data_inicial) = ? ", ano, StandardBasicTypes.INTEGER))				
				.list();
	}	

	@SuppressWarnings("unchecked")
	public Collection<Consulta> listarConsultasDoDia() {
		
		Calendar hoje = Calendar.getInstance();
		hoje.clear(Calendar.HOUR_OF_DAY); hoje.clear(Calendar.AM_PM); hoje.clear(Calendar.MINUTE); hoje.clear(Calendar.SECOND); hoje.clear(Calendar.MILLISECOND);
		Calendar amanha = Calendar.getInstance();
		amanha.add(Calendar.DATE, 1);
		amanha.clear(Calendar.HOUR_OF_DAY); amanha.clear(Calendar.AM_PM); amanha.clear(Calendar.MINUTE); amanha.clear(Calendar.SECOND); amanha.clear(Calendar.MILLISECOND);
		
		return (Collection<Consulta>) session.createCriteria(Consulta.class)
				.add(Restrictions.ge("dataInicial", hoje.getTime()))
				.add(Restrictions.lt("dataInicial", amanha.getTime()))
				.addOrder(Order.asc("id")).list();
	}		
	
	public void salvar(Consulta consulta) {
		
		Transaction tx = session.beginTransaction();
		
		try {
			session.save(consulta);
			tx.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	
	public boolean atualizar(Consulta consulta) {
		
		Transaction tx = session.beginTransaction();
		
		try {
			session.update(consulta);
			tx.commit();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}
	}	
	
	public boolean excluir(Consulta consulta) {
		
		Transaction tx = session.beginTransaction();
		
		try {
			session.delete(consulta);
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
