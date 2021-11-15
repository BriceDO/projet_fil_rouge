package entities;

public class UserModel {
	//Attribut
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	//Constructeur

	public UserModel() {
		
	}

	/**
	 * 
	 * @param idUser
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @parma password
	 */
	public UserModel(int id ,String firstName,String lastName,  String email,String password) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.password = password;
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

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + "]";
	}

}
