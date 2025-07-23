package com.krakedev.inventarios.entidades;

public class UnidadDeMedida {
	private String nombre;
	private String descripcion;
	private CategoriaUDM CategoriaUnidadMedida;
	public UnidadDeMedida() {
		super();
	}
	public UnidadDeMedida(String nombre, String descripcion, CategoriaUDM categoriaUnidadMedida) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		CategoriaUnidadMedida = categoriaUnidadMedida;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public CategoriaUDM getCategoriaUnidadMedida() {
		return CategoriaUnidadMedida;
	}
	public void setCategoriaUnidadMedida(CategoriaUDM categoriaUnidadMedida) {
		CategoriaUnidadMedida = categoriaUnidadMedida;
	}
	@Override
	public String toString() {
		return "UnidadDeMedida [nombre=" + nombre + ", descripcion=" + descripcion + ", CategoriaUnidadMedida="
				+ CategoriaUnidadMedida + "]";
	}
}
