package com.krakedev.persistencia.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Time;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.persistencia.utils.ConexionBDD;
import com.krakeved.persistencia.entidades.RegistrosEntrada;

public class AdminRegistroEntradas {
	private static final Logger LOGGER=LogManager.getLogger(AdminRegistroEntradas.class);
	public static void insertar(RegistrosEntrada registro) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		LOGGER.trace("Entrada a insertar"+registro);
		try {
			con= ConexionBDD.conectar();
			ps=con.prepareStatement("INSERT INTO registros_entrada (codigo_registro, cedula_empleado, fecha, hora, codigo_empleado) "
					+ "VALUES (?,?,?,?,?) ");
			ps.setInt(1, registro.getCodigo_registro());
			ps.setString(2, registro.getCedula_empleado());
			ps.setDate(3, new java.sql.Date(registro.getFecha().getTime()));
			ps.setTime(4, new Time(registro.getHora().getTime()));
			ps.setInt(5, registro.getEmpleado().getCodigo_empleado());
			ps.executeUpdate();
			LOGGER.debug("registro ok");
		} catch (Exception e) {
			LOGGER.error("Error al insertar",e);
			throw new Exception("Error al insertar");
			// TODO: handle exception
		}finally {
			con.close();
		}
	}
	
	public static void actualizar(RegistrosEntrada registro) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		LOGGER.trace("Registro a insertar"+registro);
		try {
			con= ConexionBDD.conectar();
			ps=con.prepareStatement("update registros_entrada set cedula_empleado=?, fecha=?, hora=?, codigo_empleado=?"
					+ " where codigo_registro=?");
			ps.setString(1, registro.getCedula_empleado());
			ps.setDate(2, new java.sql.Date(registro.getFecha().getTime()));
			ps.setTime(3, new Time(registro.getHora().getTime()));
			ps.setInt(4, registro.getEmpleado().getCodigo_empleado());
			ps.setInt(5, registro.getCodigo_registro());
			ps.executeUpdate();
			LOGGER.debug("actualizar ok");
		} catch (Exception e) {
			LOGGER.error("Error al actualizar",e);
			throw new Exception("Error al actualizar");
			// TODO: handle exception
		}finally {
			con.close();
		}
	}
	
	public static void eliminar(int codigo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		LOGGER.trace("Registro a eliminar"+codigo);
		try {
			con= ConexionBDD.conectar();
			ps=con.prepareStatement("delete from registros_entrada where codigo_registro=?");
			ps.setInt(1, codigo);
			ps.executeUpdate();
			LOGGER.debug("eliminar ok");
		} catch (Exception e) {
			LOGGER.error("Error al eliminar",e);
			throw new Exception("Error al insertar");
			// TODO: handle exception
		}finally {
			con.close();
		}
	}

}
