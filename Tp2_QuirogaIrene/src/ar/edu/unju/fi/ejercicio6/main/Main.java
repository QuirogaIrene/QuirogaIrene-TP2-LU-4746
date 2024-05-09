package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
	
		 // Creación de un felino doméstico
        FelinoDomestico gato = new FelinoDomestico("Garfield", (byte) 45, 12f);
        System.out.println(gato.toString());
        System.out.println("DATO:Garfield está manifestando comportamientos salvajes, entonces vamos a realizarla conversión a felino salvaje");
        // Definición de la expresion lambda para la conversión
        Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(),
                x.getEdad(), x.getPeso());

        // Realizamos la conversion
        FelinoSalvaje felino1 = converter.convert(gato);

        // Mostramos los datos del objeto felino salvaje felino1
        converter.mostrarObjeto(felino1);

        // Verificar que el objeto a convertir no es nulo
        if (Converter.isNotNull(felino1)) {
        	System.out.println(felino1.toString());
        	System.out.println("<<<Convirtiendo a tanner en Felino Domestico>>>>");
            // Usamos expresion lambda para conversion inversa
            Converter<FelinoSalvaje, FelinoDomestico> converterReverse = x -> new FelinoDomestico("Tanner",
                    (byte) 20, 186f);

            // Realizamos la conversión inversa
            FelinoDomestico felinoDomestico = converterReverse.convert(felino1);

            // Mostramos los datos del objeto felino doméstico
            converterReverse.mostrarObjeto(felinoDomestico);
        }
	}
}
