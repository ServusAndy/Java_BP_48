import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class TestPhoneBook {

	public static void main(String[] args) {
		Function<String, Predicate<Contact>> withName = name -> contact -> contact.getName().equals(name);
		PhoneBook pb = new PhoneBook();
		Iterable<Contact> itr = pb.find(withName.apply("Alex"));
		itr = pb.find(olderThen(24));
		for(Contact c : itr) {
			System.out.println(c);
		}
		itr = pb.find(withName.apply("Alex").and(olderThen(24)));
		itr = pb.find(withName.apply("Alex").negate().and(olderThen(34)));
		
		List<String> list = new ArrayList<>();
		pb.find(withName.apply("Alex"), Contact::getCity, list);
		list.forEach(System.out::println);
	}
	
//	public static Predicate<Contact> withName(String name){
//		return contact -> Objects.equals(name, contact.getName());
//	}
	
	public static Predicate<Contact> olderThen(int age){
		return contact -> contact.getAge() >= age;
	}

}
