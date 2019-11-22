package logic.cells;

import logic.Bet;

public interface Cell {
	Bet bet(int chip);

	void isWinner(int result);
}
