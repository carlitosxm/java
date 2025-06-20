package com.clearminds.maquina;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;

public class MaquinaDulces {
	private Celda celda1;
	private Celda celda2;
	private Celda celda3;
	private Celda celda4;
	private double saldo;
	
	public void configurarMaquina(String cod1,String cod2,String cod3,String cod4) {
		celda1=new Celda(cod1);
		celda2=new Celda(cod2);
		celda3=new Celda(cod3);
		celda4=new Celda(cod4);
	}
	public void mostrarConfiguracion() {
		System.out.println("CELDA 1:"+celda1.getCodigo());
		System.out.println("CELDA 2:"+celda2.getCodigo());
		System.out.println("CELDA 3:"+celda3.getCodigo());
		System.out.println("CELDA 4:"+celda4.getCodigo());
	}
	
	public Celda buscarCelda(String codigoCelda) {
		if (celda1.getCodigo().equals(codigoCelda)) {
			return celda1;
		} else if (celda2.getCodigo().equals(codigoCelda)) {
			return celda2;
		} else if (celda3.getCodigo().equals(codigoCelda)) {
			return celda3;
		} else if (celda4.getCodigo().equals(codigoCelda)) {
			return celda4;
		} else {
			return null;
		}
	}
	
	public void cargarProducto(Producto produc,String codCelda, int cantidad) {
		Celda celdaRecuperada=buscarCelda(codCelda);
		celdaRecuperada.ingresarProducto(produc, cantidad);
	}
	
	public void mostrarProductos() {
		System.out.println("************Celda "+celda1.getCodigo());
		System.out.println("Stock: "+celda1.getStock());
		if(celda1.getStock()!=0) {
			System.out.println("Nombre Producto: "+celda1.getProducto().getNombre());
			System.out.println("Precio Producto: "+celda1.getProducto().getPrecio());
			System.out.println("Código Producto: "+celda1.getProducto().getCodigo());
		}else {
			System.out.println("La celda no tiene producto!!");
		}
		System.out.println("************Celda "+celda2.getCodigo());
		System.out.println("Stock: "+celda2.getStock());
		if(celda2.getStock()!=0) {
			System.out.println("Nombre Producto: "+celda2.getProducto().getNombre());
			System.out.println("Precio Producto: "+celda2.getProducto().getPrecio());
			System.out.println("Código Producto: "+celda2.getProducto().getCodigo());	
		}else {
			System.out.println("La celda no tiene producto!!");
		}
		System.out.println("************Celda "+celda3.getCodigo());
		System.out.println("Stock: "+celda3.getStock());
		if(celda3.getStock()!=0) {
			System.out.println("Nombre Producto: "+celda3.getProducto().getNombre());
			System.out.println("Precio Producto: "+celda3.getProducto().getPrecio());
			System.out.println("Código Producto: "+celda3.getProducto().getCodigo());	
		}else {
			System.out.println("La celda no tiene producto!!");
		}
		System.out.println("************Celda "+celda4.getCodigo());
		System.out.println("Stock: "+celda4.getStock());
		if(celda4.getStock()!=0) {
			System.out.println("Nombre Producto: "+celda4.getProducto().getNombre());
			System.out.println("Precio Producto: "+celda4.getProducto().getPrecio());
			System.out.println("Código Producto: "+celda4.getProducto().getCodigo());	
		}else {
			System.out.println("La celda no tiene producto!!");
		}
		
		System.out.println("Saldo: "+getSaldo());
	}
	
	public Producto buscarProductoEnCelda(String codCelda) {
		if (celda1.getCodigo().equals(codCelda)) {
			return celda1.getProducto();
		} else if (celda2.getCodigo().equals(codCelda)) {
			return celda2.getProducto();
		} else if (celda3.getCodigo().equals(codCelda)) {
			return celda3.getProducto();
		} else if (celda4.getCodigo().equals(codCelda)) {
			return celda4.getProducto();
		} else {
			return null;
		}
	}
	
	public double consultarPrecio(String codCelda) {
		if (celda1.getCodigo().equals(codCelda)) {
			return celda1.getProducto().getPrecio();
		} else if (celda2.getCodigo().equals(codCelda)) {
			return celda2.getProducto().getPrecio();
		} else if (celda3.getCodigo().equals(codCelda)) {
			return celda3.getProducto().getPrecio();
		} else if (celda4.getCodigo().equals(codCelda)) {
			return celda4.getProducto().getPrecio();
		} else {
			return 0;
		}
	}
	
	public Celda buscarCeldaProducto(String codProducto) {
		if (celda1.getProducto() != null && celda1.getProducto().getCodigo().equals(codProducto)) {
			return celda1;
		} else if (celda2.getProducto() != null && celda2.getProducto().getCodigo().equals(codProducto)) {
			return celda2;
		} else if (celda3.getProducto() != null && celda3.getProducto().getCodigo().equals(codProducto)) {
			return celda3;
		} else if (celda4.getProducto() != null && celda4.getProducto().getCodigo().equals(codProducto)) {
			return celda4;
		} else {
			return null;
		}
	}
	
	public void incrementarProductos(String codigo, int incrementar) {
		Celda celdaEncontrada=buscarCeldaProducto(codigo);
		int stock=celdaEncontrada.getStock();
		celdaEncontrada.setStock(stock+=incrementar);
	}
	
	public void vender(String codigoCelda) {
		Celda celdaEncontrada=buscarCelda(codigoCelda);
		int stock=celdaEncontrada.getStock();
		celdaEncontrada.setStock(stock-=1);
		double precioProducto=celdaEncontrada.getProducto().getPrecio();
		double saldoActual=this.saldo;
		setSaldo(saldoActual+=precioProducto);
	}
	
	public double venderConCambio(String codigoCelda, double valor) {
		Celda celdaEncontrada=buscarCelda(codigoCelda);
		int stock=celdaEncontrada.getStock();
		celdaEncontrada.setStock(stock-=1);
		double precioProducto=celdaEncontrada.getProducto().getPrecio();
		this.saldo+=precioProducto;
		return valor-precioProducto;
	}
	
	public Celda getCelda1() {
		return celda1;
	}
	public void setCelda1(Celda celda1) {
		this.celda1 = celda1;
	}
	public Celda getCelda2() {
		return celda2;
	}
	public void setCelda2(Celda celda2) {
		this.celda2 = celda2;
	}
	public Celda getCelda3() {
		return celda3;
	}
	public void setCelda3(Celda celda3) {
		this.celda3 = celda3;
	}
	public Celda getCelda4() {
		return celda4;
	}
	public void setCelda4(Celda celda4) {
		this.celda4 = celda4;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
}
