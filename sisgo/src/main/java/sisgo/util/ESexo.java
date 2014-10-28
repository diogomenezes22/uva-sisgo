package sisgo.util;

public enum ESexo {

	MASCULINO('M', 77), FEMININO('F', 70);
	
	private char id;
	private int asciiCode;
	
	private ESexo(char id, int asciiCode) {
		this.id = id;
		this.asciiCode = asciiCode;
	}
	
	public char getId() {
		return this.id;
	}
	
	public int getAsciiCode() {
		return this.asciiCode;
	}
	
}
