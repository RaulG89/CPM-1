package logic.cells;

import logic.types.ColorType;

public abstract class AbstractCell implements Cell {
	protected boolean haveBet;
	protected int chip;

	public AbstractCell() {
		this.haveBet = false;
		this.chip = 0;
	}

	@Override
	public void addBet(int chip) {
		this.chip = chip;
		this.haveBet = true;
	}

	protected ColorType calculateColor(int value) {
		if (value == 10 || value == 28) {
			return ColorType.BLACK;
		} else {
			String stringValue = "" + value;
			while (stringValue.length() > 1) {
				int count = 0;
				for (int i = 0; i < stringValue.length(); i++) {
					char letter = stringValue.charAt(i);
					count += Integer.valueOf("" + letter);
				}
				stringValue = "" + count;
			}
			int color = isEvenNumber(Integer.parseInt(stringValue));
			return ColorType.getValue(color);
		}
	}

	private boolean isEven(int value) {
		return value % 2 == 0;
	}

	private int isEvenNumber(int value) {
		return isEven(value) ? 1 : 0;
	}
}
