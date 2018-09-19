package services;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/rest")
public class ProducirServicio{
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Producto getJsonResponse(){
		Producto p = new Producto();
		p.setId(1);
		p.setNombre("mayonesa");
		p.setCategoria("alimentos");
		p.setPrecio(15.2);
		return p;
	}
	
	
	//metodo para agregar un producto
	@Path("addproduct")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
	public void agregarProducto(Producto p){
		ProductoDao miProducto = new ProductoDao();
		miProducto.addProduct(p);
		System.out.println("se agrego producto sdasd" + p.getNombre());
	}
	
	//metodo para eliminar un producto
	@Path("delproduct")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void eliminarProducto(Producto p){
		ProductoDao miProducto = new ProductoDao();
		miProducto.deleteProduct(p.getId());
		System.out.println("se elimino producto");
	}
	
	//metodo para eliminar un producto
	/*@Path("updateproduct")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void actualizarProducto(Producto p){
		ProductoDao miProducto = new ProductoDao();
		miProducto.updateProduct(p);
		System.out.println("se actualizo producto");
	}*/
	
	//metodo para eliminar un producto
	@Path("showproducts")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producto> mostrarProductos(){
		ProductoDao miProducto = new ProductoDao();
		System.out.println("se mostraran productos" + miProducto.getAllProducts());
		return miProducto.getAllProducts();
	}
	
	//metodo para retornar un producto en especifico
	/*@Path("showproduct")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Producto mostrarProducto(Producto p){
		ProductoDao miProducto = new ProductoDao();
		System.out.println("se mostrara un producto" + miProducto.getProductById(p.getId()));
		return miProducto.getProductById(p.getId());
	}*/
}
