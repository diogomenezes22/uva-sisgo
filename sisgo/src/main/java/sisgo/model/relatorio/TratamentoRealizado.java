package sisgo.model.relatorio;

import java.util.List;

import sisgo.model.PlanoTratamento;

public class TratamentoRealizado {

	private Integer id;
	private String nome;
	private List<PlanoTratamento> planos;
	
	public TratamentoRealizado(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<PlanoTratamento> getPlanos() {
		return planos;
	}
	public void setPlanos(List<PlanoTratamento> planos) {
		this.planos = planos;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		TratamentoRealizado other = (TratamentoRealizado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
