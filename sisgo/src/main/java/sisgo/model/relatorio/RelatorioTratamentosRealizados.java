package sisgo.model.relatorio;

import java.util.Collection;

public class RelatorioTratamentosRealizados {

	private Collection<TratamentoRealizado> tratamentos;

	public RelatorioTratamentosRealizados(Collection<TratamentoRealizado> tratamentos) {
		this.tratamentos = tratamentos;
	}

	public Collection<TratamentoRealizado> getTratamentos() {
		return tratamentos;
	}

	public void setTratamentos(Collection<TratamentoRealizado> tratamentos) {
		this.tratamentos = tratamentos;
	}
	
}
