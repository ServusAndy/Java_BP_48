import java.util.Optional;

public class TestOptional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void printCities(Iterable<User> users) {
		for(User u : users) {
			ContactInfo ci = u.getContactInfo();
			if(ci != null) {
				Address a = ci.getAddress();
				if(a != null) {
					String city = a.getCity();
					if(city != null) {
						System.out.println(city);
					}else {
						System.out.println("NoCity");
					}
				}
			}
		}
	}
	
	public static void printCities1(Iterable<Optional<User>> users) {
		for(Optional<User> o : users) {
			String city = o.map(User::getContactInfo)
					.map(ContactInfo::getAddress)
					.map(Address::getCity).orElse("NoCity");
			System.out.println(city);
		}
	}

}
