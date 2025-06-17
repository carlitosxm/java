package com.crc.directorio.entidades;

public class AdminTelefono {
	public void activarMensajeria(Telefono telefono) {
		if (telefono.getOperadora()=="movi") {
			telefono.setTieneWhatsapp(true);
		}
	}
	
	public int contarMovi(Telefono tel1, Telefono tel2, Telefono tel3) {
		int contar=0;
		if (tel1.getOperadora()=="movi") {
			contar++;
		}
		if (tel2.getOperadora()=="movi") {
			contar++;
		}
		if (tel3.getOperadora()=="movi") {
			contar++;
		}
		return contar;
	}
	
	public int contarClaro(Telefono tel1, Telefono tel2, Telefono tel3, Telefono tel4) {
		int contar=0;
		if (tel1.getOperadora()=="movi") {
			contar++;
		}
		if (tel2.getOperadora()=="movi") {
			contar++;
		}
		if (tel3.getOperadora()=="movi") {
			contar++;
		}
		if (tel4.getOperadora()=="movi") {
			contar++;
		}
		return contar;
	}
}
