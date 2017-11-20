package logica;

import java.util.ArrayList;

/**
 * Clase que simula a un crucero de vacaciones
 * 
 * @author Iván González Mahagamage
 *
 */
public class Crucero {
	private String codigo;
	private String zona;
	private String denominacion;
	private String puertoSalida;
	private String itinerario;
	private String descripcion;
	private boolean menores;
	private int duracionDias;
	private String[] fechas;
	private ArrayList<ArrayList<Camarote>> camarotesFechas;
	private Barco barco;
	private boolean descuento;

	/**
	 * Constructor con parámetros
	 * 
	 * @param codigo
	 *            Codigo de identificación
	 * @param zona
	 *            Zona geográfica por las que pasa durante su trayecto
	 * @param denominacion
	 *            Denominación de la zona
	 * @param puertoSalida
	 *            Puerto de salida del crucero
	 * @param itinerario
	 *            Ciudades por las que pasa el barco durante el crucero
	 * @param descripcion
	 *            Descripción del crucero
	 * @param menores
	 *            Indica si se permiten menores de edad
	 * @param duracionDias
	 *            Dias que dira el crucero
	 * @param fechas
	 *            Fechas en las que se realiza el crucero
	 * @param barco
	 *            Barco que se utiliza en el crucero
	 */
	public Crucero(String codigo, String zona, String denominacion,
			String puertoSalida, String itinerario, String descripcion,
			boolean menores, int duracionDias, String[] fechas, Barco barco) {
		this.codigo = codigo;
		this.zona = zona;
		this.denominacion = denominacion;
		this.puertoSalida = puertoSalida;
		this.itinerario = itinerario;
		this.descripcion = descripcion;
		this.menores = menores;
		this.duracionDias = duracionDias;
		this.fechas = fechas;
		this.barco = barco;
		camarotesFechas = new ArrayList<ArrayList<Camarote>>();
		for (int i = 0; i < fechas.length; i++)
			camarotesFechas
					.add((ArrayList<Camarote>) barco.getCamarotesBarco());
		descuento = false;
	}

	/**
	 * Método que devuelve el código del crucero
	 * 
	 * @return El código del crucero
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Método que modifica el código del crucero
	 * 
	 * @param codigo
	 *            Nuevo código del crucero
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Método que devuelve la zona donde transcurre el crucero
	 * 
	 * @return La zona donde transcurre el crucero
	 */
	public String getZona() {
		return zona;
	}

	/**
	 * Método que modifica la zona donde transcurre el crucero
	 * 
	 * @param zona
	 *            Nueva zona donde transcurre el crucero
	 */
	public void setZona(String zona) {
		this.zona = zona;
	}

	/**
	 * Método que devuelve la denominación del crucero
	 * 
	 * @return La denominación del crucero
	 */
	public String getDenominacion() {
		return denominacion;
	}

	/**
	 * Método que modifica la denominación del crucero
	 * 
	 * @param denominacion
	 *            Nueva denominación del crucero
	 */
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	/**
	 * Método que devuelve el puerto de salida de un crucero
	 * 
	 * @return El puerta de salida de un crucero
	 */
	public String getPuertoSalida() {
		return puertoSalida;
	}

	/**
	 * Método que modifica el puerto de salida de un crucero
	 * 
	 * @param puertoSalida
	 *            Nuevo puerta de salida de un crucero
	 */
	public void setPuertoSalida(String puertoSalida) {
		this.puertoSalida = puertoSalida;
	}

	/**
	 * Método que devuelve el itinerario del crucero
	 * 
	 * @return El itinerario del crucero
	 */
	public String getItinerario() {
		return itinerario;
	}

	/**
	 * Método que modifica el itinerario del crucero
	 * 
	 * @param itinerario
	 *            Nuevo itinerario del crucero
	 */
	public void setItinerario(String itinerario) {
		this.itinerario = itinerario;
	}

	/**
	 * Método que devuelve la descripción del crucero
	 * 
	 * @return La descripción del crucero
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Método que modifica la descripción del crucero
	 * 
	 * @param descripcion
	 *            Nueva descripción del crucero
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Método que devuelve si en el crucero se admiten menores
	 * 
	 * @return True si se admiten menores en el crucero. En caso contrario false
	 */
	public boolean isMenores() {
		return menores;
	}

	/**
	 * Método que modifica el permiso para que entren menores en el crucero
	 * 
	 * @param menores
	 *            Nuevo permiso para que entren menores en el crucero
	 */
	public void setMenores(boolean menores) {
		this.menores = menores;
	}

	/**
	 * Método que devuelve la duración del crucero
	 * 
	 * @return La duración del crucero
	 */
	public int getDuracionDias() {
		return duracionDias;
	}

	/**
	 * Método que modifica la duración del crucero
	 * 
	 * @param duracionDias
	 *            Nueva duración del crucero
	 */
	public void setDuracionDias(int duracionDias) {
		this.duracionDias = duracionDias;
	}

	/**
	 * Método que devuelve las fechas de salida del crucero
	 * 
	 * @return Las fechas de salida del crucero
	 */
	public String[] getFechas() {
		return fechas;
	}

	/**
	 * Método que modifica las fechas de salida del crucero
	 * 
	 * @param fechas
	 *            Nuevas fechas de salida del crucero
	 */
	public void setFechas(String[] fechas) {
		this.fechas = fechas;
	}

	/**
	 * Método que devuelve el barco que se usa durante el crucero
	 * 
	 * @return El barco del crucero
	 */
	public Barco getBarco() {
		return barco;
	}

	/**
	 * Método que modifica el barco del crucero
	 * 
	 * @param barco
	 *            Nuevo barco del crucero
	 */
	public void setBarco(Barco barco) {
		this.barco = barco;
	}

	public ArrayList<ArrayList<Camarote>> getPasajerosFechas() {
		return camarotesFechas;
	}

	public void setPasajerosFechas(
			ArrayList<ArrayList<Camarote>> pasajerosFechas) {
		this.camarotesFechas = pasajerosFechas;
	}

	public boolean isDescuento() {
		return descuento;
	}

	public void setDescuento(boolean descuento) {
		this.descuento = descuento;
	}

}
