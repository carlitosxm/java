package com.krakedev.moduloii.evaluacionfinal.entidades;

import java.util.Date;

public class Libro {
	private int id;
	private String titulo;
	private int autor_id;
	private int genero_id;
	private Date anio_publicacion;
	private Boolean esta_disponible;
	public Libro(String titulo, int autor_id, int genero_id, Date anio_publicacion, Boolean esta_disponible) {
		super();
		this.titulo = titulo;
		this.autor_id = autor_id;
		this.genero_id = genero_id;
		this.anio_publicacion = anio_publicacion;
		this.esta_disponible = esta_disponible;
	}
	public Libro() {
		super();
	}
	public Libro(int id, String titulo, int autor_id, int genero_id, Date anio_publicacion, Boolean esta_disponible) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor_id = autor_id;
		this.genero_id = genero_id;
		this.anio_publicacion = anio_publicacion;
		this.esta_disponible = esta_disponible;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getAutor_id() {
		return autor_id;
	}
	public void setAutor_id(int autor_id) {
		this.autor_id = autor_id;
	}
	public int getGenero_id() {
		return genero_id;
	}
	public void setGenero_id(int genero_id) {
		this.genero_id = genero_id;
	}
	public Date getAnio_publicacion() {
		return anio_publicacion;
	}
	public void setAnio_publicacion(Date anio_publicacion) {
		this.anio_publicacion = anio_publicacion;
	}
	public Boolean getEsta_disponible() {
		return esta_disponible;
	}
	public void setEsta_disponible(Boolean esta_disponible) {
		this.esta_disponible = esta_disponible;
	}
	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor_id=" + autor_id + ", genero_id=" + genero_id
				+ ", anio_publicacion=" + anio_publicacion + ", esta_disponible=" + esta_disponible + "]";
	}
	
}
