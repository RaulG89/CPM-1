package logica;

/**
 * Clase 'Tarifa' para el mñdulo entregable de CPM. Esta clase representa a
 * los precios del cine.
 * 
 * @author UO236852
 *
 */
public class Fare {
	/**
	 * Precio normal
	 */
	private float normal;
	/**
	 * Variaciñn del precio para pelñculas en 3D
	 */
	private float delta3d;
	/**
	 * Variaciñn del precio para packs de cumpleaños
	 */
	private float deltaCumpleaños;
	/**
	 * Variaciñn del precio para tarifas 'Serafina'
	 */
	private float deltaJubilados;

	/**
	 * Constructor para la clase 'Tarifa'
	 * 
	 * @param normal
	 *            Precio normal
	 * @param delta3d
	 *            Variaciñn para pelñculas 3D
	 * @param deltaCumpleaños
	 *            Variaciñn par cumpleaños
	 * @param deltaJubilados
	 *            Variaciñn para Serafina
	 */
	public Fare(float normal, float delta3d, float deltaCumpleaños,
			float deltaJubilados) {
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
