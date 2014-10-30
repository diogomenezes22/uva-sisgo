package sisgo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="procedimento")
@SequenceGenerator(sequenceName="procedimento_id_seq", name="seq")
public class Procedimento {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seq")
	private Integer id;
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
