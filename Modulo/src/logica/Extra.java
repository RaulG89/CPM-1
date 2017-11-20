package logica;

/**
 * Clase que simula un extra en un camarote de barco
 * 
 * @author Iván González Mahagamage
 *
 */
public class Extra {
	private String codigo;
	private String descripcion;
	private float precio;
	private boolean añadido;

	/**
	 * Constructor con parámetros
	 * 
	 * @param codigo
	 *            Código para denominar el extra
	 * @param descripcion
	 *            Descripción del extra
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
	 * Método que devuelve el código del extra
	 * 
	 * @return El código del extra
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Método que modifica el codigo del extra
	 * 
	 * @param codigo
	 *            Nuevo código del extra
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Método que devuelve la descripción del extra
	 * 
	 * @return La descripción del extra
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Método que modifica la descripción del extra
	 * 
	 * @param descripcion
	 *            Nueva descripción del extra
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Método que devuelve el precio del extra
	 * 
	 * @return El precio del extra
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * Método que modifica el precio del extra
	 * 
	 * @param precio
	 *            Nuevo precio del extra
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * Método que devuelve el parámetro añadido del extra
	 * 
	 * @return Parámetro añadido del extra
	 */
	public boolean isAñadido() {
		return añadido;
	}

	/**
	 * Método que modifica el parámetro añadido del extra
	 * 
	 * @param añadido
	 *            El nuevo parámetro añadido del extra
	 */
	public void setAñadido(boolean añadido) {
		this.añadido = añadido;
	}
}
