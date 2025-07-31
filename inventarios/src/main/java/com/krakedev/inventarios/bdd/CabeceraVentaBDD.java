package com.krakedev.inventarios.bdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.krakedev.inventarios.entidades.CabeceraVenta;
import com.krakedev.inventarios.entidades.DetalleVenta;
import com.krakedev.inventarios.excepciones.KrakeDevException;
import com.krakedev.inventarios.utils.ConexionBD;

public class CabeceraVentaBDD {
	public void insertar (CabeceraVenta venta) throws KrakeDevException{
		BigDecimal totalIva= BigDecimal.ZERO;
		BigDecimal totalSinIva= BigDecimal.ZERO;
		Connection con=null;
		PreparedStatement ps=null;
		PreparedStatement ps2=null;
		PreparedStatement ps3=null;
		PreparedStatement ps4=null;
		PreparedStatement psHs = null;
		ResultSet rsClave = null;
		int codigoCabecera=0;
		BigDecimal subt=BigDecimal.ZERO;
		try {
			con = ConexionBD.obtenerConexion();
			ps = con.prepareStatement(" INSERT INTO cabecera_ventas ( fecha, total_sin_iva, total_con_iva, total)"
					+ " VALUES "
					+ "( ? , ? , ? , ? );",Statement.RETURN_GENERATED_KEYS);
			Date fechaActual=new Date();
			java.sql.Timestamp fechaHoraActual = new java.sql.Timestamp(fechaActual.getTime());
			ps.setTimestamp(1, fechaHoraActual);
			ps.setBigDecimal(2, BigDecimal.ZERO);
			ps.setBigDecimal(3, BigDecimal.ZERO);
			ps.setBigDecimal(4, BigDecimal.ZERO);
			ps.executeUpdate();
			rsClave = ps.getGeneratedKeys();
			if (rsClave.next()) {
				codigoCabecera = rsClave.getInt(1);
			}
			ArrayList<DetalleVenta> detallesVenta = venta.getDetalles();
            for (DetalleVenta dp : detallesVenta) {
                // Validar datos de entrada
                if (dp.getPrecioVenta() == null || dp.getCantidad() <= 0) {
                    throw new KrakeDevException("El precio de venta o la cantidad no son válidos.");
                }

                // Calcular subtotal
                subt = dp.getProductos().getPrecioVenta().multiply(new BigDecimal(dp.getCantidad()));

                ps2 = con.prepareStatement("INSERT INTO detalle_ventas "
                        + "(id_cabecera_ventas, id_producto, cantidad, precio_venta, subtotal, subtotal_con_iva) "
                        + "VALUES (?, ?, ?, ?, ?, ?);");
                ps2.setInt(1, codigoCabecera);
                ps2.setInt(2, dp.getProductos().getCodigo());
                ps2.setInt(3, dp.getCantidad());
                ps2.setBigDecimal(4, dp.getProductos().getPrecioVenta());
                ps2.setBigDecimal(5, subt);

                if (dp.getProductos().isTieneIva()) {
                    BigDecimal subtotalConIva = subt.multiply(new BigDecimal("1.12"));
                    ps2.setBigDecimal(6, subtotalConIva);
                    totalIva = totalIva.add(subtotalConIva);
                } else {
                    ps2.setBigDecimal(6, subt);
                    totalSinIva = totalSinIva.add(subt);
                }

                ps2.executeUpdate();
			
			psHs=con.prepareStatement("INSERT INTO historial_stock "
					+ "( fecha, referencia, id_producto, cantidad) "
					+ "VALUES "
					+ "( ? , ? , ? , ? )");
			
			psHs.setTimestamp(1, fechaHoraActual);
			psHs.setString(2, "Pedido "+codigoCabecera);
			psHs.setInt(3, dp.getProductos().getCodigo());
			psHs.setInt(4, dp.getCantidad());
			
			psHs.executeUpdate();
			
			
			}
			
			ps3=con.prepareStatement("update cabecera_ventas set "
					+ "total_sin_iva = ?, total_con_iva = ?, total = ? "
					+ "where codigo = ? ;");
			ps3.setBigDecimal(1, totalSinIva);
			ps3.setBigDecimal(2, totalIva);
			ps3.setBigDecimal(3, totalSinIva.add(totalIva));
			ps3.setInt(4, codigoCabecera);
			
			int filasAfectadas = ps3.executeUpdate();

			if (filasAfectadas < 1) {
				throw new KrakeDevException("No se encontró la venta con el número especificado.");
			}
			
			for (DetalleVenta dp : detallesVenta) {
				ps4=con.prepareStatement(" INSERT INTO historial_stock "
						+ "( fecha, referencia, id_producto, cantidad) VALUES "
						+ "( ? , ? , ? , ? ) ;");
				ps4.setTimestamp(1, fechaHoraActual);
				ps4.setString(2, "Venta "+codigoCabecera);
				ps4.setInt(3, dp.getProductos().getCodigo());
				ps4.setInt(4, dp.getCantidad()*-1);
				
				int filasAfectadasHs = ps4.executeUpdate();
				
				if (filasAfectadasHs < 1) {
					throw new KrakeDevException("No se encontró la venta con el número especificado.");
				}
				}	
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al insertar productos " + e.getMessage());
		}
	}
}
