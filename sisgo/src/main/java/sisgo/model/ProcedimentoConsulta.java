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
@Table(name="procedimento_consulta")
@SequenceGenerator(sequenceName="procedimento_consulta_id_seq", name="seq")
public class ProcedimentoConsulta {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seq")
	private Integer id;
	private String obs;
	@ManyToOne
	@JoinColumn(name="consulta_id")
	private Consulta consulta;
	@ManyToOne
	@JoinColumn(name="procedimento_id")
	private Procedimento procedimento;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public Consulta getConsulta() {
		return consulta;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	public Procedimento getProcedimento() {
		return procedimento;
	}
	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}
	
}
