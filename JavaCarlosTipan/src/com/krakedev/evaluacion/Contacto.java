package com.krakedev.evaluacion;

import java.util.ArrayList;

public class Contacto {
	private String cedula;
	private String nombre;
	private String apellido;
	private Direccion direccion;
	private ArrayList<Telefono> telefono;
	public Contacto(String cedula, String nombre, String apellido) {
			this.cedula = cedula;
			this.nombre = nombre;
			this.apellido = apellido;
			this.telefono = new ArrayList<Telefono>();
	}
	public ArrayList<Telefono> getTelefono() {
		return telefono;
	}
	public void setTelefono(ArrayList<Telefono> telefono) {
		this.telefono = telefono;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
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
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	/*public void imprimir() {
		System.out.println("Cédula: "+getCedula());
		System.out.println("Nombre: "+getNombre());
		System.out.println("Apellido: "+getApellido());
		System.out.println("Dirección: ");
		System.out.println(" "+getDireccion().getCallePrincipal());
		System.out.println(" "+getDireccion().getCalleSecundaria());
	}*/
	public void imprimir() {
		System.out.println("*******"+getNombre()+" "+getApellido()+"*******");
		if(direccion!=null) {
			System.out.println("Dirección: "+getDireccion().getCallePrincipal()+" y "+getDireccion().getCalleSecundaria());
		}else {
			System.out.println("No tiene asociada una dirección");
		}
	}
	
	public void agregarTelefono(Telefono telefono) {
		this.telefono.add(telefono);
	}
	
	public void mostrarTelefonos() {
		System.out.println("Teléfonos con estado 'C';");
		for (Telefono tel : telefono) {
			if(tel.getEstado().equals("C")) {
				System.out.println("Número: "+tel.getNumero()+", Tipo: "+tel.getTipo());
			}
			
		}
	}
	
	public ArrayList<Telefono> recuperarIncorrectos(){
		ArrayList<Telefono> telefonosEncontados=new ArrayList<Telefono>();
			for (Telefono telefono : telefono) {
				if(telefono.getEstado().equals("E")) {
					telefonosEncontados.add(telefono);
				}
			}
		return telefonosEncontados;
	}
}
