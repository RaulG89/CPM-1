package logic;

import java.util.ArrayList;
import java.util.List;

public class Rulete {
	public static final int MIN_LIMIT = 0;
	public static final int MAX_LIMIT = 36;

	private List<Cell> bets;

	public Rulete() {
		bets = new ArrayList<Cell>();
		for (int i = 0; i <= MAX_LIMIT; i++) {
			bets.add(new Cell(i));
		}
	}
}
