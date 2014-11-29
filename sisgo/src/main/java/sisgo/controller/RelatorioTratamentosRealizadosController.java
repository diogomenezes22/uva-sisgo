package sisgo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.inject.Inject;

import sisgo.dao.PlanoTratamentoDao;
import sisgo.dao.ProcedimentoDao;
import sisgo.model.PlanoTratamento;
import sisgo.model.Procedimento;
import sisgo.model.relatorio.RelatorioTratamentosRealizados;
import sisgo.model.relatorio.TratamentoRealizado;
import sisgo.util.Permissao;
import sisgo.util.ValidaSessao;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Path("")
@Controller
public class RelatorioTratamentosRealizadosController {

	@Inject
	private Result result;
	@Inject
	private ProcedimentoDao procedimentoDao;
	@Inject
	private PlanoTratamentoDao planoTratamentoDao;		

	
	@ValidaSessao(Permissao.ADMIN)
	@Path("/relatorio/tratamentos-realizados")
	public void filtro() {
		Collection<PlanoTratamento> planos = planoTratamentoDao.listar();
		Collection<String> anosDistintos = obterAnosDistintos(planos);
		result.include("anos", anosDistintos);		
	}
	
	@ValidaSessao(Permissao.ADMIN)
	@Path("/relatorio/sintetico/tratamentos-realizados/{ano}/gerar")
	public void relatorioSintetico(Integer ano) {
		Collection<Procedimento> procedimentos = procedimentoDao.carregar();
		Map<String, Integer> mapaTratamentos = agruparTratamentos(procedimentos);
		Map<String, Double> mapaPorcentagemTratamentos = calcularPorcentagemTratametos(mapaTratamentos);
		result.use(Results.json()).withoutRoot().from(mapaPorcentagemTratamentos).serialize();
	}
	
	@ValidaSessao(Permissao.ADMIN)
	@Path("/relatorio/analitico/tratamentos-realizados/{ano}/gerar")
	public void relatorioAnalitico(Integer ano) {
		Collection<Procedimento> procedimentos = procedimentoDao.carregar();
		Map<TratamentoRealizado, List<PlanoTratamento>> mapaTratamentos = construirMapaTratamentos(procedimentos);
		List<TratamentoRealizado> tratamentos = contruirTratamentosRelatorio(mapaTratamentos);
		ordenaRelatorio(tratamentos);
		result.include("relatorio", new RelatorioTratamentosRealizados(tratamentos));
		result.include("ano", ano);
		result.include("dataEmissao", Calendar.getInstance().getTime());
	}		
	
	private void ordenaRelatorio(List<TratamentoRealizado> tratamentos) {
		
		for (TratamentoRealizado tratamento : tratamentos) {
			Collections.sort(tratamento.getPlanos(),new Comparator<PlanoTratamento>(){
				public int compare(PlanoTratamento p1, PlanoTratamento p2) {					
					return p1.getDataInicial().compareTo(p2.getDataInicial());
				}});			
		}
	}	
	
	private List<TratamentoRealizado> contruirTratamentosRelatorio(Map<TratamentoRealizado, List<PlanoTratamento>> mapaTratamentos) {
		
		List<TratamentoRealizado> tratamentos = new ArrayList<TratamentoRealizado>();
		for (Entry<TratamentoRealizado, List<PlanoTratamento>> registro : mapaTratamentos.entrySet()) {
			TratamentoRealizado tratamento = registro.getKey();
			tratamento.setPlanos(registro.getValue());
			tratamentos.add(tratamento);
		}
		return tratamentos;
	}
	
	private Map<TratamentoRealizado, List<PlanoTratamento>> construirMapaTratamentos(Collection<Procedimento> procedimentos) {
		
		Map<TratamentoRealizado, List<PlanoTratamento>> mapaTratamentos = new HashMap<TratamentoRealizado, List<PlanoTratamento>>();
		for (Procedimento procedimento : procedimentos) {
			TratamentoRealizado tratamentoRealizado = new TratamentoRealizado(procedimento.getTratamento().getId(), procedimento.getTratamento().getNome());
			if(!mapaTratamentos.containsKey(tratamentoRealizado))
				mapaTratamentos.put(tratamentoRealizado, new ArrayList<PlanoTratamento>());
			mapaTratamentos.get(tratamentoRealizado).add(procedimento.getPlanoTratamento());
		}
		return mapaTratamentos;
	}
	
	private Collection<String> obterAnosDistintos(Collection<PlanoTratamento> planos) {
		
		Set<String> anosDistintos = new HashSet<String>();
		for (PlanoTratamento plano : planos)
			anosDistintos.add(new SimpleDateFormat("yyyy").format(plano.getDataInicial()));
		return anosDistintos;
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