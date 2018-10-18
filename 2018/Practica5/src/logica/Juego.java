package logica;

public class Juego {

	public final int DIM = 11;
	public final int POSICION_META = DIM - 1;
	public final String IMG_META = "/img/zanahoria.jpg";
	private int[] tablero = new int[DIM];
	private Liebre liebre;

	// EY
	int posicionTrampa;
	int superpoder;

	public Juego() {
		inicializarJuego();
	}

	public int getPositionTrampa() {
		return posicionTrampa;
	}

	public Liebre getLiebre() {
		return liebre;
	}

	public void inicializarJuego() {
		for (int i = 0; i < DIM - 1; i++) {
			tablero[i] = 50;
		}
		tablero[DIM - 1] = 200;
		liebre = new Liebre("/img/liebre.jpg");
		colocarTrampa();
		colocarSuperPoder();
	}

	private void colocarTrampa() {
		do {
			posicionTrampa = ((int) (Math.random() * DIM - 1) + 1);
		} while (posicionTrampa == 0 || posicionTrampa == DIM - 1);
	}

	private void colocarSuperPoder() {
		do {
			superpoder = ((int) (Math.random() * DIM - 1) + 1);
		} while (superpoder == 0 || superpoder == DIM - 1
				|| superpoder == posicionTrampa);
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
		if (isJugadaCorrecta(i)) {
			liebre.setPosicion(liebre.getPosicion() + Dado.getValor());
			// EY
			if (liebre.getPosicion() == posicionTrampa) {
				resuelta = false;
			}
			// Incrementamos la puntuacion del corredor
			liebre.incrementaPuntuacion(tablero[i]);
			resuelta = true;
		}
		return resuelta;
	}

	public boolean isPartidaFinalizada() {
		return (liebre.getPosicion() == POSICION_META);
	}

	public boolean isGameOver() {
		return (liebre.getPosicion() == posicionTrampa);
	}
}