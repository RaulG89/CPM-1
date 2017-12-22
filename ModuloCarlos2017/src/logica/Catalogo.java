package logica;

import java.util.ArrayList;

import logica.util.Lector;

public class Catalogo {

	private ArrayList<Alojamiento> alojamientos;
	private ArrayList<Paquete> paquetes;
	private ArrayList<Entrada> entradas;
	private ArrayList<Parque> parques;

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

	public ArrayList<Paquete> getPaquetes() {
		return paquetes;
	}

	public ArrayList<Entrada> getEntradas() {
		return entradas;
	}

	public ArrayList<Parque> getParques() {
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
