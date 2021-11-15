package Entiies;

public class User {
	//Attribut
	private String lastName;
	private String firstName;
	private String email;
	
	//Constructeur
	
	public User() {
		
	}

	/**
	 * 
	 * @param lastName
	 * @param firstName
	 * @param email
	 */
	public User(String lastName, String firstName, String email) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
	}

	//Getters setter
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//ToString
	@Override
	public String toString() {
		return "User [lastName=" + lastName + ", firstName=" + firstName + ", email=" + email + "]";
	}
	
	

	
	
	
}
