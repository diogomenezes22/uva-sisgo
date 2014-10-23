package sisgo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="procedimento")
public class Procedimento {

	@Id
	private Integer id;
	private Double valor;
	@ManyToOne
	@JoinColumn(name="plano_tratamento_id")
	private PlanoTratamento planoTratamento;
	@ManyToOne
	@JoinColumn(name="tratamento_id")
	private Tratamento tratamento;	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public PlanoTratamento getPlanoTratamento() {
		return planoTratamento;
	}
	public void setPlanoTratamento(PlanoTratamento planoTratamento) {
		this.planoTratamento = planoTratamento;
	}
	public Tratamento getTratamento() {
		return tratamento;
	}
	public void setTratamento(Tratamento tratamento) {
		this.tratamento = tratamento;
	}
	
}
