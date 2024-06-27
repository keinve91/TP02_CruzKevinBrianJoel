package ar.edu.unju.fi.ejercicio07.main;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio01.constantes.Categoria;
import ar.edu.unju.fi.ejercicio01.constantes.HechoEn;
import ar.edu.unju.fi.ejercicio05.model.Producto;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static byte op;
    static DecimalFormat df = new DecimalFormat("#.00");

    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        precargaProductos(productos);
        do {
            op = menu();
            switch (op) {
                case 1:
                    disponibles(productos);
                    break;
                case 2:
                    noDisponibles(productos);
                    break;
                case 3:
                    incrementarPrecio(productos);
                    break;
                case 4:
                    mostrarElectroHogaresDisponibles(productos);
                    break;
                case 5:
                    ordenDescendente(productos);
                    break;
                case 6:
                    mayuscula(productos);
                    break;
                case 7:
                    System.out.println("Finalizando programa...");
                    break;
                default:
                    System.out.println("OPCION INVALIDA");
                    break;
            }
        } while (op != 7);
        System.out.println("Programa finalizado");
    }

    public static void precargaProductos(ArrayList<Producto> productos) {
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

        productos.add(new Producto("T101", "Celular BGH Joy", 100000.0, Categoria.TELEFONIA, HechoEn.ARGENTINA, true));
        productos.add(new Producto("T102", "Celular Samsung Galaxy A10", 85000.0, Categoria.TELEFONIA, HechoEn.CHINA, true));
        productos.add(new Producto("T103", "Celular Motorola E6s", 70000.0, Categoria.TELEFONIA, HechoEn.BRASIL, false));
        productos.add(new Producto("T104", "Celular Huawei Y5", 60000.0, Categoria.TELEFONIA, HechoEn.CHINA, true));
        productos.add(new Producto("T105", "Celular Xiaomi Redmi 9", 90000.0, Categoria.TELEFONIA, HechoEn.CHINA, true));

        productos.add(new Producto("E201", "Licuadora Philips", 150000.0, Categoria.ELECTROHOGAR, HechoEn.BRASIL, true));
        productos.add(new Producto("E202", "Aspiradora Electrolux", 250000.0, Categoria.ELECTROHOGAR, HechoEn.ARGENTINA, true));
        productos.add(new Producto("E203", "Microondas Samsung", 350000.0, Categoria.ELECTROHOGAR, HechoEn.CHINA, true));
        productos.add(new Producto("E204", "Heladera Whirlpool", 500000.0, Categoria.ELECTROHOGAR, HechoEn.ARGENTINA, true));
        productos.add(new Producto("E205", "Lavadora Drean", 900000.0, Categoria.ELECTROHOGAR, HechoEn.ARGENTINA, true));

        productos.add(new Producto("H301", "Taladro Bosch", 20000.0, Categoria.HERRAMIENTAS, HechoEn.CHINA, true));
        productos.add(new Producto("H302", "Sierra Circular Tramontina", 35000.0, Categoria.HERRAMIENTAS, HechoEn.BRASIL, true));
        productos.add(new Producto("H303", "Lijadora Black&Decker", 12000.0, Categoria.HERRAMIENTAS, HechoEn.BRASIL, false));
        productos.add(new Producto("H304", "Martillo Stanley", 5000.0, Categoria.HERRAMIENTAS, HechoEn.CHINA, true));
        productos.add(new Producto("H305", "estorillador hillips", 3000.0, Categoria.HERRAMIENTAS, HechoEn.ARGENTINA, false));
    }

    public static byte menu() {
        byte op = 0;
        try {
            System.out.println("****************************************");
            System.out.println("1 Mostrar productos disponibles");
            System.out.println("2 Mostrar productos no disponibles");
            System.out.println("3 Incrementar precios en un 20%");
            System.out.println("4 Mostrar productos de la categoría Electrohogar disponibles");
            System.out.println("5 Ordenar productos por precio en forma descendente");
            System.out.println("6 Mostrar productos con nombres en mayúsculas");
            System.out.println("7 Salir");
            System.out.println("****************************************");
            System.out.print("Elija una opción: ");
            op = sc.nextByte();
        } catch (Exception e) {
            System.err.println("Ingrese números para la opción");
            sc.nextLine();
        }
        return op;
    }

    public static void disponibles(ArrayList<Producto> productos) {
        Consumer<Producto> mostrarProducto = p -> System.out.println(formatProducto(p));
        productos.stream().filter(Producto::getStock).forEach(mostrarProducto);
    }

    public static void noDisponibles(ArrayList<Producto> productos) {
        Predicate<Producto> filtrarNoDisponibles = x -> !x.getStock();
        productos.stream().filter(filtrarNoDisponibles).forEach(p -> System.out.println(formatProducto(p)));
    }

    public static void incrementarPrecio(ArrayList<Producto> productos) {
        Function<Producto, Producto> funcionIncremento = (p) -> {
            p.setPrecioUnitario(p.getPrecioUnitario() * 1.2);
            return p;
        };
        List<Producto> productosIncrementados = productos.stream().map(funcionIncremento).collect(Collectors.toList());
        productosIncrementados.forEach(p -> System.out.println(formatProducto(p)));
    }

    public static void mostrarElectroHogaresDisponibles(ArrayList<Producto> productos) {
        Predicate<Producto> categoriaEstado = e -> e.getStock() && e.getCategorias() == Categoria.ELECTROHOGAR;
        productos.stream().filter(categoriaEstado).forEach(p -> System.out.println(formatProducto(p)));
    }

    public static void ordenDescendente(ArrayList<Producto> productos) {
        System.out.println("--------- Precios ordenados ---------");
        productos.sort(Comparator.comparing(Producto::getPrecioUnitario).reversed());
        productos.forEach(p -> System.out.println(formatProducto(p)));
    }

    public static void mayuscula(ArrayList<Producto> productos) {
        Function<Producto, Producto> aMayusculas = producto -> {
            producto.setDescripcion(producto.getDescripcion().toUpperCase());
            return producto;
        };
        System.out.println("Productos con nombres en mayúsculas:");
        productos.stream().map(aMayusculas).forEach(p -> System.out.println(formatProducto(p)));
    }

    public static String formatProducto(Producto p) {
        return String.format("Código: %s, Descripción: %s, Precio: %s, Categoría: %s, Origen: %s, Disponible: %s",
                p.getCodigo(),
                p.getDescripcion(),
                df.format(p.getPrecioUnitario()),
                p.getCategorias(),
                p.getOrigen(),
                p.getStock() ? "Sí" : "No");
    }
}



