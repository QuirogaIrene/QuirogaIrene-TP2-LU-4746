package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio1.model.Producto;

public class Main {

	public static void main(String[] args) {
		 int opcion ; 
		ArrayList<Producto> productos = new ArrayList<>();
		Scanner scanner = new Scanner(System.in); 
		do {
			System.out.println("Menu de opciones:");
            System.out.println("1 - Crear Producto");
            System.out.println("2 - Mostrar productos");
            System.out.println("3 - Modificar producto");
            System.out.println("4 - Salir");
            System.out.print("Elija una opcion: ");
            
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer de entrada
                
                switch (opcion) {
                    case 1:
                        crearProducto(productos, scanner);
                        break;
                    case 2:
                        mostrarProductos(productos);
                        break;
                    case 3:
                        modificarProducto(productos, scanner);
                        break;
                    case 4:
                        System.out.println("Programa finalizado");
                        break;
                    default:
                        System.out.println("Opcion incorrecta, intentelo de nuevo! ");
                        break;
                	}
            	}catch (Exception e) {
	                System.out.println("Error: Ingrese un numero valido");
	                scanner.nextLine(); 
	                //actualizo la variable opcion para que pueda volver a ingresar una opcion.
	                opcion = 0;
            }
			
			}while (opcion != 4);
		}
		
		 public static void crearProducto(ArrayList<Producto> productos, Scanner scanner) {
			 
			 
		        System.out.println("Creando nuevo producto:");
		        System.out.print("Ingrese el codigo: ");
		        String codigo = scanner.nextLine();
		        System.out.print("Ingrese la descripcion: ");
		        String descripcion = scanner.nextLine();
		        System.out.print("Ingrese el precio unitario: ");
		        double precioUnitario = scanner.nextDouble();
		     // Limpiamos pantalla.
		        scanner.nextLine(); 

		        System.out.println("------ Origen de fabricacion ------");
		        System.out.println("1 - Argentina");
		        System.out.println("2 - China");
		        System.out.println("3 - Brasil");
		        System.out.println("4 - Uruguay");
		        System.out.print("Elija una opcion: ");
		        int opcionOrigen = scanner.nextInt();
		        Producto.OrigenFabricacion origen = null;
		        switch (opcionOrigen) {
		            case 1:
		                origen = Producto.OrigenFabricacion.ARGENTINA;
		                break;
		            case 2:
		                origen = Producto.OrigenFabricacion.CHINA;
		                break;
		            case 3:
		                origen = Producto.OrigenFabricacion.BRASIL;
		                break;
		            case 4:
		                origen = Producto.OrigenFabricacion.URUGUAY;
		                break;
		            default:
		                System.out.println("Opcion de origen no valida. Se asignara valor por defecto.");
		                origen = Producto.OrigenFabricacion.ARGENTINA; 
		                break;
		        }
		        //Limpiamos pantalla denuevo
		        scanner.nextLine(); 

		        System.out.println("------ Categoria ------");
		        System.out.println("1 - Telefonia");
		        System.out.println("2 - Informatica");
		        System.out.println("3 - Electro hogar");
		        System.out.println("4 - Herramientas");
		        System.out.print("Elija una opcion: ");
		        int opcionCategoria = scanner.nextInt();
		        Producto.Categoria categoria = null;
		        switch (opcionCategoria) {
		            case 1:
		                categoria = Producto.Categoria.TELEFONIA;
		                break;
		            case 2:
		                categoria = Producto.Categoria.INFORMATICA;
		                break;
		            case 3:
		                categoria = Producto.Categoria.ELECTROHOGAR;
		                break;
		            case 4:
		                categoria = Producto.Categoria.HERRAMIENTAS;
		                break;
		            default:
		                System.out.println("Opcion de categoria no valida. Se asignara valor por defecto.");
		                categoria = Producto.Categoria.TELEFONIA;
		                break;
		        }
		        scanner.nextLine();

		        Producto nuevoProducto = new Producto(codigo, descripcion, precioUnitario, origen, categoria);
		        productos.add(nuevoProducto);
		        System.out.println("Producto creado exitosamente.");
		
		
		
		 }
		 
		 public static void mostrarProductos(ArrayList<Producto> productos) {
		        if (productos.isEmpty()) {
		            System.out.println("No hay productos para mostrar.");
		        } else {
		            System.out.println("LISTADO DE PRODUCTOS:");
		            for (Producto producto : productos) {
		                System.out.println("Codigo: " + producto.getCodigo());
		                System.out.println("Descripcion: " + producto.getDescripcion());
		                System.out.println("Precio Unitario: $" + producto.getPrecioUnitario());
		                System.out.println("Origen de Fabricacion: " + producto.getOrigenFabricacion());
		                System.out.println("Categoria: " + producto.getCategoria());
		                System.out.println("-----------------------------");
		            }
		        }
		}
		 
		 public static void modificarProducto(ArrayList<Producto> productos, Scanner scanner) {
		        if (productos.isEmpty()) {
		            System.out.println("No hay productos para modificar.");
		            return;
		        }

		        System.out.println("Modificar producto:");
		        System.out.print("Ingrese el indice del producto a modificar (0 - " + (productos.size() - 1) + "): ");
		        int indice = scanner.nextInt();
		        scanner.nextLine();

		        if (indice >= 0 && indice < productos.size()) {
		            Producto producto = productos.get(indice);
		            System.out.println("Producto actual:");
		            System.out.println("1- Descripcion: " + producto.getDescripcion());
		            System.out.println("2- Precio Unitario: $" + producto.getPrecioUnitario());
		            System.out.println("3- Origen de Fabricacion: " + producto.getOrigenFabricacion());
		            System.out.println("4- Categoria: " + producto.getCategoria());
		            System.out.print("Seleccione el numero de la opcin que quiere modificar: ");
		            int opcionModificar = scanner.nextInt();
		            scanner.nextLine();

		            switch (opcionModificar) {
		                case 1:
		                    System.out.print("Ingrese la nueva descripcion: ");
		                    String nuevaDescripcion = scanner.nextLine();
		                    producto.setDescripcion(nuevaDescripcion);
		                    break;
		                case 2:
		                    System.out.print("Ingrese el nuevo precio unitario: ");
		                    double nuevoPrecio = scanner.nextDouble();
		                    producto.setPrecioUnitario(nuevoPrecio);
		                    scanner.nextLine();
		                    break;
		                case 3:
		                    //Aqui se modifica el origen de fabricación
		                    System.out.println("------ Origen de fabricacion ------");
		                    System.out.println("1 - Argentina");
		                    System.out.println("2 - China");
		                    System.out.println("3 - Brasil");
		                    System.out.println("4 - Uruguay");
		                    System.out.print("Elija una opcion: ");
		                    int opcionOrigen = scanner.nextInt();
		                    Producto.OrigenFabricacion nuevoOrigen = null;
		                    switch (opcionOrigen) {
		                        case 1:
		                            nuevoOrigen = Producto.OrigenFabricacion.ARGENTINA;
		                            break;
		                        case 2:
		                            nuevoOrigen = Producto.OrigenFabricacion.CHINA;
		                            break;
		                        case 3:
		                            nuevoOrigen = Producto.OrigenFabricacion.BRASIL;
		                            break;
		                        case 4:
		                            nuevoOrigen = Producto.OrigenFabricacion.URUGUAY;
		                            break;
		                        default:
		                            System.out.println("Opcion de origen no valida. No se realizaran cambios.");
		                            break;
		                    }
		                    if (nuevoOrigen != null) {
		                        producto.setOrigenFabricacion(nuevoOrigen);
		                    }
		                    scanner.nextLine();
		                    break;
		                case 4:
		                    //Aqui se modifica la categoría
		                    System.out.println("------ Categoria ------");
		                    System.out.println("1 - Telefonia");
		                    System.out.println("2 - Informatica");
		                    System.out.println("3 - Electrohogar");
		                    System.out.println("4 - Herramientas");
		                    System.out.print("Elija una opcion: ");
		                    int opcionCategoria = scanner.nextInt();
		                    Producto.Categoria nuevaCategoria = null;
		                    switch (opcionCategoria) {
		                        case 1:
		                            nuevaCategoria = Producto.Categoria.TELEFONIA;
		                            break;
		                        case 2:
		                            nuevaCategoria = Producto.Categoria.INFORMATICA;
		                            break;
		                        case 3:
		                            nuevaCategoria = Producto.Categoria.ELECTROHOGAR;
		                            break;
		                        case 4:
		                            nuevaCategoria = Producto.Categoria.HERRAMIENTAS;
		                            break;
		                        default:
		                            System.out.println("Opcion de categoria no valida. No se realizaran cambios.");
		                            break;
		                    }
		                    if (nuevaCategoria != null) {
		                        producto.setCategoria(nuevaCategoria);
		                    }
		                    scanner.nextLine();
		                    break;
		                default:
		                    System.out.println("Opcion no valida. No se realizaran cambios.");
		                    break;
		            }
		            System.out.println("Producto modificado exitosamente.");
		        } else {
		            System.out.println("Indice de producto no valido.");
		        }
		    }

	}
