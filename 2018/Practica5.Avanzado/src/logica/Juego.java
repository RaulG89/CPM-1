package logica;


public class Juego {

	public final int DIM = 23;
	public final int POSICION_META = DIM -1;
	public final String IMG_META = "/img/zanahoria.jpg";
	private int[] tablero = new int [DIM];
	private Liebre liebre;
	

	public Juego() {
		inicializarJuego();
	}

	public void inicializarJuego() {
		for (int i = 0; i < DIM; i++) {
				tablero[i] = 50;
		}
		liebre = new Liebre("liebre.jpg");
	}

	public boolean lanzarDado() {
		boolean isPosible = false;
		Dado.lanzar();
		if (liebre.getPosicion() + Dado.getValor() < DIM)
			isPosible = true;
		return isPosible;	
	}

	
	private boolean isJugadaCorrecta(int i) {
		return (liebre.getPosicion() + Dado.getValor() == i);
	}

	public boolean resolverJugada(int i) {
		boolean resuelta = false;
		// Comprobamos que se trata de ir a la casilla correcta
		if (isJugadaCorrecta (i)){
			liebre.setPosicion(liebre.getPosicion() + Dado.getValor());
			// Incrementamos la puntuacion del corredor
			liebre.incrementaPuntuacion(tablero[i]);
			resuelta = true;
		}
		return resuelta;
	}

	public boolean isPartidaFinalizada() {
		return (liebre.getPosicion() == POSICION_META);
	}

	public Liebre getLiebre() {
		return liebre;
	}
}