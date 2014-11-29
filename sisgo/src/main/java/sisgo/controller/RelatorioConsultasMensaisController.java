package sisgo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.inject.Inject;

import sisgo.dao.ConsultaDao;
import sisgo.model.Consulta;
import sisgo.model.relatorio.MesConsultasMensais;
import sisgo.model.relatorio.RelatorioConsultasMensais;
import sisgo.util.Mes;
import sisgo.util.Permissao;
import sisgo.util.ValidaSessao;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Controller
public class RelatorioConsultasMensaisController {

	@Inject
	private Result result;
	@Inject
	private ConsultaDao consultaDao;		

	
	@ValidaSessao(Permissao.ADMIN)
	@Path("/relatorio/consultas-mensais")
	public void filtro() {
		Collection<Consulta> consultas = consultaDao.listar();
		Collection<String> anosDistintos = obterAnosDistintos(consultas);
		result.include("anos", anosDistintos);
	}

	@ValidaSessao(Permissao.ADMIN)
	@Path("/relatorio/sintetico/consultas-mensais/{ano}/gerar")
	public void relatorioSintetico(Integer ano) {
		Collection<Consulta> consultas = consultaDao.listarPorAno(ano);
		Map<Integer, Integer> mapaConsultasPorNumeroMes = construirMapa();
		agruparConsultas(mapaConsultasPorNumeroMes, consultas);
		Map<String, Integer> mapaConsultasPorMes = formatarMapaPorNomeDoMes(mapaConsultasPorNumeroMes);
		result.use(Results.json()).withoutRoot().from(mapaConsultasPorMes).serialize();
	}
	
	@ValidaSessao(Permissao.ADMIN)
	@Path("/relatorio/analitico/consultas-mensais/{ano}/gerar")
	public void relatorioAnalitico(Integer ano) {
		Collection<Consulta> consultas = consultaDao.listarPorAno(ano);
		Map<MesConsultasMensais, List<Consulta>> mapaConsultasMensais = construirMapaConsultasMensais(consultas);
		List<MesConsultasMensais> meses = contruirMesesRelatorio(mapaConsultasMensais);
		ordenaRelatorio(meses);
		result.include("relatorio", new RelatorioConsultasMensais(meses));
		result.include("ano", ano);
		result.include("dataEmissao", Calendar.getInstance().getTime());
	}	
	
	private void ordenaRelatorio(List<MesConsultasMensais> meses) {
		
		Collections.sort(meses,new Comparator<MesConsultasMensais>(){
            public int compare(MesConsultasMensais m1, MesConsultasMensais m2){
                  return m1.getNumero().compareTo(m2.getNumero());
            }});
		
		for (MesConsultasMensais mesConsultasMensais : meses) {
			Collections.sort(mesConsultasMensais.getConsultas(),new Comparator<Consulta>(){
				public int compare(Consulta c1, Consulta c2) {					
					return c1.getDataFinal().compareTo(c2.getDataInicial());
				}});			
		}
	}

	private List<MesConsultasMensais> contruirMesesRelatorio(Map<MesConsultasMensais, List<Consulta>> mapaConsultasMensais) {
		
		List<MesConsultasMensais> meses = new ArrayList<MesConsultasMensais>();
		for (Entry<MesConsultasMensais, List<Consulta>> registro : mapaConsultasMensais.entrySet()) {
			MesConsultasMensais mes = registro.getKey();
			mes.setConsultas(registro.getValue());
			meses.add(mes);
		}
		return meses;
	}

	@SuppressWarnings("deprecation")
	private Map<MesConsultasMensais, List<Consulta>> construirMapaConsultasMensais(Collection<Consulta> consultas) {
		
		Map<MesConsultasMensais, List<Consulta>> mapaConsultasMensais = new HashMap<MesConsultasMensais, List<Consulta>>();
		for (Consulta consulta : consultas) {
			MesConsultasMensais mesConsultasMensais = new MesConsultasMensais(consulta.getDataInicial().getMonth());
			if(!mapaConsultasMensais.containsKey(mesConsultasMensais))
				mapaConsultasMensais.put(mesConsultasMensais, new ArrayList<Consulta>());
			mapaConsultasMensais.get(mesConsultasMensais).add(consulta);
		}
		return mapaConsultasMensais;
	}

	private Collection<String> obterAnosDistintos(Collection<Consulta> consultas) {
		
		Set<String> anosDistintos = new HashSet<String>();
		for (Consulta consulta : consultas)
			anosDistintos.add(new SimpleDateFormat("yyyy").format(consulta.getDataInicial()));
		return anosDistintos;
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
		
}