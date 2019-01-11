import java.util.Collections;

public class TestMyList {

	public static void main(String[] args) {
		MyList<Parent> parentList = new MyList<>();
		MyList<Child> childList = new MyList<>();
		
		parentList.add(new Parent());
		parentList.add(new Child());
		System.out.println(parentList.size());
		childList.add(new Child());
		Parent p = childList.get(0);
		System.out.println(p);
		
		parentList.addAll(childList);
		childList.getAll(parentList);
		
		print(10);
		print(154,"String 1","String 2","String 3");
		String[] arr = {"1","2","3"};
		print(13,arr);
		Parent[] arr1 = new Child[10];
		
		String[] stringArr = {"A","B","C"};
//		stringArr[0] = 123;
		Object[] objArr = new Child[]{new Child(),new Child()};
//		objArr = (Object[])stringArr;
//		objArr[0] = new Integer(123);
		
	}
	//Varargs
	public static void print(int i,String... strings) {
		for(i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
	}

}
