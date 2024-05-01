package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		
		Provincia[] provincias = Provincia.values();

        //Muestra la informacion de cada provincia
        for (Provincia provincia : provincias) {
            System.out.println("Provincia: " + provincia);
            System.out.println("Poblacion: " + provincia.getCantidadPoblacion());
            System.out.println("Superficie: " + provincia.getSuperficie() + " km^2");
            System.out.println("Densidad Poblacional: " + provincia.calcularDensidadPoblacional() + " hab/km^2");
            System.out.println(); // Salto de línea para separar a cada  una de las provincias.
        }
	}

}
