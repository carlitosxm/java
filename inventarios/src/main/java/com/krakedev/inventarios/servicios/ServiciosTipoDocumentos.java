package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.TipoDocumentoBDD;
import com.krakedev.inventarios.entidades.TipoDocumento;
import com.krakedev.inventarios.excepciones.KrakeDevException;

@Path ("tipoDocumentos")
public class ServiciosTipoDocumentos {
	@Path("mostrar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(){
		TipoDocumentoBDD tipDocBDD=new TipoDocumentoBDD();
		ArrayList<TipoDocumento> tipoDocumentos=null;
		try {
			tipoDocumentos = tipDocBDD.mostrarTodo();
			return Response.ok(tipoDocumentos).build();
		} catch (KrakeDevException e) {
			// TODO Auto-generated catch block
			return Response.serverError().build();
		}
	}
}
