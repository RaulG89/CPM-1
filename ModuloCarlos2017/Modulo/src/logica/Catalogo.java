package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import logica.util.Lector;

public class Catalogo {

	private ArrayList<Alojamiento> alojamientos;
	private ArrayList<Paquete> paquetes;
	private ArrayList<Entrada> entradas;
	private ArrayList<Parque> parques;
	private ArrayList<String> paises=new ArrayList<>();

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
	
	private void cargarPaises(){
		paises = new ArrayList<String>();
		for(int i=0;i<getParques().size();i++) {
			paises.add(getParques().get(i).getPais());
		}
	}
	
	public String[] cargarPaisesNoRepetidos() {
		cargarPaises();
        HashSet<String> hs = new HashSet<String>();
        hs.addAll(paises);
        paises.clear();
        paises.addAll(hs);
        
        String listaPaises[]=new String[paises.size()];
        for(int i=0;i<paises.size();i++) {
        		listaPaises[i]=paises.get(i);
        } 
		return listaPaises;
		
	}
}
