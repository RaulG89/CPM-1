package logica;

import java.util.*;

public class Pedido {

	private List<Articulo> listaPedido = null;
	private boolean descuento;

	public Pedido() {
		listaPedido = new ArrayList<Articulo>();
		descuento = false;
	}

	public void add(Articulo articuloDelCatalogo, int unidades) {
		Articulo articuloEnPedido = null;

		for (Articulo a : listaPedido) {
			if (a.getCodigo().equals(articuloDelCatalogo.getCodigo()))
				articuloEnPedido = a;
		}

		if (articuloEnPedido == null) {
			Articulo articuloAPedido = new Articulo(articuloDelCatalogo);
			articuloAPedido.setUnidades(unidades);
			listaPedido.add(articuloAPedido);
		} else {
			int totalUnidades = articuloEnPedido.getUnidades() + unidades;
			articuloEnPedido.setUnidades(totalUnidades);
		}
	}

	public void delete(Articulo articuloDelCatalogo, int unidades) {
		Articulo articuloEnPedido = null;

		for (Articulo a : listaPedido) {
			if (a.getCodigo().equals(articuloDelCatalogo.getCodigo()))
				articuloEnPedido = a;
		}

		if (articuloEnPedido != null) {
			articuloEnPedido.setUnidades(articuloEnPedido.getUnidades() - unidades);
			articuloDelCatalogo.setUnidades(articuloEnPedido.getUnidades());
			if (articuloEnPedido.getUnidades() <= 0) {
				articuloDelCatalogo.setUnidades(0);
				listaPedido.remove(articuloEnPedido);
			}
		}
	}

	public float calcularTotalSinIva() {
		float total = 0.0f;

		for (Articulo a : listaPedido) {
			total += a.getPrecio() * a.getUnidades();
		}
		if (total >= 100f) {
			total *= 0.9;
			descuento = true;
		} else {
			descuento = false;
		}
		return total;
	}

	public boolean isDescuento() {
		return descuento;
	}

	public float generarDescuento(float total) {
		float descuento = 0.0f;
		descuento = 0.1f * total;
		return descuento;
	}

	public void grabarPedido(String nombreFichero, String comprador) {
		List<String> lineas = new ArrayList<>();
		lineas.add(listaPedido.toString());
		lineas.add(comprador);
		FileUtil.saveToFileString(nombreFichero, lineas);
	}

	public void inicializar() {
		listaPedido.clear();
	}

	public List<Articulo> getListaPedido() {
		return listaPedido;
	}

}
