package logic.types;

public enum ColorType {
	RED, BLACK;

	public static ColorType getValue(int value) {
		try {
			return values()[value];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException("Elemento no definido");
		}
	}

	public static ColorType getValue(String value) {
		return getValue(Integer.parseInt(value));
	}
}
