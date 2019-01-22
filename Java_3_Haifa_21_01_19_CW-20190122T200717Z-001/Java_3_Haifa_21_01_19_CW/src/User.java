
public class User {
	private String name;
	private String lastName;
	private ContactInfo contactInfo;
	public User(String name, String lastName, ContactInfo contactInfo) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.contactInfo = contactInfo;
	}
	public String getName() {
		return name;
	}
	public String getLastName() {
		return lastName;
	}
	public ContactInfo getContactInfo() {
		return contactInfo;
	}
	
}
