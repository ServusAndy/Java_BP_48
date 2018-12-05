import java.util.HashSet;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		System.out.println("Vasya".hashCode());
		System.out.println("Petya".hashCode());
		
		HashSet<String> names = new HashSet<>();
		names.add("Vasya");
		names.add("Petya");
		names.add("Sofa");
		
		for(String str : names) {
			
		}
		
		HashSet<Person> persons = new HashSet<>();
		persons.add(new Person("Vasya",123));
		persons.add(new Person("Petya",321));
		persons.add(new Person("Vasya",111));
		persons.add(new Person("Vasya",222));
		persons.add(new Person("Vasya",333));
		persons.add(new Person("Vasya",444));
		
		Iterator<Person> iterator = persons.iterator();
		while(iterator.hasNext()) {
			Person p = iterator.next();
			if(p.getName().equals("Vasya")) {
				iterator.remove();
			}
		}
		System.out.println(persons.size());
//		boolean flag = false;
//		while(!flag) {
//			flag = true;
//			for(Person p : persons) {
//				if(p.getName().equals("Vasya")) {
//					flag = false;
//					persons.remove(p);
//					break;
//				}
//			}
//		}

	}

}
