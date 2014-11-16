package sisgo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="anamnese")
@SequenceGenerator(sequenceName="anamnese_id_seq", name="seq")
public class Anamnese {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seq")
	private Integer id;
	private String ficha;
	@Column(name="data_preenchimento")
	private Date dataPreenchimento;
	@ManyToOne
	@JoinColumn(name="paciente_id")
	private Paciente paciente;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFicha() {
		return ficha;
	}
	public void setFicha(String ficha) {
		this.ficha = ficha;
	}
	public Date getDataPreenchimento() {
		return dataPreenchimento;
	}
	public void setDataPreenchimento(Date dataPreenchimento) {
		this.dataPreenchimento = dataPreenchimento;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
}
