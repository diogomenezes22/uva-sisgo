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
@Table(name="consulta")
@SequenceGenerator(sequenceName="consulta_id_seq", name="seq")
public class Consulta {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seq")
	private Integer id;
	@Column(name="data_inicial")
	private Date dataInicial;
	@Column(name="data_final")
	private Date dataFinal;	
	private String obs;
	@ManyToOne
	@JoinColumn(name="paciente_id")
	private Paciente paciente;
	@ManyToOne
	@JoinColumn(name="usuario_id")	
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name="dentista_id")	
	private Dentista dentista;	
	
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
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Dentista getDentista() {
		return dentista;
	}
	public void setDentista(Dentista dentista) {
		this.dentista = dentista;
	}

}
