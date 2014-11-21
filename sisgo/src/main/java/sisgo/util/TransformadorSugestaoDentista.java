package sisgo.util;

import java.util.ArrayList;
import java.util.Collection;

import sisgo.model.Dentista;
import sisgo.vo.SugestaoVO;

public class TransformadorSugestaoDentista {

	public Collection<SugestaoVO> transformar(Collection<Dentista> dentistas) {
		
		Collection<SugestaoVO> sugestoes = new ArrayList<SugestaoVO>();
		for (Dentista dentista : dentistas)
			sugestoes.add(transformer(dentista));
		return sugestoes;
	}

	private SugestaoVO transformer(Dentista dentista) {
		
		SugestaoVO sugestaoVO = new SugestaoVO();
		sugestaoVO.setData(dentista.getId().toString());
		sugestaoVO.setValue(dentista.getNome());
		return sugestaoVO;
	}
	
}
