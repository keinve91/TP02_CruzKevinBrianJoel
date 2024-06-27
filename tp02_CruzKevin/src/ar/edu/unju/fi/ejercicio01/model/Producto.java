package ar.edu.unju.fi.ejercicio01.model;
import ar.edu.unju.fi.ejercicio01.constantes.Categoria;
import ar.edu.unju.fi.ejercicio01.constantes.HechoEn;
public class Producto {

	private String codigo;
	private String detalle;
	private Double precioU;
	HechoEn Fabricado;
	Categoria categorias;
	
	public Producto() {}
	
	
	 public Producto(String codigo, String detalle, Double precioU, HechoEn fabricado, Categoria categorias) {
		super();
		this.codigo = codigo;
		this.detalle = detalle;
		this.precioU = precioU;
		Fabricado = fabricado;
		this.categorias = categorias;
	}
	 


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getDetalle() {
		return detalle;
	}


	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}


	public Double getPrecioU() {
		return precioU;
	}


	public void setPrecioU(Double precioU) {
		this.precioU = precioU;
	}


	public HechoEn getFabricado() {
		return Fabricado;
	}


	public void setFabricado(HechoEn fabricado) {
		Fabricado = fabricado;
	}


	public Categoria getCategorias() {
		return categorias;
	}


	public void setCategorias(Categoria categorias) {
		this.categorias = categorias;
	}


	public void mostrarDatos() {
   	  System.out.println("Codigo: " + codigo);
   	  System.out.println("Descripcion: " + detalle);
   	  System.out.println("Precio Unitario: " + precioU);
   	  System.out.println("Categoria: " + categorias);
         System.out.println("Made in: " + Fabricado);
     }
	
	
	
}