package logica;

import java.util.ArrayList;

import logica.util.Lector;

public class Catalogo {

	private ArrayList<Alojamiento> alojamientos;
	private ArrayList<Paquetes> paquetes;
	private ArrayList<Entradas> entradas;
	private ArrayList<Parques> parques;

	public Catalogo() {
		entradas = Lector.cargarEntradas();
		alojamientos = Lector.cargarAlojamiento();
		paquetes = Lector.cargarPaquetes();
		parques = Lector.cargarParques();
		ponerDescuento();
	}

	public ArrayList<Alojamiento> getAlojamientos() {
		return alojamientos;
	}

	public ArrayList<Paquetes> getPaquetes() {
		return paquetes;
	}

	public ArrayList<Entradas> getEntradas() {
		return entradas;
	}

	public ArrayList<Parques> getParques() {
		return parques;
	}

	private void ponerDescuento() {
		int semilla = parques.size() - 1;
		int posicion;
		do {
			posicion = ((int) (Math.random() * semilla));
		} while (parques.get(posicion).isDescuento());
		parques.get(posicion).setDescuento(true);
	}
}
