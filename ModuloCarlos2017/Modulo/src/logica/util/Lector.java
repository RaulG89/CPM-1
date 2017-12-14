package logica.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import logica.Alojamiento;
import logica.Entradas;
import logica.Paquetes;
import logica.Parques;

public class Lector {

	private static final String FICHERO_ALOJAMIENTO = "src/data/alojamientos.dat";
	private static final String FICHERO_ENTRADAS = "src/data/entradas.dat";
	private static final String FICHERO_PARQUE = "src/data/tematicos.dat";
	private static final String FICHERO_PAQUETE = "src/data/paquetes.dat";
	private static BufferedReader b;

	public static ArrayList<Entradas> cargarEntradas() {
		ArrayList<Entradas> entradas = new ArrayList<Entradas>();
		try {
			b = new BufferedReader(new FileReader(FICHERO_ENTRADAS));
			while (b.ready()) {
				String entrada = b.readLine();
				String[] datosEntrada = entrada.split("@");
				Entradas e = new Entradas(datosEntrada[0], datosEntrada[1], Long.parseLong(datosEntrada[2]),
						Long.parseLong(datosEntrada[3]));
				entradas.add(e);
			}
		} catch (FileNotFoundException e) {
			System.out.println("El archivo fichero entradas no se encontro");
		} catch (IOException e) {
			new RuntimeException("Error de entrada/salida");
		}
		return entradas;

	}

	public static ArrayList<Parques> cargarParques() {
		ArrayList<Parques> parques = new ArrayList<Parques>();
		try {
			b = new BufferedReader(new FileReader(FICHERO_PARQUE));
			while (b.ready()) {
				String parque = b.readLine();
				String[] datosParque = parque.split("@");
				Parques p = new Parques(datosParque[0], datosParque[1], datosParque[2], datosParque[3], datosParque[4]);
				parques.add(p);
			}
		} catch (FileNotFoundException e) {
			System.out.println("El archivo fichero parques no se encontro");
		} catch (IOException e) {
			new RuntimeException("Error de entrada/salida");
		}
		return parques;

	}

	public static ArrayList<Alojamiento> cargarAlojamiento() {
		ArrayList<Alojamiento> alojamientos = new ArrayList<Alojamiento>();
		try {
			b = new BufferedReader(new FileReader(FICHERO_ALOJAMIENTO));
			while (b.ready()) {
				String alojamiento = b.readLine();
				String[] datosAlojamiento = alojamiento.split("@");
				Alojamiento a = new Alojamiento(datosAlojamiento[0], datosAlojamiento[1],
						Integer.parseInt(datosAlojamiento[2]), datosAlojamiento[3], datosAlojamiento[4],
						Integer.parseInt(datosAlojamiento[5]), Long.parseLong(datosAlojamiento[6]));
				alojamientos.add(a);
			}
		} catch (FileNotFoundException e) {
			System.out.println("El archivo fichero alojamiento no se encontro");
		} catch (IOException e) {
			new RuntimeException("Error de entrada/salida");
		}
		return alojamientos;

	}

	public static ArrayList<Paquetes> cargarPaquetes() {
		ArrayList<Paquetes> paquetes = new ArrayList<Paquetes>();
		try {
			b = new BufferedReader(new FileReader(FICHERO_PAQUETE));
			while (b.ready()) {
				String paquete = b.readLine();
				String[] datosPaquetes = paquete.split("@");
				Paquetes e = new Paquetes(datosPaquetes[0], datosPaquetes[1], datosPaquetes[2], datosPaquetes[3],
						Integer.parseInt(datosPaquetes[4]), Long.parseLong(datosPaquetes[5]),
						Long.parseLong(datosPaquetes[6]));
				paquetes.add(e);
			}
		} catch (FileNotFoundException e) {
			System.out.println("El archivo fichero paquetes no se encontro");
		} catch (IOException e) {
			new RuntimeException("Error de entrada/salida");
		}
		return paquetes;

	}

}
