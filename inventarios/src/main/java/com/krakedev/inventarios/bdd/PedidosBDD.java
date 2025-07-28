package com.krakedev.inventarios.bdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.krakedev.inventarios.entidades.DetallePedido;
import com.krakedev.inventarios.entidades.Pedido;
import com.krakedev.inventarios.excepciones.KrakeDevException;
import com.krakedev.inventarios.utils.ConexionBD;

public class PedidosBDD {
	public void insertar(Pedido pedido) throws KrakeDevException {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement psDet = null;
		ResultSet rsClave = null;
		int codigoCabecera = 0;
		try {
			con = ConexionBD.obtenerConexion();
			ps = con.prepareStatement(
					"INSERT INTO cabecera_pedidos ( id_proveedor , fecha , id_estado ) VALUES " + " ( ? , ? , ? ); ",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, pedido.getProveedor().getIdentificador());
			Date fechaActual = new Date();
			java.sql.Date fechaSQL = new java.sql.Date(fechaActual.getTime());
			ps.setDate(2, fechaSQL);
			ps.setString(3, "S");
			ps.executeUpdate();
			rsClave = ps.getGeneratedKeys();
			if (rsClave.next()) {
				codigoCabecera = rsClave.getInt(1);
			}

			ArrayList<DetallePedido> detallesPedido = pedido.getDetalles();
			DetallePedido det;
			for (int i = 0; i < detallesPedido.size(); i++) {
				det = detallesPedido.get(i);
				psDet = con.prepareStatement("INSERT INTO detalle_pedidos "
						+ "(id_cabecera_pedido, id_producto, cantidad, subtotal, cantidad_recibida) VALUES "
						+ "( ?, ?, ?, ?, ?);");
				psDet.setInt(1, codigoCabecera);
				psDet.setInt(2, det.getProducto().getCodigo());
				psDet.setInt(3, det.getCantidadSolicitada());

				BigDecimal pv = det.getProducto().getPrecioVenta();
				BigDecimal cantidad = new BigDecimal(det.getCantidadSolicitada());
				BigDecimal subtoral = pv.multiply(cantidad);
				psDet.setBigDecimal(4, subtoral);
				psDet.setInt(5, 0);

				psDet.executeUpdate();

			}

		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al insertar productos" + e.getMessage());
		}
	}

	public void recibir(Pedido pedido) throws KrakeDevException {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement psDec = null;
		try {
			con = ConexionBD.obtenerConexion();
			ps = con.prepareStatement(" update cabecera_pedidos set id_estado='R' where numero = ? ; ");
			ps.setInt(1, pedido.getNumero());
			
			System.out.println(pedido.getNumero());

			int filasAfectadas = ps.executeUpdate();

			if (filasAfectadas < 1) {
				throw new KrakeDevException("No se encontró el pedido con el número especificado.");
			}

			psDec = con.prepareStatement(" update detalle_pedidos set cantidad_recibida = ? , subtotal = ? where codigo = ? ;");
			ArrayList<DetallePedido> detallesPedido = pedido.getDetalles();
			DetallePedido dep;
			for (int i = 0; i < detallesPedido.size(); i++) {
				dep = detallesPedido.get(i);
				psDec.setInt(1, dep.getCantidadRecibida());
				BigDecimal pv = dep.getProducto().getPrecioVenta();
				BigDecimal cantidad = new BigDecimal(dep.getCantidadRecibida());
				BigDecimal subtotal = pv.multiply(cantidad);
				psDec.setBigDecimal(2, subtotal);
				psDec.setInt(3, dep.getCodigo());

				int filasAfectadas2 = psDec.executeUpdate();

				if (filasAfectadas2 < 1) {
					throw new KrakeDevException("No se encontró el detalle de pedido con el número especificado.");
				}

			}

		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al insertar productos" + e.getMessage());
		}
	}

}