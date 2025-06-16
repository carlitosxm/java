package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Item;

public class TestItem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Item i=new Item();
		i.setNombre("Pasta");
		i.setProductosActuales(200);
		i.setProductosDevueltos(0);
		i.setProductosVendidos(70);
		System.out.println("-------Creación----------");
		i.imprimir();
		System.out.println("-------Método Vender-------10 unidades");
		i.vender(10);
		i.imprimir();
		System.out.println("-------Método Devolver-------20 unidades");
		i.devolver(20);
		i.imprimir();
	}

}
