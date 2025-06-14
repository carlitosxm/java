package com.krakedev.demo.test;
import com.krakedev.demo.Producto;

public class TestPtoducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Producto p=new Producto(1, "Pasta");
		p.setDescripcion("Pasta de dientes");
		p.setPeso(1);
		System.out.println("--------Producto--------");
		System.out.println("Codigo: "+p.getCodigo());
		System.out.println("Nombre: "+p.getNombre());
		System.out.println("Descripción: "+p.getDescripcion());
		System.out.println("Peso: "+p.getPeso());
	}

}
