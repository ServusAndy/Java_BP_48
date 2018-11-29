import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		String[] names = {"Vasya","Anna","Petya","Vova"};
		Arrays.sort(names);
		System.out.println(Arrays.toString(names));
		
//		Comparator<String> comparator = new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//			
//				return o2.compareTo(o1);
//			}
//			
//		};
//		
//		Arrays.sort(names,comparator);
		
//		Arrays.sort(names, new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return o2.compareTo(o1);
//			}
//		});
		
		Arrays.sort(names,(o1,o2)->{
			int res = o2.compareTo(o1);
			System.out.println(res);
			return res;
			});
		System.out.println(Arrays.toString(names));
		
		MyList list = new MyList();
		list.add("Vasya");
		for(String str : list) {
			System.out.println(str);
		}

	}

}
