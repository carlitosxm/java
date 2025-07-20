package krakedev.com.inventario.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import krakedev.com.inventario.entidades.Categoria;

@Path("categorias")
public class ServicioCategoria {
	@Path("insertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void insertar(Categoria categoria) {
		System.out.println("insertar categoria"+categoria);
	}
}
