package com.krakedev.persistencia.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConexionBDD {
	private static final Logger LOGGER=LogManager.getLogger(ConexionBDD.class);
	private static final String DRIVER="org.postgresql.Driver";
	private static final String URL="jdbc:postgresql://localhost:5432/postgres";
	private static final String USER="postgres";
	private static final String PASS="admin";
	public static Connection conectar() throws Exception{
		Connection connection=null;
		try {
			Class.forName(DRIVER);
			connection=DriverManager.getConnection(URL,USER,PASS);
			LOGGER.debug("Conexion exitosa");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Error al conectarse, revise usuraio y clave",e);
			throw new Exception("Error al conectarse, revise usuraio y clave");
		} 
		return connection;
	}
}
