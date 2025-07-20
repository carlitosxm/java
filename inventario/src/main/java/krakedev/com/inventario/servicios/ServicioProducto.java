package krakedev.com.inventario.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import krakedev.com.inventario.entidades.Categoria;
import krakedev.com.inventario.entidades.Producto;

@Path("productos")
public class ServicioProducto {
	@Path("insertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void insertar(Producto producto) {
		System.out.println("insertar producto"+producto);
	}
	
	@Path("actualizar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void actualizar(Producto producto) {
		System.out.println("insertar producto"+producto);
	}
	
	@Path("consultar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Producto> recuperarTodos() {
		ArrayList<Producto> productos=new ArrayList<>();
		Categoria c=new Categoria(1,"Higiene");
		Producto pro1=new Producto("001","jabon",c,0.58,10);
		Producto pro2=new Producto("001","shampoo",c,0.50,20);
		Producto pro3=new Producto("001","pasta",c,1.00,15);
		
		productos.add(pro1);
		productos.add(pro2);
		productos.add(pro3);
		
		System.out.println("actualizar producto"+productos);
		return productos;
	}
}
