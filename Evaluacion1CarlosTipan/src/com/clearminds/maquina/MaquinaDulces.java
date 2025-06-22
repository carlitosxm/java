package com.clearminds.maquina;

import java.util.ArrayList;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;

public class MaquinaDulces {
	private ArrayList<Celda> celdas;
	private double saldo;

	public MaquinaDulces() {
		celdas = new ArrayList<Celda>();
	}

	public void agregarCelda(Celda cel) {
		celdas.add(cel);
	}

	public void mostrarConfiguracion() {
		for (int i = 0; i < celdas.size(); i++) {
			System.out.println("Celda" + (i + 1) + ":" + celdas.get(i).getCodigo());
		}
	}

	public Celda buscarCelda(String cod) {
		Celda celdaEncontrada = null;
		for (int i = 0; i < celdas.size(); i++) {
			if (celdas.get(i).getCodigo().equals(cod)) {
				celdaEncontrada = celdas.get(i);
			}
		}
		return celdaEncontrada;
	}

	public void cargarProducto(Producto p, String cod, int cantidad) {
		Celda celdaRecuperada = buscarCelda(cod);
		celdaRecuperada.setProducto(p);
		celdaRecuperada.setStock(cantidad);
	}

	public void mostrarProductos() {
		for (int i = 0; i < celdas.size(); i++) {
			Celda celda=celdas.get(i);
			if (celda.getStock() > 0 && celda.getProducto() != null) {
				System.out.println("Celda:" + celdas.get(i).getCodigo() + " Stock:"
						+ celda.getStock() + " Producto:" + celda.getProducto().getCodigo() + " Precio:"
						+ celda.getProducto().getPrecio());
			} else {
				System.out.println("Celda:" + celda.getCodigo() + " Stock:"
						+ celda.getStock() + " Sin Producto asignado");
			}
		}
		System.out.println("Saldo: "+saldo);
	}
	
	public Producto buscarProductoEnCelda(String cod) {
		Producto productoEncontrado=null;
		for(int i=0;i<celdas.size();i++) {
			Celda celda=celdas.get(i);
			if(celda.getCodigo().equals(cod)) {
				productoEncontrado=celda.getProducto();
			}
		}
		return productoEncontrado;	
	}
	
	public Celda buscarCeldaProducto(String cod) {
		Celda productoEncontrado=null,celda=null;
		for(int i=0;i<celdas.size();i++) {
			celda=celdas.get(i);
			if(celda.getProducto() != null && celda.getProducto().getCodigo().equals(cod)) {
				productoEncontrado=celda;
			}
		}
		return productoEncontrado;
	}
	
	public void incrementarProductos(String cod,int cantidad){
		Celda celdaEncontrada=buscarCeldaProducto(cod);
		celdaEncontrada.setStock(cantidad+celdaEncontrada.getStock());
	}
	
	public void vender(String cod) {
		Celda celdaEncontrada=buscarCelda(cod);
		celdaEncontrada.setStock(celdaEncontrada.getStock()-1);
		saldo+=celdaEncontrada.getProducto().getPrecio();
	}
	
	public double venderConCambio(String codcelda, double valor) {
		vender(codcelda);
		double cambio=valor-saldo;
		saldo=0;
		return cambio;
	}
	
	public ArrayList<Producto> buscarMenor(double limite){
		ArrayList<Producto> productosEncontrados=new  ArrayList();
		for (int i=0;i<celdas.size();i++) {
			Celda celda=celdas.get(i);
			if(celda.getProducto() != null && celda.getProducto().getPrecio()<=limite) {
				productosEncontrados.add(celda.getProducto());
			}
		}
		return productosEncontrados;
	}
}
