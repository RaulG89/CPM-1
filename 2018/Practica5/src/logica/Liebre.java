package logica;

public class Liebre {
	private int puntuacion;
	private int posicion;
	private String foto;
	private boolean superpoder;

	public Liebre(String foto) {
		this.foto = foto;
		puntuacion = 0;
		posicion = 0;
	}

	public boolean isSuperpoder() {
		return superpoder;
	}

	public void setSuperpoder(boolean superpoder) {
		this.superpoder = superpoder;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public String getFoto() {
		return foto;
	}

	public void incrementaPuntuacion(int puntos) {
		puntuacion += puntos;
	}
}
