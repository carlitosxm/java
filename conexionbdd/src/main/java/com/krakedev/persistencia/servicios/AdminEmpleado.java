package com.krakedev.persistencia.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

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
	
	public static ArrayList<Empleado> buscarPorNombre(String nombreBuscar) throws Exception {
	    ArrayList<Empleado> empleados = new ArrayList<>();
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        con = ConexionBDD.conectar();
	        ps = con.prepareStatement("SELECT * FROM empleado WHERE nombre LIKE ?");
	        ps.setString(1, "%" + nombreBuscar + "%");
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            int codigo = rs.getInt("codigo_empleado");
	            String nombre = rs.getString("nombre");
	            Date fecha = rs.getDate("fecha");
	            Time hora = rs.getTime("hora");

	            Empleado e = new Empleado();
	            e.setCodigo_empleado(codigo);
	            e.setNombre(nombre);
	            e.setFecha(fecha);
	            e.setHora(hora);

	            empleados.add(e);
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

	    return empleados;
	}
	
	public static Empleado buscarPorCodigo(int codigoBuscar) throws Exception {
	    Empleado empleado = null;
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        con = ConexionBDD.conectar();
	        ps = con.prepareStatement("SELECT * FROM empleado WHERE codigo_empleado = ?");
	        ps.setInt(1, codigoBuscar);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            empleado = new Empleado();
	            empleado.setCodigo_empleado(rs.getInt("codigo_empleado"));
	            empleado.setNombre(rs.getString("nombre"));
	            empleado.setFecha(rs.getDate("fecha"));
	            empleado.setHora(rs.getTime("hora"));
	        }
	    } catch (Exception e) {
	        LOGGER.error("Error al consultar por código", e);
	        throw new Exception("Error al consultar por código");
	    } finally {
	        if (con != null) {
	            con.close();
	        }
	    }

	    return empleado;
	}
	
}
