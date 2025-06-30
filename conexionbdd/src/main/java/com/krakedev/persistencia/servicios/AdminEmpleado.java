package com.krakedev.persistencia.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Time;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.persistencia.utils.ConexionBDD;
import com.krakeved.persistencia.entidades.Empleado;

public class AdminEmpleado {
	private static final Logger LOGGER=LogManager.getLogger(AdminEmpleado.class);
	public static void insertar(Empleado empleado) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		LOGGER.trace("Empleado a insertar"+empleado);
		try {
			con= ConexionBDD.conectar();
			ps=con.prepareStatement("INSERT INTO empleado (codigo_empleado, nombre, fecha, hora) "
					+ "VALUES (?,?,?,?)");
			ps.setInt(1, empleado.getCodigo_empleado());
			ps.setString(2, empleado.getNombre());
			ps.setDate(3, new java.sql.Date(empleado.getFecha().getTime()));
			ps.setTime(4, new Time(empleado.getHora().getTime()));
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
	
	public static void actualizar(Empleado empleado) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		LOGGER.trace("Empleado a insertar"+empleado);
		try {
			con= ConexionBDD.conectar();
			ps=con.prepareStatement("update empleado set nombre=?,fecha=?,"
					+ "hora=? where codigo_empleado=?");
			ps.setString(1, empleado.getNombre());
			ps.setDate(2, new java.sql.Date(empleado.getFecha().getTime()));
			ps.setTime(3, new Time(empleado.getHora().getTime()));
			ps.setInt(4, empleado.getCodigo_empleado());
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
		LOGGER.trace("Empleado a eliminar"+codigo);
		try {
			con= ConexionBDD.conectar();
			ps=con.prepareStatement("delete from empleado where codigo_empleado=?");
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
