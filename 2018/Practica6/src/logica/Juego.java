package logica;

public class Juego {

	public final int DIM = 11;
	public final int POSICION_META = DIM - 1;
	public final String IMG_META = "/img/zanahoria.jpg";
	private int[] tablero = new int[DIM];
	private boolean[] tableroTrampas = new boolean[DIM];
	private Liebre liebre;
	int superpoder;

	public Juego(int numTrampas) {
		inicializarJuego(numTrampas);
	}

	public void inicializarJuego(int numTrampas) {
		for (int i = 0; i < DIM - 1; i++) {
			tablero[i] = 50;
			tableroTrampas[i] = false;
		}
		tablero[DIM - 1] = 250;
		liebre = new Liebre("/img/liebre.jpg");
		colocarNTrampas(numTrampas);
		colocarSuperPoder();

	}

	public boolean lanzarDado() {
		boolean isPosible = false;
		Dado.lanzar();
		if (liebre.getPosicion() + Dado.getValor() < DIM)
			isPosible = true;
		return isPosible;
	}

	private boolean isJugadaCorrecta(int i) {
		return (!(i <= liebre.getPosicion()) && liebre.getPosicion() + Dado.getValor() >= i);
	}

	public boolean resolverJugada(int i) {
		boolean resuelta = false;
		// Comprobamos que se trata de ir a la casilla correcta
		if (isJugadaCorrecta(i)) {
			liebre.setPosicion(i);
			// Incrementamos la puntuacion del corredor
			liebre.incrementaPuntuacion(tablero[i]);
			resuelta = true;
		}
		if (liebre.getPosicion() == superpoder) {
			liebre.setSuperpoder(true);
			System.out.println("Liebre con superpoder");
		}
		return resuelta;
	}

	private void colocarSuperPoder() {
		do {
			superpoder = ((int) (Math.random() * DIM - 1) + 1);
		} while (superpoder == 0 || superpoder == DIM - 1 || tableroTrampas[superpoder]);
		tablero[superpoder] = 550;
		System.out.println("Superpoder en " + superpoder);
	}

	private void colocarNTrampas(int numTrampas) {
		if (numTrampas > 4) {
			numTrampas = 4;
		}
		for (int i = 0; i < numTrampas; i++) {
			colocarTrampa();
		}
	}

	private void colocarTrampa() {
		int posicionTrampa;
		do {
			posicionTrampa = ((int) (Math.random() * DIM - 1) + 1);
			System.out.println("Trampa en " + posicionTrampa);
		} while (posicionTrampa == 0 || posicionTrampa == DIM - 1 || tableroTrampas[posicionTrampa]);
		tableroTrampas[posicionTrampa] = true;
	}

	public int getSuperpoder() {
		return superpoder;
	}

	public void setSuperpoder(int superpoder) {
		this.superpoder = superpoder;
	}

	public boolean isPartidaFinalizada() {
		return (liebre.getPosicion() == POSICION_META);
	}

	public boolean isPartidaFinalizadaTrampa() {
		return tableroTrampas[liebre.getPosicion()];
	}

	public boolean isLiebreSuperPoder() {
		return (liebre.getPosicion() == superpoder);
	}

	public Liebre getLiebre() {
		return liebre;
	}

	public boolean getPosicionTrampa(int i) {
		return tableroTrampas[i];
	}

}