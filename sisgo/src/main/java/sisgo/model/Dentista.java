package sisgo.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="dentista")
public class Dentista extends Usuario {

	private String cro;
	private String especialidade;
	private boolean admin;
	
	public String getCro() {
		return cro;
	}
	public void setCro(String cro) {
		this.cro = cro;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
}
