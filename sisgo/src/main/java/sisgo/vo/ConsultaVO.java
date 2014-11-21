package sisgo.vo;

import java.io.Serializable;
import java.util.Date;

public class ConsultaVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private Date start;
	private Date end;
	private String patient;
	private String patientId;
	private String dentist;
	private String dentistId;
	private String obs;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public String getPatient() {
		return patient;
	}
	public void setPatient(String patient) {
		this.patient = patient;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getDentist() {
		return dentist;
	}
	public void setDentist(String dentist) {
		this.dentist = dentist;
	}
	public String getDentistId() {
		return dentistId;
	}
	public void setDentistId(String dentistId) {
		this.dentistId = dentistId;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	
}
