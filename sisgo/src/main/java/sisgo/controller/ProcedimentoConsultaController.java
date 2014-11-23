package sisgo.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import sisgo.dao.ConsultaDao;
import sisgo.dao.ProcedimentoConsultaDao;
import sisgo.model.Consulta;
import sisgo.model.PlanoTratamento;
import sisgo.model.Procedimento;
import sisgo.model.ProcedimentoConsulta;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Path("/procedimento-consulta")
@Controller
public class ProcedimentoConsultaController {

	@Inject
	private Result result;
	@Inject
	private ProcedimentoConsultaDao procedimentoConsultaDao;	
	@Inject
	private ConsultaDao consultaDao;	


	public void form() {}			
	
	@Path("/{consulta.id}/form")
	public void form(Consulta consulta) {
		consulta = consultaDao.carregar(consulta.getId());
		Collection<Procedimento> procedimentos = obtemProcedimentosDoPaciente(consulta);
		if(procedimentos.size() > 0) {
			result.include("consulta", consulta);
			result.include("procedimentos", procedimentos);
			result.include("paciente", consulta.getPaciente());
			result.redirectTo(this).form();
		}
		else {
			result.include("erro", "Nao existem planos de tratamento em aberto para este paciente!");
			result.redirectTo(this).listar(consulta);
		}
		
	}

	@Path("/{consulta.id}/form/{procedimentoConsulta.id}")
	public void form(Consulta consulta, ProcedimentoConsulta procedimentoConsulta) {
		consulta = consultaDao.carregar(consulta.getId());
		Collection<Procedimento> procedimentos = obtemProcedimentosDoPaciente(consulta);
		procedimentoConsulta = procedimentoConsultaDao.carregar(procedimentoConsulta.getId());
		if(procedimentos.size() > 0) {
			result.include("procedimentoConsulta", procedimentoConsulta);
			result.include("consulta", consulta);
			result.include("procedimentos", procedimentos);
			result.include("paciente", consulta.getPaciente());
			result.redirectTo(this).form();
		}
		else {
			result.include("erro", "Nao existem planos de tratamento em aberto para este paciente!");
			result.redirectTo(this).listar(consulta);
		}		
	}	
	
	@Path("/{consulta.id}/listar")
	public void listar(Consulta consulta) {
		consulta = consultaDao.carregar(consulta.getId());
		result.include("consulta", consulta);
		result.include("paciente", consulta.getPaciente());
		result.include("procedimentosDaConsulta", procedimentoConsultaDao.listar(consulta));
	}	
	
	@Path("/salvar")
	public void salvar(ProcedimentoConsulta procedimentoConsulta) {
		procedimentoConsultaDao.salvar(procedimentoConsulta);		
		result.include("mensagem", "Procedimento salvo na consulta com sucesso!");
		result.redirectTo(this).listar(procedimentoConsulta.getConsulta());
	}
	
	@Path("/excluir/{id}")
	public void excluir(Integer id) {
		ProcedimentoConsulta procedimentoConsulta = procedimentoConsultaDao.carregar(id);
		Consulta consulta = procedimentoConsulta.getConsulta();
		procedimentoConsultaDao.excluir(procedimentoConsulta);
		result.include("mensagem", "Procedimento excluído da consulta com sucesso!");
		result.redirectTo(this).listar(consulta);
	}	
	
	private Collection<Procedimento> obtemProcedimentosDoPaciente(Consulta consulta) {
		
		Collection<Procedimento> procedimentos = new ArrayList<Procedimento>();
		for (PlanoTratamento plano : consulta.getPaciente().getPlanos())
			if(plano.isEmAberto()) 
				procedimentos.addAll(plano.getProcedimentos());
		
		return procedimentos;
	}	
}