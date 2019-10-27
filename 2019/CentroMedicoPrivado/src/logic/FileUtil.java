package logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import logic.types.Speciality;

public class FileUtil {
	private static List<String[]> loadFile(String fileName) {
		String line;
		List<String[]> objects = new ArrayList<>();
		String[] element = null;
		try {
			BufferedReader file = new BufferedReader(new FileReader(fileName));
			while (file.ready()) {
				line = file.readLine();
				element = line.split("@");
				objects.add(element);
			}
			file.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found.");
		} catch (IOException ioe) {
			new RuntimeException("I/O Error.");
		}
		return objects;
	}

	public static List<Direction> loadDirections() {
		List<Direction> directions = new ArrayList<Direction>();
		for (String[] data : loadFile("src/files/directions.dat")) {
			long idDireccion = Long.parseLong(data[0]);
			String city = data[1];
			String street = data[2];
			int postalCode = Integer.parseInt(data[3]);
			String country = data[4];
			Direction direction = new Direction(idDireccion, city, street,
					postalCode, country);
			directions.add(direction);
		}
		return directions;
	}

	public static List<MedicalCenter> loadMedicalCenter() {
		List<MedicalCenter> hospitals = new ArrayList<MedicalCenter>();
		List<Direction> directions = loadDirections();
		for (String[] data : loadFile("src/files/medicalcenters.dat")) {
			Long id = Long.parseLong(data[0]);
			String name = data[1];
			boolean isPublic = Boolean.parseBoolean(data[2]);
			MedicalCenter center = new MedicalCenter(id, name, isPublic);
			for (Direction direction : directions) {
				if (direction.getIdDireccion() == Long.parseLong(data[3])) {
					center.setDirection(direction);
				}
			}
			hospitals.add(center);
		}
		return hospitals;
	}
	
	public static List<Doctor> loadDoctors(List<MedicalCenter> hospitals) {
		List<Doctor> doctors = new ArrayList<Doctor>();
		for (String[] data : loadFile("src/files/doctors.dat")) {
			Long idDoctor = Long.parseLong(data[0]);
			String name = data[1];
			String surname = data[2];
			Speciality speciality = Speciality.valueOf(data[3]);
			Double price = Double.parseDouble(data[4]);
			Doctor doctor = new Doctor(idDoctor, name, surname, speciality,
					price);
			doctors.add(doctor);
			for (MedicalCenter center : hospitals) {
				if (center.getId() == Long.parseLong(data[5])) {
					center.getDoctors().add(doctor);
					doctor.setMedicalCenter(center);
				}
			}
		}
		return doctors;
	}
	
	public static List<MedicalTest> loadMedicalTests(List<Doctor> doctors) {
		List<MedicalTest> tests = new ArrayList<>();
		for (String[] data : loadFile("src/files/medicalTest.dat")) {
			Long id = Long.parseLong(data[0]);
			double price = Double.parseDouble(data[1]);
			String name = data[2];
			int time= Integer.parseInt(data[3]);
			Speciality speciality = Speciality.valueOf(data[4]);
			MedicalTest medicalTest = new MedicalTest(id, price, name, time, speciality);
			tests.add(medicalTest);
			for (Doctor doctor: doctors) {
				if (doctor.getIdDoctor() == Long.parseLong(data[5])) {
					doctor.getMedicalTests().add(medicalTest);
				}
			}
		}
		return tests;
	}

}
