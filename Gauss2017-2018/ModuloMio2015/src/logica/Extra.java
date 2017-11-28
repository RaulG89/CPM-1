package logica;

/**
 * Clase que simula un extra en un camarote de barco
 * 
 * @author Iv�n Gonz�lez Mahagamage
 *
 */
public class Extra {
	private String codigo;
	private String descripcion;
	private float precio;
	private boolean añadido;

	/**
	 * Constructor con par�metros
	 * 
	 * @param codigo
	 *            C�digo para denominar el extra
	 * @param descripcion
	 *            Descripci�n del extra
	 * @param precio
	 *            Precio del extra
	 */
	public Extra(String codigo, String descripcion, float precio) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		añadido = false;
	}

	/**
	 * M�todo que devuelve el c�digo del extra
	 * 
	 * @return El c�digo del extra
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * M�todo que modifica el codigo del extra
	 * 
	 * @param codigo
	 *            Nuevo c�digo del extra
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * M�todo que devuelve la descripci�n del extra
	 * 
	 * @return La descripci�n del extra
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * M�todo que modifica la descripci�n del extra
	 * 
	 * @param descripcion
	 *            Nueva descripci�n del extra
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * M�todo que devuelve el precio del extra
	 * 
	 * @return El precio del extra
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * M�todo que modifica el precio del extra
	 * 
	 * @param precio
	 *            Nuevo precio del extra
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * M�todo que devuelve el par�metro a�adido del extra
	 * 
	 * @return Par�metro a�adido del extra
	 */
	public boolean isAñadido() {
		return añadido;
	}

	/**
	 * M�todo que modifica el par�metro a�adido del extra
	 * 
	 * @param a�adido
	 *            El nuevo par�metro añadido del extra
	 */
	public void setAñadido(boolean añadido) {
		this.añadido = añadido;
	}
}
