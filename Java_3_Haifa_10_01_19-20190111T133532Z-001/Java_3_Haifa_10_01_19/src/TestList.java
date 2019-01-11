import java.util.ArrayList;
import java.util.HashSet;

public class TestList {
	final String name;
	public TestList() {
		name = "";
	}
	public static void main(String[] args) {
		final int number;
		ArrayList<String> list = new ArrayList<>();
		list.add("Name 1");
		list.add("Name 2");
		list.add("Name 3");
		list.add("Name 4");
		list.add("Name 5");
		list.add("Name 6");
		
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		String e = (String) list.remove(0);
		System.out.println(e);
		
		System.out.println(list.remove("Name 2"));
		e = (String) list.get(3);
		System.out.println(e);
		boolean res = list.contains("Name 4");
		list.trimToSize();
		list.add(0, "New Name");
//		list.add(123);
		Object[] arr =  list.toArray();
		String[]  forType = new String[0];
		String[] arr1 = list.toArray(forType);
		for(String str : arr1) {
			System.out.println(str);
		}
		
		e = list.set(0, "Test Set");
		System.out.println(e);
		number = 45;
//		number = 34;
//		list.clear();
		removeInRange(list, 0, 3);
		System.out.println(list.size());
		
		HashSet<String> set = new HashSet<>();
		set.addAll(list);
		for(String str : set) {
			System.out.println("Set e: " + str);
		}
	

	}
	
	public static void removeInRange(final ArrayList<?> list, int from, int to) {
//		list = new ArrayList<>();
		list.subList(from, to).clear();
	}

}
