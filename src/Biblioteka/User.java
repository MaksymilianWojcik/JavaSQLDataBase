package Biblioteka;

public class User {
	private String name;
	private String lastname;
	private int phoneNumber;

	public User(String name, String lastname, int phoneNumber) {
		this.name = name;
		this.lastname = lastname;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
