package com.krakedev.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.entidades.Cliente;
import com.krakedev.excepciones.KrakeDevException;
import com.krakedev.utils.ConexionBD;

public class ClienteBDD {
	public void insertar(Cliente cliente) throws KrakeDevException {
		Connection con = null;
		try {
			con = ConexionBD.obtenerConexion();
			PreparedStatement ps = con
					.prepareStatement("insert into clientes (cedula,nombre,numeroHijos) values " + "(?,?,?)");
			ps.setString(1, cliente.getCedula());
			ps.setString(2, cliente.getNombre());
			ps.setInt(3, cliente.getNumeroHijos());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al inserta cliente: " + e.getMessage());
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

	public void actualizar(Cliente cliente) throws KrakeDevException {
		Connection con = null;
		try {
			con = ConexionBD.obtenerConexion();
			PreparedStatement ps = con.prepareStatement("update clientes set nombre=?,numeroHijos=? where cedula=? ");
			ps.setString(1, cliente.getNombre());
			ps.setInt(2, cliente.getNumeroHijos());
			ps.setString(3, cliente.getCedula());
			int filaEncontrada = ps.executeUpdate();
			if (filaEncontrada == 0) {
				throw new KrakeDevException("Error al actualizar el cliente cedula no existe");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al actualizar el cliente");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Cliente> recuperarTodos() throws KrakeDevException {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Cliente cliente = null;
		try {
			con = ConexionBD.obtenerConexion();
			ps = con.prepareStatement("select cedula,nombre,numeroHijos from clientes ");
			rs = ps.executeQuery();
			while (rs.next()) {
				String cedula = rs.getString("cedula");
				String nombre = rs.getString("nombre");
				int numeroHijos = rs.getInt("numeroHijos");
				cliente = new Cliente(cedula, nombre, numeroHijos);
				clientes.add(cliente);
			}

		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar: " + e.getMessage());
		}
		return clientes;
	}

	public Cliente buscarPorPK(String cedulaCliente) throws KrakeDevException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Cliente cliente = null;
		try {
			con = ConexionBD.obtenerConexion();
			ps = con.prepareStatement("select cedula,nombre,numeroHijos from clientes where cedula=? ");
			ps.setString(1, cedulaCliente);
			rs = ps.executeQuery();
			if (rs.next()) {
				String cedula = rs.getString("cedula");
				String nombre = rs.getString("nombre");
				int numeroHijos = rs.getInt("numeroHijos");
				cliente = new Cliente(cedula, nombre, numeroHijos);
			} else {
				System.out.println("no existe el ciente");
			}

		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar: " + e.getMessage());
		}
		return cliente;
	}

	public ArrayList<Cliente> numeroDeHijos(int cantidad) throws KrakeDevException {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Cliente cliente = null;
		try {
			con = ConexionBD.obtenerConexion();
			ps = con.prepareStatement("select cedula,nombre,numeroHijos from clientes where numeroHijos >= ? ");
			ps.setInt(1, cantidad);
			rs = ps.executeQuery();
			while (rs.next()) {
				String cedula = rs.getString("cedula");
				String nombre = rs.getString("nombre");
				int numeroHijos = rs.getInt("numeroHijos");
				cliente = new Cliente(cedula, nombre, numeroHijos);
				clientes.add(cliente);
			}
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar: " + e.getMessage());
		}
		return clientes;
	}

	/*
	 * ublic void actualizar(Cliente cliente) throws KrakeDevException { Connection
	 * con=null; try { con=ConexionBD.obtenerConexion(); PreparedStatement ps=con.
	 * prepareStatement("update clientes set nombre=?,numeroHijos=? where cedula=? "
	 * ); ps.setString(1, cliente.getNombre()); ps.setInt(2,
	 * cliente.getNumeroHijos()); ps.setString(3, cliente.getCedula()); int
	 * filaEncontrada=ps.executeUpdate(); if(filaEncontrada==0) { throw new
	 * KrakeDevException("Error al actualizar el cliente cedula no existe"); } }
	 * catch (Exception e) { e.printStackTrace(); throw new
	 * KrakeDevException("Error al actualizar el cliente");
	 * 
	 * }catch (KrakeDevException e) { // TODO Auto-generated catch block throw e; }
	 * }
	 */
}
