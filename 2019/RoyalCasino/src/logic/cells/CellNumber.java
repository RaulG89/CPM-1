package logic.cells;

import logic.types.ColorType;

public class CellNumber {
	private int value;
	private ColorType colorType;

	public CellNumber(int value) {
		this.value = value;
		this.calculateColor();
	}

	private void calculateColor() {
		if (this.value == 10 || this.value == 28) {
			this.colorType = ColorType.BLACK;
		} else {
			String value = "" + this.value;
			while (value.length() > 1) {
				int count = 0;
				for (int i = 0; i < value.length(); i++) {
					char letter = value.charAt(i);
					count += Integer.valueOf("" + letter);
				}
				value = "" + count;
			}
			int color = isEvenNumber(Integer.parseInt(value));
			this.colorType = ColorType.getValue(color);
		}
	}

	private boolean isEven(int value) {
		return value % 2 == 0;
	}

	private int isEvenNumber(int value) {
		return isEven(value) ? 1 : 0;
	}
}
