package ar.edu.unju.fi.ejercicio02.main;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import ar.edu.unju.fi.ejercicio02.constantes.Mes;
import ar.edu.unju.fi.ejercicio02.model.Efemeride;
public class Main {
	static Scanner scanner = new Scanner(System.in);
    static int op;
	public static void main(String[] args) {
		ArrayList<Efemeride> efemeride = new ArrayList();
		do {
			op=menu();
			switch (op) {
			case 1:
				limpiarBuffer();
				crearEfemeride(efemeride);
				break;
			case 2:
				if(efemeride.isEmpty()) {
			    	 System.out.println("***ERROR LISTA VACIA***");
			     }else {
			    	 limpiarBuffer();
			    	 mostrarEfemerides(efemeride);
			     }
				break;
			case 3:
				if(efemeride.isEmpty()) {
			    	System.out.println("***ERROR LISTA VACIA***");
			    	System.out.println("");
			    }else {
			    limpiarBuffer();
			    System.out.print("Ingrese codigo: ");
			    String cod = scanner.nextLine();
			    eliminarEfemeride(efemeride, cod);
			    }
				break;
			case 4:
				if(efemeride.isEmpty()) {
			    	 System.out.println("***ERROR LISTA VACIA***");
			    	 System.out.println("");
			     }else {
			    	 limpiarBuffer();
			    	 System.out.println("Ingrese codigo: ");
			    	 String cod = scanner.nextLine();
			    	 modificarEfemeride(efemeride, cod);
			     }
				break;
			default:
				System.out.println("Opción no válida");
				break;
			}
			
		} while (op != 5);
	}
	
	public static int menu() {
		System.out.println("1 Crear efemeride");
		System.out.println("2 Mostrar efemerides");
		System.out.println("3 Eliminar efemeride");
		System.out.println("4 Modificar efemeride");
		System.out.println("5 Salir");
		System.out.print("Elija una opcion: ");
		return op=scanner.nextInt();
	}
	public static void limpiarBuffer() {
		scanner.nextLine();
	}
	public static void crearEfemeride(ArrayList<Efemeride> efemerides) {
		System.out.print("Ingrese codigo: ");
		String codigo = scanner.nextLine();
		int NumeroMes = validarMes();
		Mes mes = Mes.values()[NumeroMes-1];
		limpiarBuffer();
		System.out.print("Ingrese dia: ");
		int dia = scanner.nextInt();
		System.out.print("Ingrese descripcion: ");
	    String descripcion = scanner.nextLine();
	    efemerides.add(new Efemeride(codigo, mes, dia, descripcion));
	    System.out.println("***CREACION EXITOSA***");
	}
    public static int validarMes(){
        int mes=0;
        try {
        	do {
            	System.out.print("Ingrese mes 1 al 12: ");
                mes=scanner.nextInt();
                }while(mes < 1 || mes > 12);
        }catch(Exception e) {
        	System.out.print("\nERROR: Ingrese un numero valido\n");
        }
        return mes;
    }
  
    public static void mostrarEfemerides(ArrayList<Efemeride> efemerides) {
		 int o=1;

    	for(Efemeride i:efemerides) {
    		System.out.println("******************** ");
    		System.out.println("Producto Nro["+o+"]: ");
    		i.toString();
    		limpiarBuffer();
    		o++;
    	}
    }
    private static void eliminarEfemeride(ArrayList<Efemeride> efemerides, String codigo) {
		boolean valido=false;
		Iterator<Efemeride> efemeride=efemerides.iterator();
		while(efemeride.hasNext()) {
			if (efemeride.next().getCodigo().equals(codigo)) {
	           	efemeride.remove();
	           	valido=true;
	        }
	    }
		if(valido==true) {
			System.out.println("\nEfemeride Eliminado");
		}else {
			System.out.println("\nEfemeride no encontrado");
		}
	}
    
    public static void modificarEfemeride(ArrayList<Efemeride> efemerides, String codigo) {
    	boolean band=false;
    	int nuevoMes=0;
    	Efemeride encontrado = new Efemeride(); 
    	for(Efemeride i: efemerides) {
    		if(i.getCodigo().equalsIgnoreCase(codigo)==true) {
    			band = true;
    			encontrado = i;
    		}
    	}
    	if(band==true) {
    		do {
    			op=menuModificar();
    			switch (op) {
				case 1:
					limpiarBuffer();
					nuevoMes=validarMes();
					encontrado.setMes(Mes.values()[nuevoMes-1]);
					System.out.println("***MES CAMBIADO CON EXITO***");
					System.out.println("");
					break;
				case 2:
					limpiarBuffer();
					System.out.print("Ingrese nuevo dia: ");
					encontrado.setDia(scanner.nextInt());
					System.out.println("***DIA CAMBIADO CON EXITO***");
					System.out.println("");
					break;
				case 3: 
					limpiarBuffer();
					System.out.println("Ingrese nuevo detalle: ");
					encontrado.setDetalle(scanner.nextLine());
					System.out.println("***DETALLE CAMBIADO CON EXITO***");
					System.out.println("");
					break;
				case 4:
					System.out.println("***Hasta la proxima***");
					System.out.println("");
					break;
				default: System.out.println("***OPCION INVALIDA***");
					break;
				}
    		}while(op!=4);
    	}else {
    		System.out.println("***EFEMERIDE INEXISTENTE***");
    	}
    }
    
    public static int menuModificar() {
		System.out.println("1 Modificar mes");
		System.out.println("2 Modificar dia");
		System.out.println("3 Modificar detalle");
		System.out.println("4 Salir"); 
		System.out.print("Elija opcion: ");
		op = scanner.nextInt();
	return op;
}

}
