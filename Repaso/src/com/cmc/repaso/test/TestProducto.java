package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Producto;

public class TestProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Producto p=new Producto("Pasta", 0.80);
		p.setPrecio(-10);
		double descuento= p.CalcularPrecioPromo(10);
		System.out.println(" "+p.getNombre()+" "+p.getPrecio());
		System.out.println(" "+p.getPrecio()+" "+descuento);
	}

}
