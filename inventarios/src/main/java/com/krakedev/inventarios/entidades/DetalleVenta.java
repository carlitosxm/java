package com.krakedev.inventarios.entidades;

import java.math.BigDecimal;

public class DetalleVenta {
	private int codigo;
	private CabeceraVenta cabeceraVenta;
	private Producto productos;
	private int cantidad;
	private BigDecimal precioVenta = BigDecimal.ZERO;
	private BigDecimal subtotal = BigDecimal.ZERO;
	private BigDecimal subtotalConIva = BigDecimal.ZERO;
	public DetalleVenta() {
		super();
	}
	public DetalleVenta(int codigo, CabeceraVenta cabeceraVenta, Producto productos, int cantidad,
			BigDecimal precioVenta, BigDecimal subtotal, BigDecimal subtotalConIva) {
		super();
		this.codigo = codigo;
		this.cabeceraVenta = cabeceraVenta;
		this.productos = productos;
		this.cantidad = cantidad;
		this.precioVenta = precioVenta;
		this.subtotal = subtotal;
		this.subtotalConIva = subtotalConIva;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public CabeceraVenta getCabeceraVenta() {
		return cabeceraVenta;
	}
	public void setCabeceraVenta(CabeceraVenta cabeceraVenta) {
		this.cabeceraVenta = cabeceraVenta;
	}
	public Producto getProductos() {
		return productos;
	}
	public void setProductos(Producto productos) {
		this.productos = productos;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	public BigDecimal getSubtotalConIva() {
		return subtotalConIva;
	}
	public void setSubtotalConIva(BigDecimal subtotalConIva) {
		this.subtotalConIva = subtotalConIva;
	}
	@Override
	public String toString() {
		return "DetalleVenta [codigo=" + codigo + ", cabeceraVenta=" + cabeceraVenta + ", productos=" + productos
				+ ", cantidad=" + cantidad + ", precioVenta=" + precioVenta + ", subtotal=" + subtotal
				+ ", subtotalConIva=" + subtotalConIva + "]";
	}
	
}
