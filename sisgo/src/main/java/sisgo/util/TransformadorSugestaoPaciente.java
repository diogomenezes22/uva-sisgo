package sisgo.util;

import java.util.ArrayList;
import java.util.Collection;

import sisgo.model.Paciente;
import sisgo.vo.SugestaoVO;

public class TransformadorSugestaoPaciente {

	public Collection<SugestaoVO> transformar(Collection<Paciente> pacientes) {
		
		Collection<SugestaoVO> sugestoes = new ArrayList<SugestaoVO>();
		for (Paciente paciente : pacientes)
			sugestoes.add(transformer(paciente));
		return sugestoes;
	}

	private SugestaoVO transformer(Paciente paciente) {
		
		SugestaoVO sugestaoVO = new SugestaoVO();
		sugestaoVO.setData(paciente.getId().toString());
		sugestaoVO.setValue(paciente.getNome());
		return sugestaoVO;
	}
	
}
