package com.cmc.evaluacion.servicios;

import java.util.ArrayList;

import com.cmc.evaluacion.entidades.Cliente;
import com.cmc.evaluacion.entidades.Prestamo;

public class Banco {
	private ArrayList<Prestamo> prestamos;
	private ArrayList<Cliente> clientes;
	public Banco() {
		clientes=new ArrayList<Cliente>();
		prestamos=new ArrayList<Prestamo>();
	}
	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	public Cliente buscarCliente(String cedula) {
		for (Cliente cliente : clientes) {
	        if (cliente.getCedula().equals(cedula)) {
	            return cliente; 
	        }
	    }
		return null;
	}
	public void registrarCliente(Cliente cliente) {
		if(buscarCliente(cliente.getCedula())==null) {
			clientes.add(cliente);
		}else {
			System.out.println("Cliente ya existe :"+cliente.getCedula());
		}
	}
	
	public void asignarPrestamo(String cedula, Prestamo prestamo) {
		Cliente cliente = buscarCliente(cedula);
		if(cliente==null) {
			System.out.println("no es cliente del banco");
		}else {
			CalculadoraAmortizacion.generarTabla(prestamo);
			prestamos.add(prestamo);
			cliente.getPrestamos().add(prestamo); 
		}
	}
	
	public ArrayList<Prestamo> buscarPrestamos(String cedula) {
	    Cliente cliente = buscarCliente(cedula);
	    if (cliente != null && !cliente.getPrestamos().isEmpty()) {
	        return cliente.getPrestamos();
	    }
	    return new ArrayList<>(); // Retorna lista vacía si no hay préstamos o cliente no existe
	}
}
