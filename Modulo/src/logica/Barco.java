package logica;

import java.util.*;

/**
 * Clase que simula un barco de crucero
 * 
 * @author Iván González Mahagamage
 *
 */
public class Barco {
	private String codigo;
	private String denominacion;
	private String descripcion;
	private int numCamarotesDoblesInteriores;
	private int numCamarotesDoblesExteriores;
	private int numCamarotesFamiliaresInteriores;
	private int numCamarotesFamiliaresExteriores;
	private float precioCamarotesDoblesInteriores;
	private float precioCamarotesDoblesExteriores;
	private float precioCamarotesFamiliaresInteriores;
	private float precioCamarotesFamiliaresExteriores;
	private List<Camarote> camarotesBarco;
	private Capitan capitan;

	/**
	 * Constructor con parámetros
	 * 
	 * @param codigo
	 *            Código del barco
	 * @param denominacion
	 *            Denominación del barco
	 * @param descripcion
	 *            Descripción del barco
	 * @param numCamarotesDoblesInteriores
	 *            Número de camarotes dobles interiores
	 * @param numCamarotesDoblesExteriores
	 *            Número de camarotes dobles exteriores
	 * @param numCamarotesFamiliaresInteriores
	 *            Número de camarotes familiares interiores
	 * @param numCamarotesFamiliaresExteriores
	 *            Número de camarotes familiares exteriores
	 * @param precioCamarotesDoblesInteriores
	 *            Precio de los camarotes dobles interiores
	 * @param precioCamarotesDoblesExteriores
	 *            Precio de los camarotes dobles exteriores
	 * @param precioCamarotesFamiliaresInteriores
	 *            Precio de los camarotes familiares interiores
	 * @param precioCamarotesFamiliaresExteriores
	 *            Precio de los camarotes familiares exteriores
	 */
	public Barco(String codigo, String denominacion, Capitan capitan,
			String descripcion, int numCamarotesDoblesInteriores,
			int numCamarotesDoblesExteriores,
			int numCamarotesFamiliaresInteriores,
			int numCamarotesFamiliaresExteriores,
			float precioCamarotesDoblesInteriores,
			float precioCamarotesDoblesExteriores,
			float precioCamarotesFamiliaresInteriores,
			float precioCamarotesFamiliaresExteriores) {
		this.codigo = codigo;
		this.denominacion = denominacion;
		this.capitan = capitan;
		this.descripcion = descripcion;
		this.numCamarotesDoblesInteriores = numCamarotesDoblesInteriores;
		this.numCamarotesDoblesExteriores = numCamarotesDoblesExteriores;
		this.numCamarotesFamiliaresInteriores = numCamarotesFamiliaresInteriores;
		this.numCamarotesFamiliaresExteriores = numCamarotesFamiliaresExteriores;
		this.precioCamarotesDoblesInteriores = precioCamarotesDoblesInteriores;
		this.precioCamarotesDoblesExteriores = precioCamarotesDoblesExteriores;
		this.precioCamarotesFamiliaresInteriores = precioCamarotesFamiliaresInteriores;
		this.precioCamarotesFamiliaresExteriores = precioCamarotesFamiliaresExteriores;
		camarotesBarco = new ArrayList<Camarote>();
		crearCamarotes();
	}

	/**
	 * Rellena la lista de camarotes
	 */
	private void crearCamarotes() {
		for (int i = 0; i < numCamarotesDoblesInteriores; i++)
			camarotesBarco
					.add(new Camarote(Camarote.TIPO_DOBLE,
							Camarote.POSICION_INTERIOR,
							precioCamarotesDoblesInteriores));
		for (int i = 0; i < numCamarotesDoblesExteriores; i++)
			camarotesBarco
					.add(new Camarote(Camarote.TIPO_DOBLE,
							Camarote.POSICION_EXTERIOR,
							precioCamarotesDoblesExteriores));
		for (int i = 0; i < numCamarotesFamiliaresInteriores; i++)
			camarotesBarco.add(new Camarote(Camarote.TIPO_FAMILIAR,
					Camarote.POSICION_INTERIOR,
					precioCamarotesFamiliaresInteriores));
		for (int i = 0; i < numCamarotesFamiliaresExteriores; i++)
			camarotesBarco.add(new Camarote(Camarote.TIPO_FAMILIAR,
					Camarote.POSICION_EXTERIOR,
					precioCamarotesFamiliaresExteriores));
	}

	/**
	 * Método que devuelve el código del barco
	 * 
	 * @return El código del barco
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Método que modifica el código del barco
	 * 
	 * @param codigo
	 *            Nuevo código del barco
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Método que devuelve la denominación del barco
	 * 
	 * @return La denominación del barco
	 */
	public String getDenominacion() {
		return denominacion;
	}

	/**
	 * Método que modifica la denominación del barco
	 * 
	 * @param denominacion
	 *            Nueva denominación del barco
	 */
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	/**
	 * Método que devuelve la descripción del barco
	 * 
	 * @return La descripción del barco
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Método que modifica la descripción del barco
	 * 
	 * @param descripcion
	 *            Nueva descripción del barco
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Método que devuelve el número de camarotes dobles interiores del barco
	 * 
	 * @return El número de camarotes dobles interiores del barco
	 */
	public int getNumCamarotesDoblesInteriores() {
		return numCamarotesDoblesInteriores;
	}

	/**
	 * Método que modifica el número de camarotes dobles interiores del barco
	 * 
	 * @param numCamarotesDoblesInteriores
	 *            Nuevo número de camarotes dobles interiores del barco
	 */
	public void setNumCamarotesDoblesInteriores(int numCamarotesDoblesInteriores) {
		this.numCamarotesDoblesInteriores = numCamarotesDoblesInteriores;
	}

