package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	//nombre de la provincia (poblacion,superficie en k^2)
 	JUJUY(776086, 53219),
    SALTA(1333365, 155488),
    TUCUMAN(1694659, 22524),
    CATAMARCA(367820, 102602),
    LA_RIOJA(333642, 89680),
    SANTIAGO_DEL_ESTERO(874006, 136351);
	
	private final double cantidadPoblacion;
	private  final double superficie;
	
	private Provincia(double cantidadPoblacion, double superficie) {
		this.cantidadPoblacion = cantidadPoblacion;
		this.superficie = superficie;
	}

	public double getCantidadPoblacion() {
		return cantidadPoblacion;
	}


	public double getSuperficie() {
		return superficie;
	}

	 public double calcularDensidadPoblacional() {
	        return (double) cantidadPoblacion / superficie;
	    }
}
