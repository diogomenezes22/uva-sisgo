package sisgo.model.relatorio;

import java.util.Collection;
import java.util.List;

import sisgo.model.Consulta;
import sisgo.util.Mes;

public class MesConsultasMensais {

	private Integer numero;
	private String nome;
	private List<Consulta> consultas;
	
	public MesConsultasMensais(Integer numero) {
		this.numero = numero;
		this.nome = Mes.get(numero).getNome();
	}
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MesConsultasMensais other = (MesConsultasMensais) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
	
}
