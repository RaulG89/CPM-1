package logica;

public class Liebre {
	private int puntuacion;
	private int posicion;
	private String foto; 
	private boolean superpoder;
	
	public boolean isSuperpoder() {
		return superpoder;
	}


	public Liebre(String foto) {
		this.foto = foto;
		puntuacion = 0;
		posicion = 0;
		superpoder=false;
	}
	
	public void setSuperpoder(boolean superpoder) {
		this.superpoder = superpoder;
	}


	public void setPuntuacion(int puntos)
	{
		puntuacion=puntos;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion (int posicion) {
		this.posicion = posicion;
	}

	public String getFoto() {
		return foto;
	}
	
	public void incrementaPuntuacion (int puntos){
		puntuacion += puntos;
	}
}
