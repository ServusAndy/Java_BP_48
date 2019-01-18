import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestMap {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("Vasya", 23);
		map.put("Petya", 34);
		System.out.println(map.put("Vasya", 35));
		System.out.println(map.size());
		Integer value = map.get("Vasya");
		System.out.println(value);
//		int i = map.get("bbbb");
		value = map.getOrDefault("aaaa", 123);
		System.out.println(value);
		map.replace("aaaa", 35);
		System.out.println(map.get("aaaa"));
		System.out.println(map.remove("aaaa"));
		System.out.println(map.remove("Vasya", 35));
		
//		Set<String> keys = map.keySet();
//		for(String k : keys) {
//			Integer v = map.get(k);
//			map.put(k, v+10);
//		}
		
		Set<Map.Entry<String, Integer>> entries = map.entrySet();
		for(Entry<String, Integer> e : entries) {
			e.setValue(e.getValue()+10);
		}
		
		System.out.println(map.get("Petya"));

	}

}
