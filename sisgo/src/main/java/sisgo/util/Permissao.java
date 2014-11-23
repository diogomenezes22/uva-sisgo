package sisgo.util;

public enum Permissao {

	FUNCIONARIO(1), DENTISTA(2), ADMIN(3);
	
	private int nivel;
	
	private Permissao(int nivel) {
		this.nivel = nivel;
	}

	public int getNivel() {
		return nivel;
	}
	
}
