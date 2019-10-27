package logic;

import java.util.ArrayList;
import java.util.List;

import logic.types.Speciality;

public class Doctor {

	private long idDoctor;
	private String name, surname;
	private Speciality speciality;
	private double price;
	private MedicalCenter medicalCenter;
	private List<MedicalTest> medicalTests;

	public Doctor(long idDoctor, String name, String surname,
			Speciality speciality, double price) {
		this.idDoctor = idDoctor;
		this.name = name;
		this.surname = surname;
		this.speciality = speciality;
		this.price = price;
		this.medicalTests = new ArrayList<MedicalTest>();
	}

	public long getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(long idDoctor) {
		this.idDoctor = idDoctor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public MedicalCenter getMedicalCenter() {
		return medicalCenter;
	}

	public void setMedicalCenter(MedicalCenter medicalCenter) {
		this.medicalCenter = medicalCenter;
	}

	public List<MedicalTest> getMedicalTests() {
		return medicalTests;
	}

	public void setMedicalTests(List<MedicalTest> medicalTests) {
		this.medicalTests = medicalTests;
	}

	@Override
	public String toString() {
		return "Doctor [idDoctor=" + idDoctor + ", name=" + name + ", surname="
				+ surname + ", speciality=" + speciality + ", price=" + price
				+ "]";
	}

}
