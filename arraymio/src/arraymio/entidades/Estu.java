package arraymio.entidades;

import java.util.ArrayList;

public class Estu {
	private String nombre;
	private ArrayList<Materia> materias;
	public Estu(String nombre) {
		super();
		this.nombre = nombre;
		this.materias = new ArrayList<Materia>();
	}
	public String getNombre() {
		return nombre;
	}
	public ArrayList<Materia> getMaterias() {
		return materias;
	}
	public void setMaterias(ArrayList<Materia> materias) {
		this.materias = materias;
	}
	@Override
	public String toString() {
		return "Estu [nombre=" + nombre + ", materias=" + materias + "]";
	}
	
}
