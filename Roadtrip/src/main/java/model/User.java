package model;

public class User {
	//Attribut
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Boolean isAdmin;

	
	//Constructeur

	public User() {
		
	}

	/**
	 * 
	 * @param idUser
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 */
	
	
	
	public User(int id ,String firstName,String lastName,  String email,String password) {
		super();
		this.id = id;
		this.setLastName(lastName);
		this.setFirstName(firstName);
		this.setEmail(email);
		this.setPassword(password);
		
	}

	
	
	
	
	
	
	
	
	public User(int id, String firstName, String lastName, String email, String password, Boolean isAdmin) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	//Getters setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
	//ToString

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + "]";
	}

}
