package com.krakedev.moduloii.evaluacionfinal.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.moduloii.evaluacionfinal.entidades.Libro;
import com.krakedev.moduloii.evaluacionfinal.excepciones.KrakeException;
import com.krakedev.moduloii.evaluacionfinal.utils.ConexionBDD;

public class ServiciosLibros {
	private static final Logger LOGGER = LogManager.getLogger(ServiciosLibros.class);

	public static ArrayList<Libro> recuperarTodo() throws Exception {
		ArrayList<Libro> libros = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("SELECT * FROM libros");
			rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String titulo = rs.getString("titulo");
				int autor_id = rs.getInt("autor_id");
				int genero_id = rs.getInt("genero_id");
				Date anio_publicacion = rs.getDate("anio_publicacion");
				Boolean esta_disponibilidad = rs.getBoolean("esta_disponibilidad");
				Libro c = new Libro();
				c.setId(id);
				c.setTitulo(titulo);
				c.setAutor_id(autor_id);
				c.setGenero_id(genero_id);
				c.setAnio_publicacion(anio_publicacion);
				c.setEsta_disponible(esta_disponibilidad);
				libros.add(c);
			}
		} catch (Exception e) {
			LOGGER.error("Error al consultar por nombre", e);
			throw new Exception("Error al consultar por nombre");
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				LOGGER.error("Error cerrando conexión", e);
				throw new Exception("Error cerrando conexión");
			}
		}

		return libros;
	}

	public static void insertar(Libro libro) throws KrakeException {
		Connection con = null;
		PreparedStatement ps = null;
		LOGGER.trace("Categoria a insertar" + libro);
		try {
			con = ConexionBDD.conectar();
			Libro l2=buscarLibro(libro.getTitulo());
			if (l2!=null) {
				ps = con.prepareStatement("insert into libros (titulo,autor_id,genero_id,anio_publicacion,esta_disponibilidad) values "
								+ "(?,?,?,?,?);");
				ps.setString(1, libro.getTitulo());
				ps.setInt(2, libro.getAutor_id());
				ps.setInt(3, libro.getGenero_id());
				ps.setDate(4, new java.sql.Date(libro.getAnio_publicacion().getTime()));
				ps.setBoolean(5, libro.getEsta_disponible());
				ps.executeUpdate();
				LOGGER.debug("registro ok");
			}
		} catch (Exception e) {
			LOGGER.error("Error al insertar", e);
			throw new KrakeException("Error al insertar");
			// TODO: handle exception
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new KrakeException("mensaje de usaurio " + e);
			}
		}
	}

	public static Libro buscarLibro(String nombre) throws Exception {
	    Libro libro = null;
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        con = ConexionBDD.conectar();
	        ps = con.prepareStatement("SELECT titulo FROM libros WHERE titulo = ?");
	        ps.setString(1, nombre);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            libro = new Libro();
	            libro.setTitulo(rs.getString("titulo"));
	        }else {
	        	LOGGER.error("Codigo no existe");
		        throw new Exception("Codigo no existe");
	    }
	    }catch (Exception e) {
	        LOGGER.error("Error al consultar por NOMBRE", e);
	        throw new Exception("Error al consultar por NOMBRE");
	    } finally {
	        if (con != null) {
	            con.close();
	        }
	    }

	    return libro;
	    }
}
