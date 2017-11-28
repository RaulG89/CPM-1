package logica;

/**
 * Clase 'Tarifa' para el m�dulo entregable de CPM.
 * Esta clase representa a los precios del cine.
 * @author UO236852
 *
 */
public class Fare {
	/**
	 * Precio normal
	 */
	private float normal;
	/**
	 * Variaci�n del precio para pel�culas en 3D
	 */
	private float delta3d;
	/**
	 * Variaci�n del precio para packs de cumplea�os
	 */
	private float deltaCumpleaños;
	/**
	 * Variaci�n del precio para tarifas 'Serafina'
	 */
	private float deltaJubilados;
	
	/**
	 * Constructor para la clase 'Tarifa'
	 * @param normal Precio normal
	 * @param delta3d Variaci�n para pel�culas 3D
	 * @param deltaCumplea�os Variaci�n par cumplea�os
	 * @param deltaJubilados Variaci�n para Serafina
	 */
	public Fare(float normal, float delta3d, float deltaCumpleaños, float deltaJubilados) {
		this.normal = normal;
		this.delta3d = delta3d;
		this.deltaCumpleaños = deltaCumpleaños;
		this.deltaJubilados = deltaJubilados;
	}

	public float getNormal() {
		return normal;
	}

	public float getDelta3d() {
		return delta3d;
	}

	public float getDeltaCumpleaños() {
		return deltaCumpleaños;
	}

	public float getDeltaJubilados() {
		return deltaJubilados;
	}
	
	
}
