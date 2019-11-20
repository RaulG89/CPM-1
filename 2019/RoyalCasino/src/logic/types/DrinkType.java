package logic.types;

public enum DrinkType {
	ALCOHOLIC, NO_ALCOHOLIC;

	public static DrinkType getValue(int value) {
		try {
			return values()[value];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException("Elemento no definido");
		}
	}

	public static DrinkType getValue(String value) {
		return getValue(Integer.parseInt(value));
	}
}
