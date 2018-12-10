import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		HashMap<String,Integer> map = new HashMap<>();
		Integer res = map.put("Vasya", 23);
		System.out.println(res);
		
		res = map.put("Vasya", 32);
		System.out.println(res);
		
		int value = map.get("Vasya");
		System.out.println(value);
		
		value = map.remove("Vasya");
		System.out.println(value + " size " + map.size());
		map.put("Key", 45);
		
		boolean isRemoved = map.remove("Key", 45);
		System.out.println(isRemoved);
		
		boolean isContains = map.containsKey("Key");
		System.out.println(isContains);
		Set<String> keys = map.keySet();
		Collection<Integer> values = map.values();
		
		Set<Map.Entry<String, Integer>> entries = map.entrySet();
		for(Map.Entry<String, Integer> entry : entries) {
			System.out.println("k = " + entry.getKey() + " : v = " + entry.getValue());
		}
		
		HashMap<String,Person> persons = new HashMap<>();
		
		Person p1 = new Person("Vasya",23,"1234567");
		Person p2 = new Person("Petya",25,"987654321");
		Person p3 = new Person("Sofa",34,"11111111");
		Person p4 = new Person("Dima",29,"222222");
		
		persons.put(p1.getId(), p1);
		persons.put(p2.getId(), p2);
		persons.put(p3.getId(), p3);
		persons.put(p4.getId(), p4);
		
		System.out.println(persons.get("1234567"));
		
		TreeMap<Integer,String> names = new TreeMap<>();
		names.put(23, "Vaysa");
		names.put(12, "Petya");
		names.put(9, "Anna");
		names.put(18, "Sofa");
		Set<Map.Entry<Integer, String>> myEntries = names.entrySet();
		for(Map.Entry<Integer, String> entry : myEntries) {
			System.out.println(entry);
		}

	}

}
