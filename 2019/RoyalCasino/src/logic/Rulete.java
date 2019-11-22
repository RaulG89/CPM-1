package logic;

import java.util.HashMap;
import java.util.Map;

public class Rulete {
	public static final int MIN_LIMIT = 0;
	public static final int MAX_LIMIT = 36;

	private Map<Integer, Bet> bets;

	public Rulete() {
		bets = new HashMap<Integer, Bet>();
	}
}
