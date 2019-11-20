package logic;

public class Chip {
	private int value;
	private int count;

	public Chip(int value, int count) {
		this.value = value;
		this.count = count;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + value;
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
		Chip other = (Chip) obj;
		if (count != other.count)
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Chip [value=" + value + ", count=" + count + "]";
	}

}