	/**
	 * Método que devuelve el número de camarotes dobles exteriores del barco
	 * 
	 * @return El número de camarotes dobles exteriores del barco
	 */
	public int getNumCamarotesDoblesExteriores() {
		return numCamarotesDoblesExteriores;
	}

	/**
	 * Método que modifica el número de camarotes dobles exteriores del barco
	 * 
	 * @param numCamarotesDoblesExteriores
	 *            Nuevo número de camarotes dobles exteriores del barco
	 */
	public void setNumCamarotesDoblesExteriores(int numCamarotesDoblesExteriores) {
		this.numCamarotesDoblesExteriores = numCamarotesDoblesExteriores;
	}

	/**
	 * Método que devuelve el número de camarotes familiares interiores del
	 * barco
	 * 
	 * @return El número de camarotes familiares interiores del barco
	 */
	public int getNumCamarotesFamiliaresInteriores() {
		return numCamarotesFamiliaresInteriores;
	}

	/**
	 * Método que modifica el número de camarotes familiares interiores del
	 * barco
	 * 
	 * @param numCamarotesFamiliaresInteriores
	 *            Nuevo número de camarotes familiares interiores del barco
	 */
	public void setNumCamarotesFamiliaresInteriores(
			int numCamarotesFamiliaresInteriores) {
		this.numCamarotesFamiliaresInteriores = numCamarotesFamiliaresInteriores;
	}

	/**
	 * Método que devuelve el número de camarotes familiares exteriores del
	 * barco
	 * 
	 * @return El número de camarotes familiares exteriores del barco
	 */
	public int getNumCamarotesFamiliaresExteriores() {
		return numCamarotesFamiliaresExteriores;
	}

	/**
	 * Método que modifica el número de camarotes familiares exteriores del
	 * barco
	 * 
	 * @param numCamarotesFamiliaresExteriores
	 *            Nuevo número de camarotes familiares exteriores del barco
	 */
	public void setNumCamarotesFamiliaresExteriores(
			int numCamarotesFamiliaresExteriores) {
		this.numCamarotesFamiliaresExteriores = numCamarotesFamiliaresExteriores;
	}

	/**
	 * Método que devuelve el precio de los camarotes familiares exteriores del
	 * barco
	 * 
	 * @return El precio de los camarotes familiares exteriores del barco
	 */
	public float getPrecioCamarotesDoblesInteriores() {
		return precioCamarotesDoblesInteriores;
	}

	/**
	 * Método que modifica el precio de los camarotes dobles interiores del
	 * barco
	 * 
	 * @param precioCamarotesDoblesInteriores
	 *            Nuevo precio de los camarotes dobles interiores
	 */
	public void setPrecioCamarotesDoblesInteriores(
			float precioCamarotesDoblesInteriores) {
		this.precioCamarotesDoblesInteriores = precioCamarotesDoblesInteriores;
	}

	/**
	 * Método que devuelve el precio de camarotes dobles exteriores del barco
	 * 
	 * @return El precio de camarotes dobles exteriores del barco
	 */
	public float getPrecioCamarotesDoblesExteriores() {
		return precioCamarotesDoblesExteriores;
	}

	/**
	 * Método que modifica el número de camarotes dobles exteriores del barco
	 * 
	 * @param numCamarotesDoblesExteriores
	 *            Nuevo número de camarotes dobles exteriores del barco
	 */
	public void setPrecioCamarotesDoblesExteriores(
			float precioCamarotesDoblesExteriores) {
		this.precioCamarotesDoblesExteriores = precioCamarotesDoblesExteriores;
	}

	/**
	 * Método que devuelve el precio de camarotes familiares interiores del
	 * barco
	 * 
	 * @return El precio de camarotes familiares interiores del barco
	 */
	public float getPrecioCamarotesFamiliaresInteriores() {
		return precioCamarotesFamiliaresInteriores;
	}

	/**
	 * Método que modifica el precio de los camarotes familiares interiores del
	 * barco
	 * 
	 * @param precioCamarotesFamiliaresInteriores
	 *            Nuevoprecio de camarotes familiares exteriores del barco
	 */
	public void setPrecioCamarotesFamiliaresInteriores(
			float precioCamarotesFamiliaresInteriores) {
		this.precioCamarotesFamiliaresInteriores = precioCamarotesFamiliaresInteriores;
	}

	/**
	 * Método que devuelve el precio de camarotes familiares exteriores del
	 * barco
	 * 
	 * @return El precio de camarotes familiares exteriores del barco
	 */
	public float getPrecioCamarotesFamiliaresExteriores() {
		return precioCamarotesFamiliaresExteriores;
	}

	/**
	 * Método que modifica el precio de los camarotes familiares exteriores del
	 * barco
	 * 
	 * @param precioCamarotesFamiliaresExteriores
	 *            Nuevo precio de camarotes familiares exteriores del barco
	 */
	public void setPrecioCamarotesFamiliaresExteriores(
			float precioCamarotesFamiliaresExteriores) {
		this.precioCamarotesFamiliaresExteriores = precioCamarotesFamiliaresExteriores;
	}

	/**
	 * Método que devuelve la lista de los camarotes del barcos
	 * 
	 * @return List de objetos Camarote
	 */
	public List<Camarote> getCamarotesBarco() {
		return camarotesBarco;
	}

	/**
	 * Método que cambia la lista de los camarotes del barco
	 * 
	 * @param camarotesBarco
	 *            Nueva lista de camarotes
	 */
	public void setCamarotesBarco(List<Camarote> camarotesBarco) {
		this.camarotesBarco = camarotesBarco;
	}

	public Capitan getCapitan() {
		return capitan;
	}

	public void setCapitan(Capitan capitan) {
		this.capitan = capitan;
	}

}
