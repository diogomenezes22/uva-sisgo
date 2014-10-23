package sisgo.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="paciente")
public class Paciente extends Pessoa {

	private EstadoCivil estadoCivil;
	private String profissao;
	private String obs;
	
	
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
	
}
