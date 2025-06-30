package com.krakedev.conexionbdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestConexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement ps=null;
		try {
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","admin");
			System.out.println("Conexion exitosa");
			ps=connection.prepareStatement("insert into personas (cedula, nombre, apellido,estado_civil_codigo,numero_hijos,estatura,cantidad_ahorrada,fecha_nacimiento,hora_nacimientos)"
					+"values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, "1721949756");
			ps.setString(2, "Carlos");
			ps.setString(3, "Tipan");
			ps.setString(4, "U");
			ps.setInt(5, 2);
			ps.setDouble(6, 1.50);
			ps.setBigDecimal(7, new BigDecimal(1200.45));
			
			SimpleDateFormat s=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			String fechaSTR="2020/03/22 10:05:04";
			try {
				Date fecha=s.parse(fechaSTR);
				System.out.println(fecha);
				long fechaMilis=fecha.getTime();
				System.out.println(fechaMilis);
				//crear u java .sqlDara, partiendo de un java.util.Date
				java.sql.Date fechaSQL = new java.sql.Date(fechaMilis);
				System.out.println(fechaSQL);
				
				
				Time timeSQL=new Time(fechaMilis);
				System.out.println(timeSQL);
				
				ps.setDate(8, fechaSQL);
				ps.setTime(9, timeSQL);
				
				ps.executeUpdate();
				System.out.println("executa insert");
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
