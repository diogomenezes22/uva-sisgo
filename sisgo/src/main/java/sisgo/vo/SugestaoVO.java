package sisgo.vo;

import java.io.Serializable;

public class SugestaoVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String data;
	private String value;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
