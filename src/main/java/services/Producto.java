package services;

public class Producto {
	private int id;
	private String nombre;
	private String categoria;
	private double precio;
	
	
	/*Constructores sin par�metros y con par�metros*/
	public Producto() {
		
	}
	
	public Producto(int id, String nombre, String categoria, double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
	}
	/*Getter and settes para la clase producto
	 *  */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
