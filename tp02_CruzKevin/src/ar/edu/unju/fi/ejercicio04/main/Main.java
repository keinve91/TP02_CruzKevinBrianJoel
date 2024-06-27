package ar.edu.unju.fi.ejercicio04.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio04.constantes.Posicion;
import ar.edu.unju.fi.ejercicio04.model.Jugador;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static String x;
    public static float f;

    public static void main(String[] args) {
        ArrayList<Jugador> jug = new ArrayList<>();

        int opcion = 0;

        do {
            menu();
            try {
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        signIn(jug);
                        break;
                    case 2:
                        for (Jugador j : jug) {
                            System.out.println(j.toString());
                        }
                        break;
                    case 3:
                        modify(jug);
                        break;
                    case 4:
                        delete(jug);
                        break;
                    case 5:
                        System.out.println("Programa finalizado");
                        break;
                    default:
                        System.out.println("Opción incorrecta, intente nuevamente");
                }
            } catch (Exception e) {
                System.out.println("Solo debe ingresar números");
                sc.nextLine();
            }

        } while (opcion != 5);

    }

    public static void menu() {
        System.out.println("\n*** Menú Principal ***");
        System.out.println("1 - Registrar un nuevo jugador");
        System.out.println("2 - Mostrar jugadores registrados");
        System.out.println("3 - Cambiar la posición de un jugador");
        System.out.println("4 - Eliminar un jugador");
        System.out.println("5 - Salir");
        System.out.print("Ingrese una opción: ");
    }



    public static void setAge(Jugador j) {
        int d, m, y;
        boolean loop = true;
        do {
            try {
                System.out.println("\nFecha de Nacimiento");
                System.out.println("Ingrese el día: ");
                d = sc.nextInt();

                if (d > 0 && d < 31) {
                    System.out.println("Ingrese el mes: ");
                    m = sc.nextInt();

                    if (m > 0 && m < 12) {
                        System.out.println("Ingrese el año: ");
                        y = sc.nextInt();

                        if (y > 0 && y < 2025) {
                            j.setAños(LocalDate.of(y, m, d));
                            loop = false;
                        } else {
                            System.out.println("Año inexistente, intente nuevamente");
                        }
                    } else {
                        System.out.println("Meses fuera de rango, intente nuevamente");
                    }
                } else {
                    System.out.println("Días fuera de rango, intente nuevamente");
                }
            } catch (Exception e) {
                System.err.println("INGRESE ÚNICAMENTE VALORES NUMÉRICOS");
                sc.nextLine();
            }
        } while (loop);
    }

   
    public static float ingresarPeso() {
        float peso = 0;
        boolean loop = true;

        do {
            try {
                System.out.println("Ingrese su peso en kg (entre 50 y 120): ");
                peso = sc.nextFloat();

                if (peso >= 50 && peso <= 120) {
                    loop = false;
                } else {
                    System.err.println("El peso debe estar entre 50 y 120 kg");
                }

            } catch (Exception e) {
                System.err.println("Ingrese un valor numérico válido");
                sc.nextLine();
            }
        } while (loop);

        return peso;
    }
    public static float ingresarAltura() {
        float altura = 0;
        boolean loop = true;

        do {
            try {
                System.out.println("Ingrese su altura en metros (entre 1.20 y 2.20): ");
                altura = sc.nextFloat();

                if (altura >= 1.20 && altura <= 2.20) {
                    loop = false;
                } else {
                    System.err.println("La altura debe estar entre 1.20 y 2.20 metros");
                }

            } catch (Exception e) {
                System.err.println("Ingrese un valor numérico válido");
                sc.nextLine();
            }
        } while (loop);

        return altura;
    }

    public static void selectPosition(Jugador j) {
        Posicion[] pos = Posicion.values();
        boolean loop = true;
        do {
            try {
                for (int i = 0; i < pos.length; i++) {
                    System.out.println("[" + (i + 1) + "] - " + pos[i]);
                }
                System.out.println("Ingrese un número correspondiente a la posición: ");
                int x = sc.nextInt();

                if (x > 0 && x <= pos.length) {
                    j.setPos(pos[x - 1]);
                    loop = false;
                } else {
                    System.out.println("Opción inexistente, reintente nuevamente");
                }

            } catch (Exception e) {
                System.err.println("SOLO SE PERMITEN VALORES NUMÉRICOS ENTEROS");
                sc.nextLine();
            }
        } while (loop);
    }

    public static void signIn(ArrayList<Jugador> jugador) {
        Jugador gamer = new Jugador();
        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();
        gamer.setNombre(nombre);
        System.out.print("Ingrese apellido: ");
        String apellido = sc.nextLine();

        gamer.setApellido(apellido);
        setAge(gamer);
        System.out.print("Ingrese nacionalidad: ");
        String nacionalidad = sc.nextLine();
        gamer.setNacionalidad(nacionalidad);
        float altura = ingresarAltura();
        gamer.setAltura(altura);
        float peso = ingresarPeso();
        gamer.setPeso(peso);
        selectPosition(gamer);

        jugador.add(gamer);
        System.out.println("Nuevo jugador registrado");
    }

    public static void modify(ArrayList<Jugador> jugador) {
        Jugador aux = new Jugador();
        System.out.print("Ingrese nombre: ");
    	String nombre = sc.nextLine();
        aux.setNombre(nombre);
        System.out.print("Ingrese apellido: ");
    	String apellido = sc.nextLine();
        aux.setApellido(apellido);
        boolean exist = false;

        for (Jugador j : jugador) {
            if (j.getNombre().equals(aux.getNombre()) && j.getApellido().equals(aux.getApellido())) {
                selectPosition(j);
                exist = true;
                break;
            }
        }

        if (exist) {
            System.out.println("Modificación realizada");
        } else {
            System.out.println("No existe el jugador");
        }
    }

    public static void delete(ArrayList<Jugador> jugador) {
        Iterator<Jugador> iterador = jugador.iterator();
        Jugador aux = new Jugador();
        System.out.print("Ingrese nombre: ");
    	String nombre = sc.nextLine();
        aux.setNombre(nombre);
        System.out.print("Ingrese apellido: ");
    	String apellido = sc.nextLine();
        aux.setApellido(apellido);

        while (iterador.hasNext()) {
            Jugador j = iterador.next();
            if (j.getNombre().equals(aux.getNombre()) && j.getApellido().equals(aux.getApellido())) {
                iterador.remove();
            }
        }

        System.out.println("Jugador eliminado exitosamente");
    }
}