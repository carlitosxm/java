package com.krakedev.evaluacion;

import java.text.SimpleDateFormat;
import java.util.*;
import java.time.*;

public class Directorio {
	private ArrayList<Contacto> contactos;
	private Date fechaModificacion;
	private ArrayList<Contacto> correctos;
	private ArrayList<Contacto> incorrectos;
	
	public Directorio() {
		contactos= new ArrayList<Contacto>();
		correctos=new ArrayList<Contacto>();
		incorrectos=new ArrayList<Contacto>();
	}
	
	public ArrayList<Contacto> getContacto() {
		return contactos;
	}
	public void setContacto(ArrayList<Contacto> contacto) {
		this.contactos = contacto;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	
	public boolean agregarContacto(Contacto contacto) {
		Contacto rdirectorio=buscarPorCedula(contacto.getCedula());
		if (rdirectorio==null) {
		this.contactos.add(contacto);
		this.fechaModificacion=new Date();
		return true;
		}else {
			return false;
		}
	}
	
	public Contacto buscarPorCedula(String cedula) {
		Contacto cont=null;
		for (Contacto c : contactos) {
			if (c.getCedula().equals(cedula)) {
				cont=c;
			}
		}
		return cont;
	}
	
	public String consultarUltimaModificacion() {
		if (fechaModificacion != null) {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	        return sdf.format(fechaModificacion);
	    } else {
	        return "No se ha realizado ninguna modificación.";
	    }
	}
	
	public int contarPerdidos() {
		int perdidos=0;
		for (Contacto contacto : contactos) {
			if(contacto.getDireccion()==null) {
				perdidos++;
			}
		}
		return perdidos;
	}
	public int contarFijos() {
		int contar=0;
		for (Contacto contacto : contactos) {
			ArrayList<Telefono> telefonos=contacto.getTelefono();//cuando se devuelve un array
			for (Telefono telf:telefonos) {
				if (telf.getTipo().equals("Convencional") && telf.getEstado().equals("C")) {
					contar++;
				}
			}
		}
		return contar;
	}
	public void depurar() {
		for (int i = 0; i < contactos.size(); i++) {
	        Contacto contacto = contactos.get(i);
	        if (contacto.getDireccion() == null) {
	            incorrectos.add(contacto);
	            contactos.remove(i);
	            i--;
	        } else {
	            correctos.add(contacto);
	            contactos.remove(i);
	            i--;
	        }
	    }
	}

	public ArrayList<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(ArrayList<Contacto> contactos) {
		this.contactos = contactos;
	}

	public ArrayList<Contacto> getCorrectos() {
		return correctos;
	}

	public void setCorrectos(ArrayList<Contacto> correcto) {
		this.correctos = correcto;
	}

	public ArrayList<Contacto> getIncorrectos() {
		return incorrectos;
	}

	public void setIncorrectos(ArrayList<Contacto> incorrecto) {
		this.incorrectos = incorrecto;
	}
}
