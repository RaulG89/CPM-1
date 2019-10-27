package logic;

import java.util.ArrayList;
import java.util.List;

public class MedicalCenter {

	private Long id;
	private String name;
	private boolean isPublic;
	private Direction direction;
	private List<Doctor> doctors;

	public MedicalCenter(long id, String name, boolean isPublic) {
		super();
		this.id = id;
		this.name = name;
		this.isPublic = isPublic;
		doctors = new ArrayList<Doctor>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	@Override
	public String toString() {
		return "MedicalCenter [id=" + id + ", name=" + name + ", isPublic="
				+ isPublic + ", direction=" + direction + "]";
	}

}
