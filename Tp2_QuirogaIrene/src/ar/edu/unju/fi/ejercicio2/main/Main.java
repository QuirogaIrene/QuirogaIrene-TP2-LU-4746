package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {

	public static void main(String[] args) {
		ArrayList<Efemeride> efemerides = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menu de acciones:");
            System.out.println("1- Crear Efemeride");
            System.out.println("2- Mostrar Efemerides");
            System.out.println("3- Eliminar Efemeride");
            System.out.println("4- Modificar Efemeride");
            System.out.println("5- Salir");
            System.out.print("Elija una opcion: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcion) {
                    case 1:
                        crearEfemeride(efemerides, scanner);
                        break;
                    case 2:
                        mostrarEfemerides(efemerides);
                        break;
                    case 3:
                        eliminarEfemeride(efemerides, scanner);
                        break;
                    case 4:
                        modificarEfemeride(efemerides, scanner);
                        break;
                    case 5:
                        System.out.println("Programa finalizado");
                        break;
                    default:
                        System.out.println("Opcion erronea intentelo de nuevo.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error intentelo denuevo. ");
                scanner.nextLine();
                opcion = 0;
            }
        } while (opcion != 5);

        scanner.close();
    }

    public static void crearEfemeride(ArrayList<Efemeride> efemerides, Scanner scanner) {
        System.out.print("Ingrese el codigo: ");
        String codigo = scanner.nextLine();

        System.out.print("Ingrese el numero correspondiente al mes [1 - 12]: ");
        int numeroMes = scanner.nextInt();
        scanner.nextLine();
        Mes mes = null;
        switch (numeroMes) {
            case 1:
                mes = Mes.ENERO;
                break;
            case 2:
                mes = Mes.FEBRERO;
                break;
            case 3:
                mes = Mes.MARZO;
                break;
            case 4:
                mes = Mes.ABRIL;
                break;
            case 5:
                mes = Mes.MAYO;
                break;
            case 6:
                mes = Mes.JUNIO;
                break;
            case 7:
                mes = Mes.JULIO;
                break;
            case 8:
                mes = Mes.AGOSTO;
                break;
            case 9:
                mes = Mes.SEPTIEMBRE;
                break;
            case 10:
                mes = Mes.OCTUBRE;
                break;
            case 11:
                mes = Mes.NOVIEMBRE;
                break;
            case 12:
                mes = Mes.DICIEMBRE;
                break;
            default:
                System.out.println("Numero de mes no valido.");
                return;
        }

        System.out.print("Ingrese el dia: ");
        int dia = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el detalle: ");
        String detalle = scanner.nextLine();

        Efemeride nuevaEfemeride = new Efemeride(codigo, mes, dia, detalle);
        efemerides.add(nuevaEfemeride);
        System.out.println("Efemeride creada exitosamente!");
    }

    public static void mostrarEfemerides(ArrayList<Efemeride> efemerides) {
        if (efemerides.isEmpty()) {
            System.out.println("No hay efemerides para mostrar");
        } else {
            System.out.println("Listado de efemerides:");
            for (Efemeride efemeride : efemerides) {
                System.out.println("Codigo: " + efemeride.getCodigo());
             }
        	}
    }
    
    public static void eliminarEfemeride(ArrayList<Efemeride> efemerides, Scanner scanner) {

    	
        if (efemerides.isEmpty()) {
            System.out.println("No hay efemerides para eliminar!");
            return;
        }

        System.out.println("Eliminar efemeride:");
        mostrarEfemerides(efemerides);
        System.out.print("Ingrese el indice de la efemeride a eliminar [0 - " + (efemerides.size() - 1) + "]: ");
        int indice = scanner.nextInt();
        scanner.nextLine();

        if (indice >= 0 && indice < efemerides.size()) {
            Efemeride efemerideEliminada = efemerides.remove(indice);
            System.out.println("Efemeride eliminada correctamente:");
            System.out.println("Codigo: " + efemerideEliminada.getCodigo());
            System.out.println("Mes: " + efemerideEliminada.getMes());
            System.out.println("Dia: " + efemerideEliminada.getDia());
            System.out.println("Detalle: " + efemerideEliminada.getDetalle());
        } else {
            System.out.println("Indice de efemeride no valido.");
        }
    }

    public static void modificarEfemeride(ArrayList<Efemeride> efemerides, Scanner scanner) {
        if (efemerides.isEmpty()) {
            System.out.println("No hay efemerides para modificar!");
            return;
        }

        System.out.println("Modificar efeméride:");
        mostrarEfemerides(efemerides);
        System.out.print("Ingrese el indice de la efemeride a modificar [0 - " + (efemerides.size() - 1) + "]: ");
        int indice = scanner.nextInt();
        scanner.nextLine();

        if (indice >= 0 && indice < efemerides.size()) {
            Efemeride efemeride = efemerides.get(indice);
            System.out.println("Efemeride actual:");
            System.out.println("1- Mes: " + efemeride.getMes());
            System.out.println("2- Día: " + efemeride.getDia());
            System.out.println("3- Detalle: " + efemeride.getDetalle());
            System.out.print("Elija el número de la opcion a modificar: ");
            int opcionModificar = scanner.nextInt();
            scanner.nextLine();

            switch (opcionModificar) {
                case 1:
                    System.out.print("Ingrese el numero correspondiente al nuevo mes [1 - 12]: ");
                    int numeroMes = scanner.nextInt();
                    scanner.nextLine();
                    Mes nuevoMes = null;
                    switch (numeroMes) {
                        case 1:
                            nuevoMes = Mes.ENERO;
                            break;
                        case 2:
                            nuevoMes = Mes.FEBRERO;
                            break;
                        case 3:
                            nuevoMes = Mes.MARZO;
                            break;
                        case 4:
                            nuevoMes = Mes.ABRIL;
                            break;
                        case 5:
                            nuevoMes = Mes.MAYO;
                            break;
                        case 6:
                            nuevoMes = Mes.JUNIO;
                            break;
                        case 7:
                            nuevoMes = Mes.JULIO;
                            break;
                        case 8:
                            nuevoMes = Mes.AGOSTO;
                            break;
                        case 9:
                            nuevoMes = Mes.SEPTIEMBRE;
                            break;
                        case 10:
                            nuevoMes = Mes.OCTUBRE;
                            break;
                        case 11:
                            nuevoMes = Mes.NOVIEMBRE;
                            break;
                        case 12:
                            nuevoMes = Mes.DICIEMBRE;
                            break;
                        default:
                            System.out.println("Numero de mes no valido. No se realizaran cambios.");
                            return;
                    }
                    efemeride.setMes(nuevoMes);
                    break;
                case 2:
                    System.out.print("Ingrese el nuevo día: ");
                    int nuevoDia = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer de entrada
                    efemeride.setDia(nuevoDia);
                    break;
                case 3:
                    System.out.print("Ingrese el nuevo detalle: ");
                    String nuevoDetalle = scanner.nextLine();
                    efemeride.setDetalle(nuevoDetalle);
                    break;
                default:
                    System.out.println("Opcion no valida. No se realizaran cambios.");
                    break;
            }
            System.out.println("Efemeride modificada exitosamente!");
        } else {
            System.out.println("Indice de efemeride no valido.");
        }
    }

}
