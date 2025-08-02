package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.PedidosBDD;
import com.krakedev.inventarios.entidades.Pedido;
import com.krakedev.inventarios.excepciones.KrakeDevException;

@Path("pedidos")
public class ServicioPedido {

	@Path("insertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar(Pedido pedido) {
		System.out.println(">>>>>>>>>>>>"+pedido);
		PedidosBDD pedid=new PedidosBDD();
		try {
			pedid.insertar(pedido);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	
	@Path("recibir")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response recibir(Pedido pedido) {
		System.out.println(">>>>>>>>>>>>"+pedido);
		PedidosBDD pedid=new PedidosBDD();
		try {
			pedid.recibir(pedido);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("buscarid/{subid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarid(@PathParam("subid")String subcadena){
		PedidosBDD pbdd=new PedidosBDD();
		ArrayList<Pedido> pedido=null;
		try {
			pedido = pbdd.buscarPorProveedor(subcadena);
			return Response.ok(pedido).build();
		} catch (KrakeDevException e) {
			// TODO Auto-generated catch block
			return Response.serverError().build();
		}
	}
}
