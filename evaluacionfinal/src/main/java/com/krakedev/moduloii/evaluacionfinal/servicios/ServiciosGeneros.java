package com.krakedev.moduloii.evaluacionfinal.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.moduloii.evaluacionfinal.entidades.Genero;
import com.krakedev.moduloii.evaluacionfinal.utils.ConexionBDD;

public class ServiciosGeneros {
	private static final Logger LOGGER = LogManager.getLogger(Genero.class);

	public static void agregarGenero(Genero genero) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		LOGGER.trace("Genero a insertar" + genero);
		try {
			con = ConexionBDD.conectar();
			Genero g2=buscarGenero(genero.getNombre());
			if (g2==null) {
				ps = con.prepareStatement(	"INSERT INTO generos (nombre) VALUES (?)");
				ps.setString(1, genero.getNombre());
				ps.executeUpdate();
				LOGGER.debug("registro ok");	
			}
		} catch (Exception e) {
			LOGGER.error("Error al insertar", e);
			throw new Exception("Error al insertar");
			// TODO: handle exception
		} finally {
			con.close();
		}
	}
	
	public static Genero buscarGenero(String nombre) throws Exception {
	    Genero genero = null;
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        con = ConexionBDD.conectar();
	        ps = con.prepareStatement("SELECT generos FROM libros WHERE nombre = ?");
	        ps.setString(1, nombre);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	        	genero = new Genero();
	        	genero.setNombre(rs.getString("nombre"));
	        }else {
	        	LOGGER.error("Codigo no existe");
		        throw new Exception("Codigo no existe");
	    }
	    }catch (Exception e) {
	        LOGGER.error("Genero ya existe");
	        throw new Exception("Genero ya existe");
	    } finally {
	        if (con != null) {
	            con.close();
	        }
	    }

	    return genero;
	    }
}
