package com.krakedev.inventarios.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.krakedev.inventarios.excepciones.KrakeDevException;

public class ConexionBD {
	public static Connection obtenerConexion() throws KrakeDevException {
		Context ctx=null;
		DataSource ds=null;
		Connection con=null;
			try {
				ctx = new InitialContext();
				//JNDI
				ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/inventarios");
				con = ds.getConnection();
			} catch (NamingException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new KrakeDevException("Error de conexción");
			} 
			return con;
			
	}
}
