package logic;

import logic.types.ColorType;

public class Cell {
	private static int LIMIT_FAIL = 18;
	private static int NUM_COLUMN = 3;

	private int value;
	private ColorType colorType;

	public Cell(int value) {
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

	public int getDozen() {
		return value / 12;
	}

	public int getColumn() {
		return value % NUM_COLUMN;
	}

	public boolean isFail() {
		return value / LIMIT_FAIL == 1;
	}

	private boolean isEven(int value) {
		return value % 2 == 0;
	}

	private int isEvenNumber(int value) {
		return isEven(value) ? 1 : 0;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
		this.calculateColor();
	}

	public void setColorType(ColorType colorType) {
		this.colorType = colorType;
	}

	public ColorType getColorType() {
		return colorType;
	}

}
