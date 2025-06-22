package com.krakedev.endidades;

import java.util.ArrayList;

public class Curso {
	private ArrayList<Estudiante> estudiantes;
	public ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	public String buscarEstudiantePorCedula(Estudiante estudiante) {
		String mensaje=null;
		for(int i=0;i<estudiantes.size();i++) {
			if(estudiante.getCedula().equals(estudiantes.get(i).getCedula())) {
				mensaje="El estudiante ya se encuentra registrado";
				break;
			}
		}
		return mensaje;
	}
	
	public void matricularEstudiante(Estudiante estudiante) {
		boolean encontrado=false;
		if(estudiantes == null) {
			estudiantes =new ArrayList<Estudiante>();
		}
		for(int i=0;i<estudiantes.size();i++) {
			Estudiante e=estudiantes.get(i);
			if(estudiante.getCedula().equals(e.getCedula())) {
				encontrado=true;
				break;
			}
		}
		if(!encontrado) {
			estudiantes.add(estudiante);
		}
	}
	
	public double calcularPromedioCurso() {
		double sumaPromedios = 0;

	    if (estudiantes == null) {
	        return 0; 
	    }
	    for (Estudiante e : estudiantes) {
	        sumaPromedios += e.calcularPromedioNotasEstudiante();
	    }
	    return sumaPromedios / estudiantes.size();
	}
	
	public void mostrar() {
		if (estudiantes == null) {
	        System.out.println("No hay estudiantes en el curso.");
	        return;
	    }
	    for (int i = 0; i < estudiantes.size(); i++) {
	        Estudiante est = estudiantes.get(i);
	        StringBuilder sb = new StringBuilder();
	        sb.append("Estudiante [");
	        sb.append("Cedula=\"").append(est.getCedula()).append("\", ");
	        sb.append("Nombre=\"").append(est.getNombre()).append("\", ");
	        sb.append("Apellido=\"").append(est.getApellido()).append("\"");

	        ArrayList<Nota> notas = est.getNotas();
	        if (notas != null && !notas.isEmpty()) {
	            sb.append(", Notas=[");
	            for (int j = 0; j < notas.size(); j++) {
	                Nota nota = notas.get(j);
	                sb.append("{Materia=\"").append(nota.getMateria()).append("\", ");
	                sb.append("Nota").append(j + 1).append("=").append(nota.getCalificacion()).append("}");
	                if (j < notas.size() - 1) {
	                    sb.append(", ");
	                }
	            }
	            sb.append("]");
	        }
	        sb.append("]");
	        System.out.println(sb.toString());
	    }
	}
	
	
}
