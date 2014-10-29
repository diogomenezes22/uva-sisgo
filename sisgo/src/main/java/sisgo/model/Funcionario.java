package sisgo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="funcionario")
public class Funcionario extends Usuario {

	private Double salario;
	@Column(name="data_admissao")
	private Date dataAdmissao;
	@Column(name="data_demissao")
	private Date dataDemissao;
	
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public Date getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	public Date getDataDemissao() {
		return dataDemissao;
	}
	public void setDataDemissao(Date dataDemissao) {
		this.dataDemissao = dataDemissao;
	}
	
}
