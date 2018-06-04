package logica;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Clase 'Pedido' para el mñdulo entregable de CPM. Esta clase representa cada
 * una de las compras individuales de una persona fñsica en el TPV
 * 
 * @author UO236852
 *
 */
public class Purchase {
	/**
	 * Pelñcula que el cliente quiere ir a ver
	 */
	private Movie pelicula;
	/**
	 * Momento de la pelñcula
	 */
	private Moment momento;
	/**
	 * Lista de butacas que el cliente quiere comprar para esta pelñcula
	 */
	private ArrayList<Seat> butacas;
	/**
	 * Precio del pedido
	 */
	private float precio;
	/**
	 * Si el pedido estñ o no seleccionado
	 */
	private boolean is;
	/**
	 * Clase que formatea el precio para que tenga solo dos decimales
	 */
	private DecimalFormat df;

	/**
	 * Mñtodo que devuelve si el pedido estñ seleccionado
	 * 
	 * @return Si el pedido estñ seleccionado
	 */
	public boolean is() {
		return is;
	}

	/**
	 * Mñtodo que establece si el pedido estñ seleccionado
	 * 
	 * @param is
	 *            Si el pedido estñ seleccionado
	 */
	public void set(boolean is) {
		this.is = is;
	}

	/**
	 * Constructor para la clase 'Pedido'
	 * 
	 * @param pelicula
	 *            Pelñcula que se estñ comprando
	 */
	public Purchase(Movie pelicula) {
		butacas = new ArrayList<Seat>();
		this.pelicula = pelicula;
		df = new DecimalFormat("###.00");
	}

	/**
	 * Mñtodo que añade una butaca a este pedido
	 * 
	 * @param butaca
	 *            Butaca a añadir
	 */
	public void añadirButaca(Seat butaca) {
		if (butaca.getEstado(momento) == Seat.OCUPADA)
			throw new IllegalArgumentException(
					"Algo ha pasado: Esta butaca parece estar ocupada");
		if (butacas.contains(butaca))
			throw new IllegalArgumentException(
					"Algo ha pasado: Esta butaca ya estñ seleccionada para su compra");

		butaca.setEstado(Seat.OCUPADA, momento);
		butacas.add(butaca);
	}

	/**
	 * Mñtodo que elimina una butaca a este pedido
	 * 
	 * @param butaca
	 *            Butaca a eliminar
	 */
	public void eliminarButaca(Seat butaca) {

		butacas.remove(butaca);
		butaca.setEstado(Seat.LIBRE, momento);
	}

	/**
	 * Mñtodo que modifica el precio del pedido
	 * 
	 * @param precio
	 *            Nuevo precio
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * Mñtodo que devuelve el precio de este pedido como cadena
	 * 
	 * @return Precio (String)
	 */
	public String getPrecio() {
		return df.format(precio);
	}

	/**
	 * Mñtodo que devuelve el precio de este pedido como float
	 * 
	 * @return Precio (float)
	 */
	public float getPrecioAsFloat() {
		return this.precio;
	}

	/**
	 * Mñtodo que devuelve la pelñcula para la cual este pedido existe
	 * 
	 * @return Pelñcula
	 */
	public Movie getPelicula() {
		return pelicula;
	}

	/**
	 * Mñtodo que le asigna una pelñcula al pedido
	 * 
	 * @param pelicula
	 *            Pelñcula
	 */
	public void setPelicula(Movie pelicula) {
		this.pelicula = pelicula;
	}

	/**
	 * Mñtodo que devuelve la fecha de este pedido para el idioma seleccionado
	 * 
	 * @param locale
	 *            Idioma correspondiente
	 * @return Fecha en ese idioma
	 */
	public String getFecha(String locale) {
		return momento.getDate(locale);
	}

	/**
	 * Mñtodo que devuelve la hora de este pedido para el idioma seleccionado
	 * 
	 * @param locale
	 *            Idioma correspondiente
	 * @return Hora en ese idioma
	 */
	public String getHora(String locale) {
		return momento.getHour(locale);
	}

	/**
	 * Mñtodo que devuelve el momento de este pedido
	 * 
	 * @return Momento de este pedido
	 */
	public Moment getMomento() {
		return this.momento;
	}

