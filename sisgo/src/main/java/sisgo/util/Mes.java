package sisgo.util;

public enum Mes {

	JAN(0, "Janeiro"), FEV(1, "Fevereiro"), MAR(2, "Março"), ABR(3, "Abril"), MAI(4, "Maio"), JUN(5, "Junho"), 
	JUL(6, "Julho"), AGO(7, "Agosto"), SET(8, "Setembro"), OUT(9, "Outubro"), NOV(10, "Novembro"), DEZ(11, "Dezembro");
	
	private int numero;
	private String nome;
	
	private Mes(int numero, String nome) {
		this.numero = numero;
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}
	
	public String getNome() {
		return nome;
	}	
	
	public static Mes get(int numero) {
		for (Mes mes : Mes.values()) {
			if(mes.numero == numero)
				return mes;
		}
		return null;
	}
	
}
