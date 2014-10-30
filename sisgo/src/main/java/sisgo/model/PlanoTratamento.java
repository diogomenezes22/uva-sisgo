package sisgo.model;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="plano_tratamento")
@SequenceGenerator(sequenceName="plano_tratamento_id_seq", name="seq")
public class PlanoTratamento {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seq")
	private Integer id;
	@Column(name="data_inicial")
	private Date dataInicial;
	@Column(name="data_conclusao")
	private Date dataConclusao;
	private String obs;
	@Column(name="valor_total")
	private Double valorTotal;
	@Column(name="em_aberto")
	private boolean emAberto;
	@ManyToOne
	@JoinColumn(name="paciente_id")
	private Paciente paciente;
	@OneToMany(mappedBy="planoTratamento", fetch=FetchType.EAGER, orphanRemoval=true, cascade=CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	private Collection<Procedimento> procedimentos;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	public Date getDataConclusao() {
		return dataConclusao;
	}
	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public boolean isEmAberto() {
		return emAberto;
	}
	public void setEmAberto(boolean emAberto) {
		this.emAberto = emAberto;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Collection<Procedimento> getProcedimentos() {
		return procedimentos;
	}
	public void setProcedimentos(Collection<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}
	public Map<Integer, Procedimento> getMapaProcedimentos() {
		Map<Integer, Procedimento> mapa = new HashMap<Integer, Procedimento>();
		if(procedimentos != null)
			for (Procedimento procedimento : procedimentos)
				mapa.put(procedimento.getTratamento().getId(), procedimento);
		return mapa;
	}
	
}
