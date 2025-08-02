package com.krakedev.inventarios.bdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.Categoria;
import com.krakedev.inventarios.entidades.Producto;
import com.krakedev.inventarios.entidades.UnidadDeMedida;
import com.krakedev.inventarios.excepciones.KrakeDevException;
import com.krakedev.inventarios.utils.ConexionBD;

public class ProductoBDD {
	public ArrayList<Producto> buscar(String subcadena) throws KrakeDevException {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Producto producto = null;
		try {
			con = ConexionBD.obtenerConexion();
			ps = con.prepareStatement("SELECT prod.codigo , prod.nombre as nombre_producto ,"
					+ "udm.codigo_udm as nombre_unidad , " + "udm.descripcion as descripcion_udm , "
					+ "cast ( prod.precio_venta as decimal(5,4)) , prod.tiene_iva , "
					+ "cast ( prod.coste as decimal(5,4)) , prod.categoria , cat.nombre as nombre_categoria , prod.stock "
					+ "FROM productos prod , unidades_medidas udm , categorias cat "
					+ "where prod.udm = udm.codigo_udm and prod.categoria = cat.codigo_cat "
					+ "and upper(prod.nombre) like ? ");
			ps.setString(1, "%" + subcadena.toUpperCase() + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				int codigo = rs.getInt("codigo");
				String nombre_producto = rs.getString("nombre_producto");
				String nombre_unidad = rs.getString("nombre_unidad");
				String descripcion_udm = rs.getString("descripcion_udm");
				BigDecimal precio_venta = rs.getBigDecimal("precio_venta");
				Boolean tiene_iva = rs.getBoolean("tiene_iva");
				BigDecimal coste = rs.getBigDecimal("coste");
				int categoria = rs.getInt("categoria");
				String nombre_categoria = rs.getString("nombre_categoria");
				int stock = rs.getInt("stock");

				UnidadDeMedida udm = new UnidadDeMedida();
				udm.setNombre(nombre_unidad);
				udm.setDescripcion(descripcion_udm);

				Categoria c = new Categoria();
				c.setCodigo(categoria);
				c.setNombre(nombre_categoria);

				producto = new Producto();
				producto.setCodigo(codigo);
				producto.setNombre(nombre_producto);
				producto.setUnidadMedida(udm);
				producto.setPrecioVenta(precio_venta);
				producto.setTieneIva(tiene_iva);
				producto.setCoste(coste);
				producto.setCategoria(c);
				producto.setStock(stock);
				productos.add(producto);
			}

		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar: " + e.getMessage());
		}
		return productos;
	}
	
	public Producto buscarId(int subcadena) throws KrakeDevException {
		Producto productos = new Producto();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Producto producto = null;
		try {
			con = ConexionBD.obtenerConexion();
			ps = con.prepareStatement("SELECT prod.codigo , prod.nombre as nombre_producto ,"
					+ "udm.codigo_udm as nombre_unidad , " + "udm.descripcion as descripcion_udm , "
					+ "cast ( prod.precio_venta as decimal(5,4)) , prod.tiene_iva , "
					+ "cast ( prod.coste as decimal(5,4)) , prod.categoria , cat.nombre as nombre_categoria , prod.stock "
					+ "FROM productos prod , unidades_medidas udm , categorias cat "
					+ "where prod.udm = udm.codigo_udm and prod.categoria = cat.codigo_cat "
					+ "and prod.codigo = ? ");
			ps.setInt(1,subcadena);
			rs = ps.executeQuery();
			while (rs.next()) {
				int codigo = rs.getInt("codigo");
				String nombre_producto = rs.getString("nombre_producto");
				String nombre_unidad = rs.getString("nombre_unidad");
				String descripcion_udm = rs.getString("descripcion_udm");
				BigDecimal precio_venta = rs.getBigDecimal("precio_venta");
				Boolean tiene_iva = rs.getBoolean("tiene_iva");
				BigDecimal coste = rs.getBigDecimal("coste");
				int categoria = rs.getInt("categoria");
				String nombre_categoria = rs.getString("nombre_categoria");
				int stock = rs.getInt("stock");

				UnidadDeMedida udm = new UnidadDeMedida();
				udm.setNombre(nombre_unidad);
				udm.setDescripcion(descripcion_udm);

				Categoria c = new Categoria();
				c.setCodigo(categoria);
				c.setNombre(nombre_categoria);

				producto = new Producto();
				producto.setCodigo(codigo);
				producto.setNombre(nombre_producto);
				producto.setUnidadMedida(udm);
				producto.setPrecioVenta(precio_venta);
				producto.setTieneIva(tiene_iva);
				producto.setCoste(coste);
				producto.setCategoria(c);
				producto.setStock(stock);
				productos = producto;
			}

		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar: " + e.getMessage());
		}
		return productos;
	}

	public void insertar(Producto producto) throws KrakeDevException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConexionBD.obtenerConexion();
			ps = con.prepareStatement("INSERT INTO productos "
					+ "( nombre , udm , precio_venta , tiene_iva , coste , categoria , stock ) VALUES "
					+ "( ? , ? , ? , ? , ? , ? , ? )");
			ps.setString(1, producto.getNombre());
			ps.setString(2, producto.getUnidadMedida().getNombre());
			ps.setBigDecimal(3, producto.getPrecioVenta());
			ps.setBoolean(4, producto.isTieneIva());
			ps.setBigDecimal(5, producto.getCoste());
			ps.setInt(6, producto.getCategoria().getCodigo());
			ps.setInt(7, producto.getStock());
			ps.executeUpdate();
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

	public void actualizar(Producto producto) throws KrakeDevException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConexionBD.obtenerConexion();
			ps = con.prepareStatement("update productos set "
					+ "nombre = ?, udm=?, precio_venta= ?, tiene_iva=?, coste=?, categoria=?, stock=? "
					+ "where codigo = ?; ");
			ps.setString(1, producto.getNombre());
			ps.setString(2, producto.getUnidadMedida().getNombre());
			ps.setBigDecimal(3, producto.getPrecioVenta());
			ps.setBoolean(4, producto.isTieneIva());
			ps.setBigDecimal(5, producto.getCoste());
			ps.setInt(6, producto.getCategoria().getCodigo());
			ps.setInt(7, producto.getStock());
			ps.setInt(8, producto.getCodigo());
			
			int filasAfectadas = ps.executeUpdate();
			
			if (filasAfectadas < 1) {
				throw new KrakeDevException("No se encontró la venta con el número especificado.");
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
}