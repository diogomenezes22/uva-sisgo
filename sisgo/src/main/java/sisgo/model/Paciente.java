package sisgo.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="paciente")
public class Paciente extends Pessoa {

	@ManyToOne
	@JoinColumn(name="estado_civil_id")
	private EstadoCivil estadoCivil;
	private String profissao;
	private String obs;
	@OneToMany(mappedBy="paciente")
	private Collection<PlanoTratamento> planos;
	
	
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public Collection<PlanoTratamento> getPlanos() {
		return planos;
	}
	public void setPlanos(Collection<PlanoTratamento> planos) {
		this.planos = planos;
	}
	
}
