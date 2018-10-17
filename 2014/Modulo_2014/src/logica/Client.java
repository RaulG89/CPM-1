package logica;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Clase 'Cliente' para el mñdulo entregable de CPM. Esta clase representa
 * todas las compras individuales de una persona fñsica en el TPV
 * 
 * @author UO236852
 *
 */
public class Client {
	/**
	 * El DNI del cliente (sñlo se rellena en la ñltima pantalla) Nota:
	 * Puede que no se use nunca
	 */
	@SuppressWarnings("unused")
	private String dni;
	/**
	 * Lista de todos los pedidos individuales de este cliente
	 */
	private ArrayList<Purchase> pedidos;
	/**
	 * Precio total de todos los pedidos de este cliente
	 */
	private float precioTotal;

	/**
	 * Constructor para la clase 'Cliente'
	 */
	public Client() {
		pedidos = new ArrayList<Purchase>();
	}

	/**
	 * Mñtodo que reinicia al cliente y simula que una nueva persona va a usar
	 * el TPV
	 */
	public void nuevoCliente() {
		this.dni = "";
		this.pedidos.clear();
	}

	/**
	 * Mñtodo que añade un nuevo pedido a este cliente
	 * 
	 * @param pedido
	 *            Pedido a añadir
	 */
	public void añadirPedido(Purchase pedido) {
		if (pedido == null)
			throw new IllegalArgumentException(
					"Algo ha pasado: El pedido es incorrecto o no existe");

		pedidos.add(pedido);
	}

	/**
	 * Mñtodo que elimina un pedido de este cliente
	 * 
	 * @param pedido
	 *            Pedido a eliminar
	 */
	public void eliminarPedido(Purchase pedido) {
		if (!pedidos.contains(pedido))
			throw new IllegalArgumentException(
					"Algo ha pasado: El pedido parece haber sido ya eliminado");

		pedidos.remove(pedido);
	}

	/**
	 * Mñtodo que devuelve el precio final de todos los pedidos de este
	 * cliente
	 * 
	 * @return Precio final
	 */
	public String getPrecioFinal() {
		DecimalFormat df = new DecimalFormat("###.00");
		Float precio = Float.valueOf(0);
		for (Purchase pc : pedidos)
			precio += pc.getPrecioAsFloat();
		return df.format(precio);
	}

	/**
	 * Mñtodo que devuelve una lista de pedidos de este cliente
	 * 
	 * @return Pedidos del cliente
	 */
	public ArrayList<Purchase> getPedidos() {
		return pedidos;
	}

	/**
	 * Mñtodo que devuelve el precio total en varias formas
	 * 
	 * @param type
	 *            Tipo de retorno deseado
	 * @return Float o String con el precio total
	 */
	public Object getPrecioTotal(Object type) {
		DecimalFormat df = new DecimalFormat("###.00");
		if (type instanceof Float)
			return precioTotal;
		else if (type instanceof String)
			return df.format(precioTotal);
		else
			return null;
	}

	/**
	 * Mñtodo que actualiza el precio total a partir de los pedidos
	 */
	public void updatePrecioTotal() {
		this.precioTotal = 0;
		for (Purchase p : this.pedidos) {
			this.precioTotal += p.getPrecioAsFloat();
		}
	}

	/**
	 * Mñtodo que aplica un incremento a cada pedido del cliente
	 * 
	 * @param delta
	 *            Incremento
	 */
	public void applyDelta(float delta) {
		System.out.println("****** Aplicando incremento de " + delta + " sobre "
				+ precioTotal + " ******");
		for (Purchase p : this.pedidos)
			p.applyDelta(delta);
		this.updatePrecioTotal();
	}

	/**
	 * Mñtodo que elimina un incremento a cada pedido del cliente
	 * 
	 * @param delta
	 *            Incremento
	 */
	public void removeDelta(float delta) {
		System.out.println("****** Eliminando incremento de " + delta
				+ " sobre " + precioTotal + " ******");
		this.precioTotal -= delta;
		for (Purchase p : this.pedidos)
			p.removeDelta(delta);
		this.updatePrecioTotal();
	}

	/**
	 * Mñtodo que imprime una lñnea de asteriscos muy mona
	 * 
	 * @param pw
	 *            Flujo de salida
	 * @param locale
	 *            Idioma del cliente
	 */
	public void printClient(PrintWriter pw, String locale) {
		for (Purchase p : this.pedidos) {
			p.printPurchase(pw, locale);
			pw.println("******** ******** ******** ********");
		}
	}
}
