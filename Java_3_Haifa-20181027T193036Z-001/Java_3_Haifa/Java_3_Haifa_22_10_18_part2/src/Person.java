
public class Person {
	private static int count = 0;
	private int age = 100;
	
	public Person() {
		count++;
	}
	
	public void printCount() {
		System.out.println(count);
	}
	
	public static void printAge() {
//		System.out.println(age);
	}
}
