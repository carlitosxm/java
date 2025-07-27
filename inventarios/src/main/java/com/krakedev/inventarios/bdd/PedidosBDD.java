package com.krakedev.inventarios.bdd;

import java.sql.Statement;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		PreparedStatement psDet=null;
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
			
			ArrayList<DetallePedido> detallesPedido= pedido.getDetalles();
			DetallePedido det;
			for(int i=0;i<detallesPedido.size();i++) {
				det = detallesPedido.get(i);
				psDet=con.prepareStatement("INSERT INTO detalle_pedidos "
						+ "(id_cabecera_pedido, id_producto, cantidad, subtotal, cantidad_recibida) VALUES "
						+ "( ?, ?, ?, ?, ?);");
				psDet.setInt(1, codigoCabecera);
				psDet.setInt(2, det.getProducto().getCodigo());
				psDet.setInt(3, det.getCantidadSolicitada());
				psDet.setInt(4, 0);
				BigDecimal pv=det.getProducto().getPrecioVenta();
				BigDecimal cantidad = new BigDecimal(det.getCantidadSolicitada());
				BigDecimal subtoral=pv.multiply(cantidad);
				psDet.setBigDecimal(5, subtoral);
				
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
}
