package logic.cells;

import logic.types.ColorType;

public class CellColor extends AbstractCell {
	private ColorType colorType;

	@Override
	public boolean isWinner(int result) {
		return calculateColor(result).equals(colorType);
	}

}
