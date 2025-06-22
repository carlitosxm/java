package com.krakedev.endidades;

import java.util.ArrayList;

public class Estudiante {
	private String cedula;
	private String nombre;
	private String apellido;
	private ArrayList<Nota> notas;

	public Estudiante(String cedula, String nombre, String apellido) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public ArrayList<Nota> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}

	public void agregarNota(Nota nuevaNota) {
	    if (nuevaNota.getCalificacion() >= 0 && nuevaNota.getCalificacion() <= 10) {
	        if (notas == null) {
	            notas = new ArrayList<Nota>();
	        }
	        boolean existe = false;
	        for (int i = 0; i < notas.size(); i++) {
	            Nota nota = notas.get(i);
	            if (nuevaNota.getMateria().equals(nota.getMateria())) {
	                existe = true;
	                break;
	            }
	        }
	        if (!existe) {
	            notas.add(nuevaNota);
	        }
	    }
	}

	public void modificarNota(String codigo, double nuevaNota) {
		if(nuevaNota>=0&&nuevaNota<=10) {
			for(int i=0; i<notas.size();i++) {
				Nota nota=notas.get(i);
				if(nota.getMateria().equals(codigo)) {
					nota.setCalificacion(nuevaNota);
					break;
				}else {
					System.out.println("No se encontro el codigo");
				}
			}
		}
	}
	
	public double calcularPromedioNotasEstudiante() {
		double suma=0;
		for(int i=0;i<notas.size();i++) {
			suma+=notas.get(i).getCalificacion();
		}
		return (suma/notas.size());
	}
	
	public void mostrar() {
		StringBuilder sb=new StringBuilder();
		sb.append("Estudiante [");
		sb.append("Cedula=").append(cedula).append("\", ");
		sb.append("Nombre=").append(nombre).append("\", ");
		sb.append("Apellido=").append(apellido).append("\", ");
		if (notas != null && !notas.isEmpty()) {
			sb.append(", Notas=[");
			for (int i = 0; i < notas.size(); i++) {
				Nota nota = notas.get(i);
				sb.append("{Materia=\"").append(nota.getMateria()).append("\", ");
				sb.append("Nota").append(i + 1).append("=").append(nota.getCalificacion());
				if (i < notas.size() - 1) {
					sb.append("\", ");
				}
			}
		}
		sb.append("]");
		System.out.println(sb.toString());
	}
}
