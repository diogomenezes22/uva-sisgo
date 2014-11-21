package sisgo.util;

import java.util.ArrayList;
import java.util.Collection;

import sisgo.model.Consulta;
import sisgo.vo.ConsultaVO;

public class TransformadorConsultaVO {

	public Collection<ConsultaVO> transformar(Collection<Consulta> consultas) {
		
		Collection<ConsultaVO> consultasVOs = new ArrayList<ConsultaVO>();
		for (Consulta consulta : consultas)
			consultasVOs.add(transformer(consulta));
		return consultasVOs;
	}

	private ConsultaVO transformer(Consulta consulta) {
		
		ConsultaVO consultaVO = new ConsultaVO();
		consultaVO.setId(consulta.getId().toString());
		consultaVO.setStart(consulta.getDataInicial());
		consultaVO.setEnd(consulta.getDataFinal());
		consultaVO.setDentist(consulta.getDentista().getNome());
		consultaVO.setDentistId(consulta.getDentista().getId().toString());
		consultaVO.setPatient(consulta.getPaciente().getNome());
		consultaVO.setPatientId(consulta.getPaciente().getId().toString());
		consultaVO.setObs(consulta.getObs());
		return consultaVO;
	}
	
}
