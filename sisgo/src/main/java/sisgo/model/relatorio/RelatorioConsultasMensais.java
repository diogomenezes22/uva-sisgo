package sisgo.model.relatorio;

import java.util.Collection;

public class RelatorioConsultasMensais {

	private Collection<MesConsultasMensais> meses;

	public RelatorioConsultasMensais(Collection<MesConsultasMensais> meses) {
		this.meses = meses;
	}
	
	public Collection<MesConsultasMensais> getMeses() {
		return meses;
	}

	public void setMeses(Collection<MesConsultasMensais> meses) {
		this.meses = meses;
	}
	
}
