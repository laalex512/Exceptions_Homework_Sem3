package Homework3.Users;

public class User {

	private String firstName;
	private String secondName;
	private String lastName;
	private String birthDate;
	private Long phone;
	private Character male;

	public static Integer countUserCharacters = 6;

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public Long getPhone() {
		return phone;
	}

	public Character getMale() {
		return male;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public void setMale(Character male) {
		this.male = male;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("<%s><%s><%s><%s><%d><%c>", this.lastName, this.firstName,
			 this.secondName, this.birthDate, this.phone, this.male);
	}
}
