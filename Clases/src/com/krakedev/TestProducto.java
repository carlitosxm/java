package com.krakedev;

public class TestProducto {
	public static void main(String[] args) {
		Producto productoA = new Producto();
		productoA.setNombre("Finalin");
		productoA.setDescripcion("Dolor de cabeza");
		productoA.setPrecio(0.5f);
		productoA.setStockActual(120);

		Producto productoB = new Producto();
		productoB.setNombre("Neumoflux");
		productoB.setDescripcion("Flema");
		productoB.setPrecio(20.0f);
		productoB.setStockActual(10);

		Producto productoC = new Producto();
		productoC.setNombre("Heterogermina");
		productoC.setDescripcion("Flora intestinal");
		productoC.setPrecio(0.8f);
		productoC.setStockActual(250);

		System.out.println(" PRODUCTO 1");
		System.out.println("Nombre: " + productoA.getNombre());
		System.out.println("Descripcion: " + productoA.getDescripcion());
		System.out.println("Precio: " + productoA.getPrecio());
		System.out.println("Stock: " + productoA.getStockActual());
		System.out.println("-------------------------------------");

		System.out.println(" PRODUCTO 2");
		System.out.println("Nombre: " + productoB.getNombre());
		System.out.println("Descripcion: " + productoB.getDescripcion());
		System.out.println("Precio: " + productoB.getPrecio());
		System.out.println("Stock: " + productoB.getStockActual());
		System.out.println("-------------------------------------");

		System.out.println(" PRODUCTO 3");
		System.out.println("Nombre: " + productoC.getNombre());
		System.out.println("Descripcion: " + productoC.getDescripcion());
		System.out.println("Precio: " + productoC.getPrecio());
		System.out.println("Stock: " + productoC.getStockActual());
		System.out.println("-------------------------------------");
	}
}
