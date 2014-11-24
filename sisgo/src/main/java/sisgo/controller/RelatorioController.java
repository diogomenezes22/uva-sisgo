package sisgo.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;

import sisgo.dao.ConsultaDao;
import sisgo.dao.ProcedimentoDao;
import sisgo.model.Consulta;
import sisgo.model.Procedimento;
import sisgo.util.Mes;
import sisgo.util.Permissao;
import sisgo.util.ValidaSessao;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Path("/relatorio")
@Controller
public class RelatorioController {

	@Inject
	private Result result;
	@Inject
	private ConsultaDao consultaDao;
	@Inject
	private ProcedimentoDao procedimentoDao;		

	
	@ValidaSessao(Permissao.ADMIN)
	@Path("/tratamentos-realizados")
	public void tratamentosRealizados() {}
	
	@ValidaSessao(Permissao.ADMIN)
	@Path("/tratamentos-realizados/gerar")
	public void gerarTratamentosRealizados() {
		Collection<Procedimento> procedimentos = procedimentoDao.carregar();
		Map<String, Integer> mapaTratamentos = agruparTratamentos(procedimentos);
		Map<String, Double> mapaPorcentagemTratamentos = calcularPorcentagemTratametos(mapaTratamentos);
		result.use(Results.json()).withoutRoot().from(mapaPorcentagemTratamentos).serialize();
	}	
	
	@ValidaSessao(Permissao.ADMIN)
	@Path("/consultas-mensais")
	public void consultasMensais() {}
	
	@ValidaSessao(Permissao.ADMIN)
	@Path("/consultas-mensais/gerar")
	public void gerarConsultasMensais() {
		Collection<Consulta> consultas = consultaDao.listar();
		Map<Integer, Integer> mapaConsultasPorNumeroMes = construirMapa();
		agruparConsultas(mapaConsultasPorNumeroMes, consultas);
		Map<String, Integer> mapaConsultasPorMes = formatarMapaPorNomeDoMes(mapaConsultasPorNumeroMes);
		result.use(Results.json()).withoutRoot().from(mapaConsultasPorMes).serialize();
	}		
	
	private Map<String, Integer> formatarMapaPorNomeDoMes(Map<Integer, Integer> mapaConsultasPorNumeroMes) {
		
		Map<String, Integer> mapaConsultasPorMes = new LinkedHashMap<String, Integer>();
		for (Entry<Integer, Integer> registro : mapaConsultasPorNumeroMes.entrySet()) {
			mapaConsultasPorMes.put(Mes.get(registro.getKey()).getNome(), registro.getValue());
		}
		return mapaConsultasPorMes;
	}

	@SuppressWarnings("deprecation")
	private void agruparConsultas(Map<Integer, Integer> mapaConsultasPorMes, Collection<Consulta> consultas) {
		
		for (Consulta consulta : consultas) {
			Integer numeroMes = consulta.getDataInicial().getMonth();
			mapaConsultasPorMes.put(numeroMes, mapaConsultasPorMes.get(numeroMes) + 1);
		}		
	}

	private Map<Integer, Integer> construirMapa() {
		Map<Integer, Integer> mapaConsultasPorMes = new HashMap<Integer, Integer>();
		for (Mes mes : Mes.values()) {
			mapaConsultasPorMes.put(mes.getNumero(), 0);
		}
		return mapaConsultasPorMes;
	}

	private Map<String, Double> calcularPorcentagemTratametos(Map<String, Integer> mapaTratamentos) {
		
		Map<String, Double> mapaPorcentagemTratamentos = new HashMap<String, Double>();
		Integer totalTratamentos = obterTotalDeTratamentos(mapaTratamentos);
		for (Entry<String, Integer> registro : mapaTratamentos.entrySet()) {
			mapaPorcentagemTratamentos.put(registro.getKey(), calcularPorcentagemTratamento(registro.getValue(), totalTratamentos));
		}		
		return mapaPorcentagemTratamentos;
	}

	private Double calcularPorcentagemTratamento(Integer quantidadeDoTratamento, Integer totalDeTratamentos) {
		return quantidadeDoTratamento * 100.0 / totalDeTratamentos;
	}

	private Integer obterTotalDeTratamentos(Map<String, Integer> mapaTratamentos) {
		
		Integer totalTratamentos = 0;;
		for (Entry<String, Integer> registro : mapaTratamentos.entrySet()) {
			totalTratamentos += registro.getValue();
		}
		return totalTratamentos;
	}

	private Map<String, Integer> agruparTratamentos(Collection<Procedimento> procedimentos) {
		
		Map<String, Integer> mapaTratamentos = new HashMap<String, Integer>();
		for (Procedimento procedimento : procedimentos) {
			String chave = procedimento.getTratamento().getNome();
			if(mapaTratamentos.containsKey(chave))
				mapaTratamentos.put(chave, mapaTratamentos.get(chave) + 1);
			else
				mapaTratamentos.put(chave, 1);
		}
		return mapaTratamentos;
	}
		
}