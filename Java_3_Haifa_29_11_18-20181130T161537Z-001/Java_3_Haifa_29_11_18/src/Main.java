import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> myList = new ArrayList<>();
		boolean res = myList.add("Vasya");
		myList.add(0, "Petya");
		String str = myList.get(1);
		System.out.println(str);
		
		str = myList.set(0, "Sofa");
		System.out.println(str);
		
		res = myList.remove("Sofa");
		System.out.println(res);
		
		str = myList.remove(0);
		System.out.println(str);
		
		int count = myList.size();
		System.out.println(count);
		res = myList.isEmpty();
		System.out.println(res);
		
		
		for(int i = 0; i < 100; i++) {
			myList.add("Name " + (i%10));
		}
		
		int index = myList.indexOf("Name 9");
		System.out.println(index);
		index = myList.lastIndexOf("Name 9");
		System.out.println(index);
		index = myList.indexOf("aaaa");
		System.out.println(index);
		
		res = myList.contains("Name 3");
		System.out.println(res);
		
		for(String name : myList) {
			System.out.println(name);
		}
		
		String[] arr = new String[myList.size()];
		myList.toArray(arr);
//		arr = (String[]) myList.toArray();
		
		List<String> list = Arrays.asList(arr);
		
		Collections.sort(myList);
		for(String name : myList) {
			System.out.println(name);
		}
		
		Collections.sort(myList,(o1,o2) -> o2.compareTo(o1));
		for(String name : myList) {
			System.out.println(name);
		}
		
		index = Collections.binarySearch(myList, "Name 4",(o1,o2)->o2.compareTo(o1));
		System.out.println(index);
		System.out.println("---------");
		myList.forEach(System.out::println);
		
		
	}

}