	/**
	 * Mñtodo que le asigna un momento a este pedido
	 * 
	 * @param moment
	 *            Momento de este pedido
	 */
	public void setMomento(Moment moment) {
		this.momento = moment;
	}

	/**
	 * Mñtodo que devuelve las butacas asignadas a este pedido
	 * 
	 * @return Butacas de este pedido
	 */
	public ArrayList<Seat> getButacas() {
		return this.butacas;
	}

	/**
	 * Mñtodo que actualiza el precio del pedido para todas las butacas
	 * segñn la tarifa correspondiente
	 * 
	 * @param tarifa
	 *            Tarifa
	 */
	@SuppressWarnings("unused")
	public void updatePrecio(Fare tarifa) {
		this.precio = 0;
		for (Seat b : this.butacas) {
			this.precio += tarifa.getNormal();
			if (this.pelicula.is3d())
				this.precio += tarifa.getDelta3d();
		}
	}

	/**
	 * Mñtodo que aplica un incremento a cada butaca de este pedido
	 * 
	 * @param delta
	 *            Incremento
	 */
	@SuppressWarnings("unused")
	public void applyDelta(float delta) {
		for (Seat b : this.butacas)
			this.precio += delta;
	}

	/**
	 * Mñtodo que elimina un incremento de cada butaca de este pedido
	 * 
	 * @param delta
	 *            Incremento
	 */
	@SuppressWarnings("unused")
	public void removeDelta(float delta) {
		for (Seat b : this.butacas)
			this.precio -= delta;
	}

	/**
	 * Mñtodo que imprime todas las butacas de este pedido segñn el idioma
	 * correspondiente
	 * 
	 * @param pw
	 *            Flujo de salida
	 * @param locale
	 *            Idioma
	 */
	public void printPurchase(PrintWriter pw, String locale) {
		pw.println(this.pelicula.getTitulo());
		pw.println(this.getFecha(locale) + " " + this.getHora(locale));
		pw.println(this.getPelicula().getSala().toString());
		for (Seat s : this.butacas) {
			if (locale.equals("es"))
				pw.println("    Butaca nñ " + s.toString());
			else if (locale.equals("en"))
				pw.println("    Seat " + s.toString());
		}
	}

	/**
	 * Mñtodo que devuelve los datos del pedido para el idioma seleciconado
	 * 
	 * @param locale
	 *            Idioma
	 * @return Datos del pedido
	 */
	public String toString(String locale) {
		StringBuilder sb = new StringBuilder();
		if (locale.equals("es")) {
			// Añadir tñtulo
			sb.append(this.pelicula.getTitulo());
			if (this.pelicula.is3d())
				sb.append(" (3D)");
			else
				sb.append(" (2D)");
			sb.append("\n");
			// Añadir fecha y hora
			sb.append(this.getFecha(locale));
			sb.append(" a las ");
			sb.append(this.getHora(locale));
			sb.append("\n");
			// Si solo hay una butaca, poner el sustantivo en singular
			if (this.butacas.size() < 2)
				sb.append("Butaca ");
			else
				sb.append("Butacas ");
			// Añadir las butacas
			for (Seat b : this.butacas)
				sb.append(b + ", ");
			// Eliminar el ñltimo ', ' que sobra
			sb.delete(sb.length() - 2, sb.length() - 1);
			sb.append("\n");
			// Añadir el precio
			sb.append("Precio total: ");
			sb.append(df.format(precio) + " ñ");
		} else if (locale.equals("en")) {
			// Añadir tñtulo
			sb.append(this.pelicula.getTitulo());
			if (this.pelicula.is3d())
				sb.append(" (3D)");
			else
				sb.append(" (2D)");
			sb.append("\n");
			// Añadir fecha y hora
			sb.append(this.getFecha(locale));
			sb.append(" at ");
			sb.append(this.getHora(locale));
			sb.append("\n");
			// Si solo hay una butaca, poner el sustantivo en singular
			if (this.butacas.size() < 2)
				sb.append("Seat ");
			else
				sb.append("Seats ");
			// Añadir las butacas
			for (Seat b : this.butacas)
				sb.append(b + ", ");
			// Eliminar el ñltimo ', ' que sobra
			sb.delete(sb.length() - 2, sb.length() - 1);
			sb.append("\n");
			// Añadir el precio
			sb.append("Total price: ");
			sb.append(df.format(precio) + " ñ");
		}

		return sb.toString();
	}
}
