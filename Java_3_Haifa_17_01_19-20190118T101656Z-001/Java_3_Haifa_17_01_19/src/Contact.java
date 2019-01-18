
public class Contact {
	private String name;
	private String lastName;
	private int age;
	private String email;
	private String city;
	private String phone;
	
	public Contact(String name, String lastName, int age, String email, String city, String phone) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.city = city;
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}
	
	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	public String getCity() {
		return city;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Contact)) {
			return false;
		}
		Contact other = (Contact) obj;
		if (phone == null) {
			if (other.phone != null) {
				return false;
			}
		} else if (!phone.equals(other.phone)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", lastName=" + lastName + ", age=" + age + ", email=" + email + ", city="
				+ city + ", phone=" + phone + "]";
	}
	
	
}
