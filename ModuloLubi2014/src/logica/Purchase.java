package logica;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Clase 'Pedido' para el m�dulo entregable de CPM. Esta clase representa cada
 * una de las compras individuales de una persona f�sica en el TPV
 * 
 * @author UO236852
 *
 */
public class Purchase {
	/**
	 * Pel�cula que el cliente quiere ir a ver
	 */
	private Movie pelicula;
	/**
	 * Momento de la pel�cula
	 */
	private Moment momento;
	/**
	 * Lista de butacas que el cliente quiere comprar para esta pel�cula
	 */
	private ArrayList<Seat> butacas;
	/**
	 * Precio del pedido
	 */
	private float precio;
	/**
	 * Si el pedido est� o no seleccionado
	 */
	private boolean is;
	/**
	 * Clase que formatea el precio para que tenga solo dos decimales
	 */
	private DecimalFormat df;
	
	/**
	 * M�todo que devuelve si el pedido est� seleccionado
	 * @return Si el pedido est� seleccionado
	 */
	public boolean is() {
		return is;
	}
	/**
	 * M�todo que establece si el pedido est� seleccionado
	 * @param is Si el pedido est� seleccionado
	 */
	public void set(boolean is) {
		this.is = is;
	}

	/**
	 * Constructor para la clase 'Pedido'
	 * 
	 * @param pelicula
	 *            Pel�cula que se est� comprando
	 */
	public Purchase(Movie pelicula) {
		butacas = new ArrayList<Seat>();
		this.pelicula = pelicula;
		df = new DecimalFormat("###.00");
	}

	/**
	 * M�todo que a�ade una butaca a este pedido
	 * 
	 * @param butaca
	 *            Butaca a a�adir
	 */
	public void añadirButaca(Seat butaca) {
		if (butaca.getEstado(momento) == Seat.OCUPADA)
			throw new IllegalArgumentException(
					"Algo ha pasado: Esta butaca parece estar ocupada");
		if (butacas.contains(butaca))
			throw new IllegalArgumentException(
					"Algo ha pasado: Esta butaca ya est� seleccionada para su compra");

		butaca.setEstado(Seat.OCUPADA, momento);
		butacas.add(butaca);
	}

	/**
	 * M�todo que elimina una butaca a este pedido
	 * 
	 * @param butaca
	 *            Butaca a eliminar
	 */
	public void eliminarButaca(Seat butaca) {

		butacas.remove(butaca);
		butaca.setEstado(Seat.LIBRE, momento);
	}

