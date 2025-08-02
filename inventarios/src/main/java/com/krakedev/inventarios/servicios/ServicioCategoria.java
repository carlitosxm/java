package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.CategoriaBDD;
import com.krakedev.inventarios.entidades.Categoria;
import com.krakedev.inventarios.excepciones.KrakeDevException;

@Path("categorias")
public class ServicioCategoria {

	@Path("insertar")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar(Categoria categoria) {
		System.out.println(">>>>>>>>>>>>"+categoria);
		CategoriaBDD prod=new CategoriaBDD();
		try {
			prod.insertar(categoria);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	
	@Path("actualizar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Categoria categoria) {
		System.out.println(">>>>>>>>>>>>"+categoria);
		CategoriaBDD prod=new CategoriaBDD();
		try {
			prod.actualizar(categoria);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("recuperar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response recuperar() {
		CategoriaBDD cat=new CategoriaBDD();
		ArrayList<Categoria> categorias=null;
		try {
			categorias=cat.recuperar();
			return Response.ok(categorias).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
