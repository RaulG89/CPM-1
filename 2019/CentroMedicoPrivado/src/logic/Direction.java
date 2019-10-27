package logic;

public class Direction {

	private long idDireccion;
	private String city;
	private String street;
	private int postalCode;
	private String country;

	public Direction(long idDireccion, String city, String street, int postalCode, String country) {
		this.idDireccion = idDireccion;
		this.city = city;
		this.street = street;
		this.postalCode = postalCode;
		this.country = country;
	}

	public long getIdDireccion() {
		return idDireccion;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return "Direction [idDireccion=" + idDireccion + ", city=" + city
				+ ", street=" + street + ", postalCode=" + postalCode
				+ ", country=" + country + "]";
	}
	
	

}