	/**
	 * M�todo que modifica el precio del pedido
	 * 
	 * @param precio
	 *            Nuevo precio
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	/**
	 * M�todo que devuelve el precio de este pedido como cadena
	 * @return Precio (String)
	 */
	public String getPrecio() {
		return df.format(precio);
	}
	/**
	 * M�todo que devuelve el precio de este pedido como float
	 * @return Precio (float)
	 */
	public float getPrecioAsFloat() {
		return this.precio;
	}
	/**
	 * M�todo que devuelve la pel�cula para la cual este pedido existe
	 * @return Pel�cula
	 */
	public Movie getPelicula() {
		return pelicula;
	}
	/**
	 * M�todo que le asigna una pel�cula al pedido
	 * @param pelicula Pel�cula
	 */
	public void setPelicula(Movie pelicula) {
		this.pelicula = pelicula;
	}
	/**
	 * M�todo que devuelve la fecha de este pedido para el idioma seleccionado
	 * @param locale Idioma correspondiente
	 * @return Fecha en ese idioma
	 */
	public String getFecha(String locale) {
		return momento.getDate(locale);
	}
	/**
	 * M�todo que devuelve la hora de este pedido para el idioma seleccionado
	 * @param locale Idioma correspondiente
	 * @return Hora en ese idioma
	 */
	public String getHora(String locale) {
		return momento.getHour(locale);
	}
	/**
	 * M�todo que devuelve el momento de este pedido
	 * @return Momento de este pedido
	 */
	public Moment getMomento() {
		return this.momento;
	}
	/**
	 * M�todo que le asigna un momento a este pedido
	 * @param moment Momento de este pedido
	 */
	public void setMomento(Moment moment) {
		this.momento = moment;
	}
	/**
	 * M�todo que devuelve las butacas asignadas a este pedido
	 * @return Butacas de este pedido
	 */
	public ArrayList<Seat> getButacas() {
		return this.butacas;
	}
	/**
	 * M�todo que actualiza el precio del pedido para todas las
	 * butacas seg�n la tarifa correspondiente
	 * @param tarifa Tarifa
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
	 * M�todo que aplica un incremento a cada butaca de este pedido
	 * @param delta Incremento
	 */
	@SuppressWarnings("unused")
	public void applyDelta(float delta) {
		for (Seat b : this.butacas)
			this.precio += delta;
	}
	/**
	 * M�todo que elimina un incremento de cada butaca de este pedido
	 * @param delta Incremento
	 */
	@SuppressWarnings("unused")
	public void removeDelta(float delta) {
		for (Seat b : this.butacas)
			this.precio -= delta;
	}
	/**
	 * M�todo que imprime todas las butacas de este pedido seg�n el
	 * idioma correspondiente
	 * @param pw Flujo de salida
	 * @param locale Idioma
	 */
	public void printPurchase(PrintWriter pw, String locale) {
		pw.println(this.pelicula.getTitulo());
		pw.println(this.getFecha(locale) + " " + this.getHora(locale));
		pw.println(this.getPelicula().getSala().toString());
		for (Seat s : this.butacas) {
			if (locale.equals("es"))
				pw.println("    Butaca n� " + s.toString());
			else if (locale.equals("en"))
				pw.println("    Seat " + s.toString());
		}
	}
	/**
	 * M�todo que devuelve los datos del pedido para el idioma seleciconado
	 * @param locale Idioma
	 * @return Datos del pedido
	 */
	public String toString(String locale) {
		StringBuilder sb = new StringBuilder();
		if (locale.equals("es")) {
			// A�adir t�tulo
			sb.append(this.pelicula.getTitulo());
			if (this.pelicula.is3d())
				sb.append(" (3D)");
			else
				sb.append(" (2D)");
			sb.append("\n");
			// A�adir fecha y hora
			sb.append(this.getFecha(locale));
			sb.append(" a las ");
			sb.append(this.getHora(locale));
			sb.append("\n");
			// Si solo hay una butaca, poner el sustantivo en singular
			if (this.butacas.size() < 2)
				sb.append("Butaca ");
			else
				sb.append("Butacas ");
			// A�adir las butacas
			for (Seat b : this.butacas)
				sb.append(b + ", ");
			// Eliminar el �ltimo ', ' que sobra
			sb.delete(sb.length() - 2, sb.length() - 1);
			sb.append("\n");
			// A�adir el precio
			sb.append("Precio total: ");
			sb.append(df.format(precio) + " �");
		}
		else if (locale.equals("en")) {
			// A�adir t�tulo
			sb.append(this.pelicula.getTitulo());
			if (this.pelicula.is3d())
				sb.append(" (3D)");
			else
				sb.append(" (2D)");
			sb.append("\n");
			// A�adir fecha y hora
			sb.append(this.getFecha(locale));
			sb.append(" at ");
			sb.append(this.getHora(locale));
			sb.append("\n");
			// Si solo hay una butaca, poner el sustantivo en singular
			if (this.butacas.size() < 2)
				sb.append("Seat ");
			else
				sb.append("Seats ");
			// A�adir las butacas
			for (Seat b : this.butacas)
				sb.append(b + ", ");
			// Eliminar el �ltimo ', ' que sobra
			sb.delete(sb.length() - 2, sb.length() - 1);
			sb.append("\n");
			// A�adir el precio
			sb.append("Total price: ");
			sb.append(df.format(precio) + " �");
		}

		return sb.toString();
	}
}
