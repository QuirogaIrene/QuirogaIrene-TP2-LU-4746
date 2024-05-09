package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio7.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio7.model.Producto.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio7.model.Producto;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static byte op;
	public static void main(String[] args) {
		ArrayList<Producto> productos = new ArrayList();
		precargarProductos(productos);
		do {
			op=menu();
			switch (op) {
			case 1:
				disponibles(productos);
				break;
			case 2: noDisponibles(productos);
				break;
			case 3: incrementarPrecio(productos);
				break;
			case 4: mostrarElectroHogaresDisponibles(productos);
				break;
			case 5: ordenDescendente(productos);
				break;
			case 6: mayuscula(productos);
				break;
			case 7: System.out.println("Finalizando programa...");
				break;
			default: System.out.println("OPCION INVALIDA");
				break;
			}
		}while(op!=7);
		System.out.println("Programa finalizado");

	}
	public static void precargarProductos(ArrayList<Producto> productos) {
		if (productos.isEmpty()) {
		    productos.add(new Producto("1", "Heladera Philips", 1000500, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, false));
	        productos.add(new Producto("2", "smartphone Samsung", 120000, OrigenFabricacion.CHINA, Categoria.TELEFONIA, true));
	        productos.add(new Producto("3", "laptop HP", 2500000, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true));
	        productos.add(new Producto("4", "taladro Black & Decker", 80000, OrigenFabricacion.CHINA, Categoria.HERRAMIENTAS, false));
	        productos.add(new Producto("5", "TV LG", 1500000, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, true));
	        productos.add(new Producto("6", "Mouse Logitech", 30000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
	        productos.add(new Producto("7", "cafetera Oster", 70000, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, false));
	        productos.add(new Producto("8", "Horno eléctrico", 120000, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, true));
	        productos.add(new Producto("9", "Impresora Epson", 90000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
	        productos.add(new Producto("10", "martillo Stanley", 50000, OrigenFabricacion.CHINA, Categoria.HERRAMIENTAS, true));
	        productos.add(new Producto("11", "Refrigerador Mabe", 1100000, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, false));
	        productos.add(new Producto("12", "router TP-Link", 60000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
	        productos.add(new Producto("13", "Aspiradora Electrolux", 85000, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, true));
	        productos.add(new Producto("14", "destornillador Phillips", 20000, OrigenFabricacion.CHINA, Categoria.HERRAMIENTAS, false));
	        productos.add(new Producto("15", "heladera Philips", 1000500, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, false));
		}
		
	}
   public static byte menu() {
	   byte op=0;
	   try {
		System.out.println("****************************************");
		System.out.println("1 Mostrar productos disponibles");
		System.out.println("2 Mostrar productos no disponibles");
		System.out.println("3 Incrementar precios en un 20%");
		System.out.println("4 Mostrar productos electro hogar disponibles");
		System.out.println("5 Ordenar productos por precio en forma descendente");
		System.out.println("6 Mostrar los productos con nombres en mayusculas");
		System.out.println("7 Salir");
		System.out.println("****************************************");
		System.out.print("Elija una opcion: ");
		op=sc.nextByte();
	} catch (Exception e) {
		System.err.println("Ingrese numeros para la opcion");
		sc.nextLine();
	}
	   return op;
   }
   public static void disponibles(ArrayList<Producto> productos) {
	   Consumer<Producto> mostrarProductos = p->System.out.println(p);
       productos.forEach(mostrarProductos);
   }
   public static void noDisponibles(ArrayList<Producto> productos) {
	   Predicate<Producto> filtrarNoDisponibles = x -> !x.getEstado();
	   productos.stream().filter(filtrarNoDisponibles).forEach(System.out::println);
   }
   public static void incrementarPrecio(ArrayList<Producto> productos) {
	   Function<Producto, Producto> funcionIncremento = (p)->{
		   double resultado = p.getPrecioUnitario() + (p.getPrecioUnitario() * 0.2f);
		   p.setPrecioUnitario(resultado);
		   return p;
	   };
	   List<Producto> productosIncrementados = new ArrayList<>();
	   productosIncrementados = productos.stream().map(funcionIncremento).collect(Collectors.toList());
	   productosIncrementados.forEach(System.out::println);
   }
   public static void ordenDescendente(ArrayList<Producto> productos) {
	   System.out.println("--------- Precios ordenados ---------");
	   productos.sort(Comparator.comparing(Producto::getPrecioUnitario).reversed());
	   productos.forEach(x -> System.out.println(x));
   }
   public static void mostrarElectroHogaresDisponibles(ArrayList<Producto> productos) {
	   Predicate<Producto> categoriaEstado = (e) -> e.getEstado()==true && e.getCategoria().equals(e.getCategoria().ELECTROHOGAR);
	   productos.stream().filter(categoriaEstado).forEach(System.out::println);
   }
   public static void mayuscula(ArrayList<Producto> productos) {
	   Function<Producto, Producto> aMayusculas = producto -> {
           Producto productoConMayusculas = new Producto(producto.getCodigo(),producto.getDescripcion().toUpperCase(),producto.getPrecioUnitario(),producto.getCategoria(),producto.getOrigenFabricacion(),producto.getEstado());
           return productoConMayusculas;
       };

       System.out.println("Productos con nombres en mayúsculas:");
       productos.stream().map(aMayusculas).forEach(System.out::println);
   }
}