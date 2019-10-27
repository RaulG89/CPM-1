package logic;

import logic.types.Speciality;

public class MedicalTest {

	private long id;
	private double price;
	private String name;
	private int time;
	private Speciality speciality;

	public MedicalTest(long id, double price, String name, int time, Speciality speciality) {
		this.id = id;
		this.price = price;
		this.name = name;
		this.time = time;
		this.speciality = speciality;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	@Override
	public String toString() {
		return "MedicalTest [id=" + id + ", price=" + price + ", name=" + name
				+ ", time=" + time + ", speciality=" + speciality + "]";
	}

	
}
