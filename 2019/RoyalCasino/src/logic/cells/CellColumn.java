package logic.cells;

public class CellColumn extends AbstractCell {
	private static int NUM_COLUMN = 3;

	private int column;

	public CellColumn(int column) {
		this.column = column;
	}

	@Override
	public boolean isWinner(int result) {
		return result % NUM_COLUMN == column;
	}

}
