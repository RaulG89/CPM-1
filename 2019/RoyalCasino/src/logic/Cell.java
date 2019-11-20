package logic;

import logic.types.ColorType;

public class Cell {
	private int value;
	private ColorType colorType;

	public void knowColor() {
		String value = "" + this.value;
		while (value.length() > 1) {
			int count = 0;
			for (int i = 0; i < value.length(); i++) {
				count += Integer.valueOf(value.charAt(i));
			}
			value = "" + count;
		}
		int color = isEvenNumber(Integer.parseInt(value));
		this.colorType = ColorType.getValue(color);
	}

	private boolean isEven(int value) {
		return value % 2 == 0;
	}

	private int isEvenNumber(int value) {
		return isEven(value) ? 1 : 0;
	}
}
