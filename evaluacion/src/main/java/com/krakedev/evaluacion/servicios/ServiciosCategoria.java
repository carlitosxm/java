package com.krakedev.evaluacion.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.utils.ConexionBDD;


public class ServiciosCategoria {
	private static final Logger LOGGER = LogManager.getLogger(ServiciosCategoria.class);

	public static void insertar(Categoria categoria) throws KrakeException {
		Connection con = null;
		PreparedStatement ps = null;
		LOGGER.trace("Categoria a insertar" + categoria);
		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("INSERT into categorias (id,nombre) " + "VALUES (?,?)");
			ps.setString(1, categoria.getId());
			ps.setString(2, categoria.getNombre());
			ps.executeUpdate();
			LOGGER.debug("registro ok");
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

	public static void actualizar(Categoria categoria) throws KrakeException{
		Connection con=null;
		PreparedStatement ps=null;
		LOGGER.trace("Categoria a insertar"+categoria);
		try {
			con= ConexionBDD.conectar();
			ps=con.prepareStatement("update categorias set nombre=?"
					+ " where id=?");
			ps.setString(1, categoria.getNombre());
			ps.setString(2, categoria.getId());
			ps.executeUpdate();
			LOGGER.debug("actualizar ok");
		} catch (Exception e) {
			LOGGER.error("Error al actualizar",e);
			throw new KrakeException("Error al actualizar");
			// TODO: handle exception
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new KrakeException("mensaje de usaurio " + e);
			}
		}
	}

	public static Categoria buscarPorId(String id) throws KrakeException{
		Categoria r= null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con= ConexionBDD.conectar();
			ps= con.prepareStatement(" select * from categorias where id=? ");
			ps.setString(1, id);
			rs=ps.executeQuery();
			if (rs.next()) {
	            r = new Categoria();
	            r.setId(rs.getString("id"));
	            r.setNombre(rs.getString("nombre"));
	        }
	    } catch (Exception e) {
	    	throw new KrakeException("No existe la categoría con el id: " + id);
	    } finally {
	        if (con != null) {
	            try {
					con.close();
				} catch (SQLException e) {
					LOGGER.error("Error al consultar por código", e);
			        throw new KrakeException("Error al consultar por código");
				}
	        }
	        /*if(r==null) {
	        	LOGGER.error("Error al consultar por código "+id);
	        	throw new KrakeException("no existe el codigo "+id);
	        }else {
				System.out.println(r);
			}*/
	    }

	    return r;
	}

	
	public static ArrayList<Categoria> recuperarTodo() throws Exception {
	    ArrayList<Categoria> categorias= new ArrayList<>();
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        con = ConexionBDD.conectar();
	        ps = con.prepareStatement("SELECT * FROM categorias");
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            String codigo = rs.getString("id");
	            String nombre = rs.getString("nombre");
	            Categoria c = new Categoria();
	            c.setId(codigo);
	            c.setNombre(nombre);
	            categorias.add(c);
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

	    return categorias;
	}
}
