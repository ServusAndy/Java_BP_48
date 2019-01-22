
public class ContactInfo {
	private String phone;
	private String email;
	private Address address;
	public ContactInfo(String phone, String email, Address address) {
		super();
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public Address getAddress() {
		return address;
	}
	
}
