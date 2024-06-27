package ar.edu.unju.fi.ejercicio05.main;
import java.time.LocalDate; 
import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio01.constantes.Categoria;
import ar.edu.unju.fi.ejercicio01.constantes.HechoEn;
import ar.edu.unju.fi.ejercicio05.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio05.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio05.model.Producto;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static byte op;
	public static void main(String[] args) {
		ArrayList<Producto> productos = new ArrayList();
        cargaProductos(productos);
        do {
        	op=menu();
        	switch (op) {
			case 1: System.out.println("LISTA DE PRODUCTOS");
				    mostrarProductos(productos);
				break;
			case 2: System.out.println("REALIZACION DE PAGO");
			        limpiarBuffer();
			        realizarPago(productos);
				break;
			case 3: System.out.println("Finalizando programa...");
				break;
			default: System.out.println("OPCION INVALIDA");
				break;
			}
        }while(op!=3);
        System.out.println("Programa finalizado");
	}
    public static void cargaProductos(ArrayList <Producto> productos) {
    	productos.add(new Producto("A787", "Auriculares RGB", 45213.0, Categoria.INFORMATICA, HechoEn.ARGENTINA, false));
    	productos.add(new Producto("A87", "Auriculares RGB ryzer", 48213.0, Categoria.INFORMATICA, HechoEn.ARGENTINA, true));
    	productos.add(new Producto("H4", "Impresora Brother", 532465.02, Categoria.INFORMATICA, HechoEn.CHINA, true));
    	productos.add(new Producto("H88", "Impresora kodek", 654458.53, Categoria.INFORMATICA, HechoEn.CHINA, true));
    	productos.add(new Producto("H7", "Impresora HP", 164854.0, Categoria.INFORMATICA, HechoEn.CHINA, true));
    	productos.add(new Producto("P878", "Procesador i9 intel", 954458.53, Categoria.INFORMATICA, HechoEn.ARGENTINA, true));
    	productos.add(new Producto("P8", "Procesador i7 intel", 457187.53, Categoria.INFORMATICA, HechoEn.CHINA, false));
    	productos.add(new Producto("P88", "Procesador Ryzen 9 AMD", 984458.53, Categoria.INFORMATICA, HechoEn.ARGENTINA, true));
    	productos.add(new Producto("P88", "Procesador Ryzen 7 AMD", 784458.53, Categoria.INFORMATICA, HechoEn.CHINA, true));
    	productos.add(new Producto("S47", "Disco SSD 248Gb", 35265.02, Categoria.INFORMATICA, HechoEn.URUGUAY, false));
    	productos.add(new Producto("T14", "Teclado mecanico", 54213.0, Categoria.INFORMATICA, HechoEn.BRASIL, true));
    	productos.add(new Producto("T4", "Teclado Hyper x", 58213.0, Categoria.INFORMATICA, HechoEn.BRASIL, true));
    	productos.add(new Producto("U78", "Usb 16Gb", 7854.0, Categoria.INFORMATICA, HechoEn.CHINA, true));
    	productos.add(new Producto("U7", "Usb 32Gb", 16854.0, Categoria.INFORMATICA, HechoEn.CHINA, false));
    	productos.add(new Producto("H47", "Disco HDD 1T", 53265.02, Categoria.INFORMATICA, HechoEn.CHINA, true));

    }
    public static byte menu() {
    	
    	try {
    		System.out.println("1 Mostrar productos");
        	System.out.println("2 Realizar compra");
        	System.out.println("3 Salir");
        	System.out.print("Elija una opcion: ");
        	op = sc.nextByte();
		} catch (Exception e) {
			System.err.println("Solo numeros en la opcion");
		    sc.nextLine();
		}
    	return op;
    }
    public static void mostrarProductos(ArrayList<Producto> productos) {
    	int i=1;
    	for(Producto p: productos) {
    		System.out.println("*** Producto " + i + " ***");
    		i++;
    		System.out.println(p.toString());
    	}
    }
    public static void limpiarBuffer() {
    	sc.nextLine();
    }
    public static void realizarPago(ArrayList<Producto> productos) {
    	ArrayList<Producto> carrito = new ArrayList();
    	LocalDate hoy = LocalDate.now();
    	double total=0.0;
    	boolean band=true;
    	while(band) {
    		try {
				
			
    		System.out.println("Ingrese nro de producto: ");
    		byte nro = sc.nextByte();
    		if(nro < 1 || nro > productos.size()) {
    			System.err.println("valor incorrecto");
    		
    		}else {
    			if(productos.get(nro-1).getStock()==true) {
    				carrito.add(productos.get(nro-1));
    				limpiarBuffer();
    				System.out.println("¿Ingrear otro producto? 1.Si/2.No");
    				byte respuesta = sc.nextByte();
    				if(respuesta==2) {
    					band = false;
    				}
    			}else {
    				System.out.println("Producto sin stock");
    			}
    		}
    		} catch (Exception e) {
				System.err.println("Ingrese solo numeros");
				sc.nextLine();
			}
    	}
    	for(Producto c: carrito) {
    		total += c.getPrecioUnitario();
    	}
    	System.out.println("Total: " + total);
    	
    		op=menuPago();
    		switch (op) {
			case 1:
				limpiarBuffer();
				System.out.print("Ingrese nro tarjeta: ");
				String tarjeta = sc.nextLine();
				PagoTarjeta pTarjeta = new PagoTarjeta(tarjeta, hoy, total);
				pTarjeta.realizarPago(total);
				pTarjeta.imprimirRecibo();
				break;
			case 2:
				PagoEfectivo pEfectivo = new PagoEfectivo(total, hoy);
				pEfectivo.realizarPago(total);
				pEfectivo.imprimirRecibo();
				break;
			default:
				break;
			}
    
    }
    public static byte menuPago() {
    	boolean band = false;
    	do {
     	try {
    		System.out.println("1 Pago tarjeta");
        	System.out.println("2 Pago efectivo");
        	System.out.print("Elija una opcion: ");
        	op = sc.nextByte();
        	band = true;
		} catch (Exception e) {
			System.err.println("Solo numeros en la opcion");
		    sc.nextLine();
		}
    	}while(!(band));
    	return op;
    }
}
