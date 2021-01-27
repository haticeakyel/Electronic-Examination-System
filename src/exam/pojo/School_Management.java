package exam.pojo;

public class School_Management extends User{


	private boolean isActive;

	public School_Management(String username, String password) {
		super(username, password);
	}

	public School_Management() {
		super();
	}


	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		isActive = active;
	}


}
