package logic.cells;

public class CellFail {
	private static int LIMIT_FAIL = 18;

	public boolean isFail(int value) {
		return value / LIMIT_FAIL == 1;
	}
}
