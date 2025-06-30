package com.krakedev.persistencia.servicios;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.persistencia.utils.ConexionBDD;
import com.krakeved.persistencia.entidades.Persona;

public class AdminPersonas {
	private static final Logger LOGGER=LogManager.getLogger(AdminPersonas.class);
	public static void insertar(Persona persona) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		LOGGER.trace("Persona a insertar"+persona);
		try {
			//abrir conexion
			con= ConexionBDD.conectar();
			ps=con.prepareStatement("insert into personas (cedula, nombre, apellido,estado_civil_codigo,numero_hijos,estatura,cantidad_ahorrada,fecha_nacimiento,hora_nacimientos)"
					+"values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, persona.getCedula());
			ps.setString(2, persona.getNombre());
			ps.setString(3, persona.getApellido());
			ps.setString(4, persona.getEstadoCivil().getCodigo());
			ps.setInt(5, persona.getNumero_hijos());
			ps.setDouble(6, persona.getEstatura());
			ps.setBigDecimal(7, persona.getCantidad_ahorrada());
			ps.setDate(8, new java.sql.Date(persona.getFecha_nacimiento().getTime()));
			ps.setTime(9, new Time(persona.getHora_nacimientos().getTime()));
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			LOGGER.error("Error al insertar",e);
			throw new Exception("Error al insertar");
			
		}finally {
			//abrir conexion
		}try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				LOGGER.error("Error con base de datos",e);
				throw new Exception("Error con base de datos");
			}
		
		}
	
	public static void actualizar(Persona persona) throws Exception{
		Connection con=null;
		PreparedStatement ps=null;
		LOGGER.trace("Persona a actualizar"+persona);
		try {
			con= ConexionBDD.conectar();
			ps=con.prepareStatement("update personas set nombre=?,apellido=?,"
					+ "estado_civil_codigo=?,numero_hijos=?,estatura=?,cantidad_ahorrada=?,"
					+ "fecha_nacimiento=?,hora_nacimientos=? where cedula=?");
			ps.setString(1, persona.getNombre());
			ps.setString(2, persona.getApellido());
			ps.setString(3, persona.getEstadoCivil().getCodigo());
			ps.setInt(4, persona.getNumero_hijos());
			ps.setDouble(5, persona.getEstatura());
			ps.setBigDecimal(6, persona.getCantidad_ahorrada());
			ps.setDate(7, new java.sql.Date(persona.getFecha_nacimiento().getTime()));
			ps.setTime(8, new Time(persona.getHora_nacimientos().getTime()));
			ps.setString(9, persona.getCedula());
			
			ps.executeUpdate();
		} catch (Exception e) {
			LOGGER.error("Error al actualizar",e);
			throw new Exception("Error al actualizar");
			// TODO: handle exception
		}finally {
			con.close();
		}
	}
	
	public static void eliminar(String cedula) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		LOGGER.trace("Persona a elimina: "+cedula);
		try {
			con=ConexionBDD.conectar();
			ps=con.prepareStatement("delete from personas"
					+ " where cedula=?");
			ps.setString(1, cedula);
			ps.executeUpdate();
		} catch (Exception e) {
			LOGGER.error("Error al eliminar",e);
			throw new Exception("Error al eliminar");
			// TODO: handle exception
		}finally {
			con.close();
		}
	}
}
