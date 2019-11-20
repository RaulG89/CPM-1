package logic;

import logic.types.DrinkType;

public class Drink {
	private String code;
	private String denomination;
	private DrinkType type;
	private double price;

	public Drink(String code, String denomination, DrinkType type,
			double price) {
		super();
		this.code = code;
		this.denomination = denomination;
		this.type = type;
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public DrinkType getType() {
		return type;
	}

	public void setType(DrinkType type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((denomination == null) ? 0 : denomination.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Drink other = (Drink) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (denomination == null) {
			if (other.denomination != null)
				return false;
		} else if (!denomination.equals(other.denomination))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Drink [code=" + code + ", denomination=" + denomination
				+ ", type=" + type + ", price=" + price + "]";
	}

}
