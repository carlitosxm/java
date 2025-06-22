package com.clearminds.test;

import java.util.ArrayList;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;
import com.clearminds.maquina.MaquinaDulces;

public class TestBuscarMenos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaquinaDulces maquina=new MaquinaDulces();
		ArrayList<Producto> pro=new ArrayList<Producto>();
		maquina.agregarCelda(new Celda("A1"));
		maquina.agregarCelda(new Celda("B1"));
		maquina.agregarCelda(new Celda("C1"));
		maquina.agregarCelda(new Celda("D1"));
		maquina.agregarCelda(new Celda("E1"));
		maquina.agregarCelda(new Celda("F1"));

		Producto p1=new Producto("BE10", "Papitas", 0.85);
		Producto p2=new Producto("BE11", "Doritos", 0.5);
		Producto p3=new Producto("BE12", "Jet", 0.25);
		Producto p4=new Producto("BE13", "DeTodito", 0.6);
		Producto p5=new Producto("BE14", "Coca Cola", 1.85);
		Producto p6=new Producto("BE15", "Pepsi", 2.85);
		maquina.cargarProducto(p1, "A1",10);
		maquina.cargarProducto(p2, "B1",10);
		maquina.cargarProducto(p3, "C1",10);
		maquina.cargarProducto(p4, "D1",10);
		maquina.cargarProducto(p5, "E1",10);
		maquina.cargarProducto(p6, "F1",10);
		
		pro=maquina.buscarMenor(1);
		
		if(pro != null) {
		System.out.println("Productos Menores: "+(pro.size()+1));
		for(int i=0;i<pro.size();i++) {
			Producto productoSeleccionado=pro.get(i);
				System.out.println("Nombre: "+productoSeleccionado.getNombre()+" Precio:"+productoSeleccionado.getPrecio());
			}
		}
		
	}

}
