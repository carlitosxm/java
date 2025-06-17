package com.crc.directorio.entidades;

public class AdminContactos {
	public Contactos buscarMasPesado(Contactos c1, Contactos c2) {
		if (c1.getPeso() > c2.getPeso()) {
			return c1;
		} else {
			return c2;
		}
	}

	public boolean comparaOperadoras(Contactos c1, Contactos c2) {
		if (c1.getTelefono().getOperadora() == c2.getTelefono().getOperadora()) {
			return true;
		} else {
			return false;
		}
	}
	public void activarUsuario(Contactos c1) {
		if (c1.getTelefono().getTieneWhatsapp()==true) {
			c1.setActivo(true);
		}
	}
}
