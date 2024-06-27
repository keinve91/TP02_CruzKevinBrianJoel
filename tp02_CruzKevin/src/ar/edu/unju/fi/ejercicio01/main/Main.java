package ar.edu.unju.fi.ejercicio01.main;
import java.util.ArrayList;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio01.constantes.Categoria;
import ar.edu.unju.fi.ejercicio01.constantes.HechoEn;
import ar.edu.unju.fi.ejercicio01.model.Producto;
public class Main {
	static Scanner sc = new Scanner(System.in);
	static int op;
	public static void main(String[] args) {
		ArrayList<Producto> productos = new ArrayList();
		int opcion=0;
		
		do {
			opcion=menu();
			switch (opcion) {
			case 1: System.out.println(".....CREAR PRODUCTO.....");
					sc.nextLine();
					carga_depro(productos);
				break;
			case 2:
					if(listaVac(productos)) {
						System.out.println("***..LISTA VACIA..***");
					
					}else {
						System.out.println("*LISTA DE PRODUCTOS:");
						mostrarPRODU(productos);
					}
				break;
			case 3:
				if(listaVac(productos)) {
					System.out.println("***..LISTA VACIA..***");
				
				}else {
					sc.nextLine();
					System.out.println("Ingrese el codigo para buscar: ");
					String Buscar=sc.nextLine();
					ModificarProducto(productos, Buscar);
					

				}
				break;
			case 4:
					System.out.println("SALIENDO DEL PROGRAMA........");
				break;
			
			default: System.out.println("opcionInvalida");
				break;
			
			}
		}while(opcion !=4);
		
	}
	public static int menu() {
		System.out.println("...MENU...");
    	System.out.println("1)...Crear producto");
        System.out.println("2)...Mostrar producto");
        System.out.println("3)...Modificar producto");
        System.out.println("4)...Salir");
        System.out.print("Elija opcion: ");
        return op=sc.nextInt();
    }
	 public static void carga_depro(ArrayList<Producto> pro) {
	    	System.out.print("Ingrese codigo: ");
	    	String codigo = sc.nextLine();
	    	System.out.print("Ingrese descripcion: ");
	    	String detalle = sc.nextLine();
	    	double precioUnitario = ValidarPrecio();
	    	sc.nextLine();
	    	Categoria categoria = asignarCategoria();
	    	HechoEn origen = Origen();
	        pro.add(new Producto(codigo, detalle, precioUnitario, origen, categoria)); 
	        System.out.println("***CREACION EXITOSA***");
	        System.out.println("");
	    }
	 public static Categoria asignarCategoria() {
		 int opcion=0;
		 Categoria c = null;

		 do {
			 System.out.println("------Categoria------");
		     System.out.println("1 Telefonia");
		     System.out.println("2 Informatica");
		     System.out.println("3 ElectroHogar");
		     System.out.println("4 Herramienta");
		     System.out.print("Elija opcion: ");
		     opcion=sc.nextInt();
		     switch(opcion) {
		     case 1:
					c = Categoria.TELEFONIA;
					break;
				case 2: 
					c = Categoria.INFORMATICA;
					break;
				case 3:
					c = Categoria.ELECTROHOGAR;
					break;
				case 4:
					c = Categoria.HERRAMIENTAS;
					break;
				default: System.out.println("***OPCION INVALIDA***");
					break;
		     }
		 }while(opcion<1||opcion>4);
	    	return c;
	    }
	 public static HechoEn Origen() {
		 int opcion=0;
		 HechoEn h = null;

		 do {
			 System.out.println("------Origen de fabricacion------");
		        System.out.println("1 Argentina");
		        System.out.println("2 China");
		        System.out.println("3 Brasil");
		        System.out.println("4 Uruguay");
		        System.out.print("Elija opcion: ");
		     opcion=sc.nextInt();
		     switch(opcion) {
		     case 1:
					h = HechoEn.ARGENTINA;
					break;
				case 2: 
					h = HechoEn.CHINA;
					break;
				case 3:
					h = HechoEn.BRASIL;
					break;
				case 4:
					h = HechoEn.URUGUAY;
					break;
				default: System.out.println("***OPCION INVALIDA***");
					break;
		     }
		 }while(opcion<1||opcion>4);
	    	return h;
	 }
	 public static double ValidarPrecio() {
	    	String ingreso="";
	    	Double precio=0.0;
	    	while(true) {
	    		System.out.println("Ingrese precio unitario: ");
	        	ingreso=sc.nextLine();
	        	if(ingreso.contains(",")) {
	        		System.err.println("Ingrese \".\" para separar decimales");
	        		continue;
	        	}
	    	try {
	    	 precio = Double.parseDouble(ingreso);
	         return precio;
	    	}catch (Exception e) {
				System.err.println("Formato incorrecto");
			}
	    	}

	    }
	 public static void mostrarPRODU(ArrayList<Producto> pro) {
		 int i=1;
	    	for(Producto p: pro) {
	    		System.out.println("******************** ");
	    		System.out.println("Producto Nro["+i+"]: ");
	    		p.mostrarDatos();
	    		System.out.println(" ");
	    		i++;
	    	}
	    }
	 public static void ModificarProducto(ArrayList<Producto> productos, String codigo) {
	    	boolean band=false;	
	    	Producto encontrado = new Producto();
	    	for(Producto p: productos) {
	    		if(p.getCodigo().equalsIgnoreCase(codigo)==true) {
	    			band=true;
	    			encontrado=p;
	    		}
	    		}
	    	if(band == true) {
	    		int op=0;
	    		System.out.println("***PRODUCTO ENCONTRADO***");
	    		do {
	    			System.out.println("1 Modificar descripcion");
	    	    	System.out.println("2 Modificar precio unitario");
	    	    	System.out.println("3 Modificar categoria");
	    	    	System.out.println("4 Modificar origen");
	    	    	System.out.println("5 Salir");
	    	    	System.out.print("Elija una opcion: ");
	    	    	op=sc.nextInt();
	    			switch (op) {
					case 1:
						sc.nextLine();
						System.out.println("Ingrese nueva descripcion: ");
						encontrado.setDetalle(sc.nextLine());
						System.out.println("***DESCRIPCION CAMBIADA***");
						System.out.println("");
						break;
					case 2:
						sc.nextLine();
						encontrado.setPrecioU(ValidarPrecio());
						System.out.println("***PRECIO CAMBIADO***");
						System.out.println("");
						break;
					case 3:
						sc.nextLine();
						encontrado.setCategorias(asignarCategoria());
						System.out.println("***CATEGORIA CAMBIADA***");
						System.out.println("");
						break;
					case 4:
						sc.nextLine();
						encontrado.setFabricado(Origen());
						System.out.println("***ORIGEN CAMBIADO***");
						System.out.println("");
						break;
					case 5: System.out.println("Hasta la proxima");
					break;
					default:System.out.println("***ERROR OPCION INVALIDA***");
						break;
					}
	    		}while(op!=5);
	    		
	    	}else {
	    		System.out.println("***..Producto No encontrado..***");
	    	}
	 }
	public static boolean listaVac(ArrayList<Producto> pro) {
		if(pro.isEmpty()) {
			return true;
		
		}else {
			return false;
		}
}
}