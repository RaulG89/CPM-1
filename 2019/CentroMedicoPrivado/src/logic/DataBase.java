package logic;

import java.util.List;

public class DataBase {
	private List<Doctor> doctors;
	private List<Direction> directions;
	private List<MedicalCenter> hospitals;
	private List<MedicalTest> medicalTests;

	public DataBase() {
		directions = FileUtil.loadDirections();
		hospitals = FileUtil.loadMedicalCenter();
		doctors = FileUtil.loadDoctors(hospitals);
		medicalTests = FileUtil.loadMedicalTests(doctors);
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public List<Direction> getDirections() {
		return directions;
	}

	public void setDirections(List<Direction> directions) {
		this.directions = directions;
	}

	public List<MedicalCenter> getHospitals() {
		return hospitals;
	}

	public void setHospitals(List<MedicalCenter> hospitals) {
		this.hospitals = hospitals;
	}

	public List<MedicalTest> getMedicalTests() {
		return medicalTests;
	}

	public void setMedicalTests(List<MedicalTest> medicalTests) {
		this.medicalTests = medicalTests;
	}

}
