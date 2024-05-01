package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {

		private static ArrayList<Jugador> jugadores = new ArrayList<>();
	    private static Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        int opcion;
	        do {
	            mostrarMenu();
	            opcion = scanner.nextInt();

	            switch (opcion) {
	                case 1:
	                    altaJugador();
	                    break;
	                case 2:
	                    mostrarJugadores();
	                    break;
	                case 3:
	                    modificarPosicion();
	                    break;
	                case 4:
	                    eliminarJugador();
	                    break;
	                case 5:
	                    System.out.println("Programa finalizado");
	                    break;
	                default:
	                    System.out.println("Opcion incorrecta por favor intentelo denuevo.");
	            }
	        } while (opcion != 5);
	    }

	    private static void mostrarMenu() {
	        System.out.println("MENU DE OPCIONES");
	        System.out.println("1- Alta de jugador");
	        System.out.println("2- Mostrar todos los jugadores");
	        System.out.println("3- Modificar la posicion de un jugador");
	        System.out.println("4- Eliminar un jugador");
	        System.out.println("5- Salir");
	        System.out.print("Ingrese su opción: ");
	    }

	    private static void altaJugador() {
	        System.out.println("Ingrese los datos del jugador:");
	        System.out.print("Nombre: ");
	        String nombre = scanner.nextLine();
	        System.out.print("Apellido: ");
	        String apellido = scanner.nextLine();
	        System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
	        LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());
	        System.out.print("Nacionalidad: ");
	        String nacionalidad = scanner.nextLine();
	        System.out.print("Estatura (en m): ");
	        double estatura = scanner.nextDouble();
	        System.out.print("Peso (en kg): ");
	        double peso = scanner.nextDouble();
	        scanner.nextLine(); // Limpiar el buffer después de leer un double
	        System.out.print("Posicion (DELANTERO, MEDIO, DEFENSA o ARQUERO): ");
	        Posicion posicion = Posicion.valueOf(scanner.nextLine().toUpperCase());

	        Jugador jugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
	        jugadores.add(jugador);
	        System.out.println("Jugador agregado correctamente.");
	    }

	    private static void mostrarJugadores() {
	        if (jugadores.isEmpty()) {
	            System.out.println("No hay jugadores registrados.");
	        } else {
	            System.out.println("Lista de jugadores:");
	            for (Jugador jugador : jugadores) {
	                System.out.println(jugador.toString());
	            }
	        }
	    }

	    private static void modificarPosicion() {
	        if (jugadores.isEmpty()) {
	            System.out.println("No hay jugadores registrados para modificar la posicion.");
	        } else {
	            System.out.print("Ingrese el nombre del jugador a modificar: ");
	            String nombre = scanner.nextLine();
	            System.out.print("Ingrese el apellido del jugador a modificar: ");
	            String apellido = scanner.nextLine();

	            boolean encontrado = false;
	            Iterator<Jugador> iterator = jugadores.iterator();
	            while (iterator.hasNext()) {
	                Jugador jugador = iterator.next();
	                if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
	                    System.out.print("Nueva posición (DELANTERO, MEDIO, DEFENSA o ARQUERO): ");
	                    Posicion nuevaPosicion = Posicion.valueOf(scanner.nextLine().toUpperCase());
	                    jugador.setPosicion(nuevaPosicion);
	                    System.out.println("Posición modificada correctamente.");
	                    encontrado = true;
	                    break;
	                }
	            }

	            if (!encontrado) {
	                System.out.println("Jugador no encontrado.");
	            }
	        }
	    }

	    private static void eliminarJugador() {
	        if (jugadores.isEmpty()) {
	            System.out.println("No hay jugadores registrados para eliminar.");
	        } else {
	            System.out.print("Ingrese el nombre del jugador a eliminar: ");
	            String nombre = scanner.nextLine();
	            System.out.print("Ingrese el apellido del jugador a eliminar: ");
	            String apellido = scanner.nextLine();

	            Iterator<Jugador> iterator = jugadores.iterator();
	            while (iterator.hasNext()) {
	                Jugador jugador = iterator.next();
	                if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
	                    iterator.remove();
	                    System.out.println("Jugador eliminado correctamente.");
	                    return;
	                }
	            }
	            System.out.println("Jugador no encontrado.");
	        }
	    
	}

}
