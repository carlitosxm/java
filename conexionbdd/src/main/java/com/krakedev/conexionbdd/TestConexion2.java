package com.krakedev.conexionbdd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestConexion2 {

	public static void main(String[] args) {
//////registro empleado
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
			System.out.println("Conexion exitosa");

			ps = connection.prepareStatement("INSERT INTO empleado (codigo_empleado, nombre, fecha, hora)"
					+ " VALUES (?, ?, ?, ?)");
			ps.setInt(1,5741);
			ps.setString(2, "Prueba");
			
			try {
				//////// alternativa para fecha y hora
				SimpleDateFormat s = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				String fechaSTR = "2020/03/22 10:05:04";
				java.util.Date fecha = s.parse(fechaSTR);

				java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
				Time timeSQL = new Time(fecha.getTime());

				ps.setDate(3, fechaSQL);
				ps.setTime(4, timeSQL);

				ps.executeUpdate();
				System.out.println("Insert ejecutado correctamente");
			} catch (ParseException e) {
				System.out.println("Error al convertir la fecha");
				e.printStackTrace();
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
////////////registro entrada

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
			System.out.println("Conexion exitosa");

			ps = connection.prepareStatement("INSERT INTO registros_entrada (codigo_registro, cedula_empleado, fecha, hora, codigo_empleado)"
					+ " VALUES (?, ?, ?, ?, ?)");
			ps.setInt(1,11);
			ps.setString(2, "1425879630");
			

			try {
				//////// alternativa para fecha y hora 
				SimpleDateFormat s = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				String fechaSTR = "2020/03/22 10:05:04";
				java.util.Date fecha = s.parse(fechaSTR);

				java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
				Time timeSQL = new Time(fecha.getTime());

				ps.setDate(3, fechaSQL);
				ps.setTime(4, timeSQL);
				ps.setInt(5, 5741);

				ps.executeUpdate();
				System.out.println("Insert ejecutado correctamente");
			} catch (ParseException e) {
				System.out.println("Error al convertir la fecha");
				e.printStackTrace();
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}