package logica;

import java.util.*;

public class Catalogo {
	
	private static final String FICHERO_CATALOGO = "files/articulos.dat";
	private List<Articulo> listaCatalogo = null;
	
	public Catalogo(){
		listaCatalogo = new ArrayList<Articulo>();
		cargarArticulos();
	}

	private void cargarArticulos(){
		FileUtil.loadFile (FICHERO_CATALOGO, listaCatalogo);
	  }

	public Articulo[] getArticulos(){
		Articulo[] articulos = listaCatalogo.toArray(new Articulo[listaCatalogo.size()]);
		return articulos;	
	}
	
}
