package arraymio.entidades;

public class Notas {
	private int nota;
	private int parcial;
	public Notas(int nota, int parcial) {
		super();
		this.nota = nota;
		this.parcial = parcial;
	}
	public int getNota() {
		return nota;
	}
	public int getParcial() {
		return parcial;
	}
	@Override
	public String toString() {
		return "Notas [nota=" + nota + ", parcial=" + parcial + "]";
	}	
}
