package com.krakedev.inventarios.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.Categoria;
import com.krakedev.inventarios.excepciones.KrakeDevException;
import com.krakedev.inventarios.utils.ConexionBD;


public class CategoriaBDD {
	public void insertar(Categoria categoria) throws KrakeDevException{
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=ConexionBD.obtenerConexion();
			ps=con.prepareStatement("INSERT INTO categorias ( nombre, categoria_padre) VALUES "
					+ "( ? , ? )");
			ps.setString(1, categoria.getNombre());
			ps.setInt(2, categoria.getCategoriaPadre().getCodigo());
			ps.executeUpdate();
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al insertar productos" + e.getMessage());
		}
	}
	
	public void actualizar(Categoria categoria) throws KrakeDevException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConexionBD.obtenerConexion();
			ps = con.prepareStatement("update categorias set nombre = ? where codigo_cat = ? ;");
			ps.setString(1, categoria.getNombre());
			ps.setInt(2, categoria.getCodigo());
			
			int filasAfectadas = ps.executeUpdate();
			
			if (filasAfectadas < 1) {
				throw new KrakeDevException("No se encontró la categoria con el número especificado.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al inserta proveedor: " + e.getMessage());
		} catch (KrakeDevException e) {
			// TODO Auto-generated catch block
			throw e;

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public ArrayList<Categoria> recuperar() throws KrakeDevException{
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		Categoria categoria=null;
		try {
			con=ConexionBD.obtenerConexion();
			ps=con.prepareStatement("SELECT "
					+ "    c1.codigo_cat AS codigo_categoria, "
					+ "    c1.nombre AS nombre_categoria, "
					+ "    c1.categoria_padre AS codigo_padre, "
					+ "    c2.nombre AS nombre_padre "
					+ "FROM  "
					+ "    categorias c1 "
					+ "LEFT JOIN  "
					+ "    categorias c2 "
					+ "ON  "
					+ "    c1.categoria_padre = c2.codigo_cat;");
			rs = ps.executeQuery();
			
			rs = ps.executeQuery();
			while (rs.next()) {
				int codigo_categoria = rs.getInt("codigo_categoria");
				String nombre_categoria = rs.getString("nombre_categoria");
				int codigo_padre = rs.getInt("codigo_padre");
				String nombre_padre = rs.getString("nombre_padre");
				
				Categoria c = new Categoria();
				c.setCodigo(codigo_padre);
				c.setNombre(nombre_padre);

				categoria = new Categoria();
				categoria.setCodigo(codigo_categoria);
				categoria.setNombre(nombre_categoria);
				categoria.setCategoriaPadre(c);
				categorias.add(categoria);
			}
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al insertar productos" + e.getMessage());
		}
		
		System.out.println(categorias);
		return categorias;
		
	}
	
}
