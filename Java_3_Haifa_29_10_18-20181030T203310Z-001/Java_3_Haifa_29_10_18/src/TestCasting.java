
public class TestCasting {

	public static void main(String[] args) {
		double d = 56.8;
		int i = (int) d;
		
		Person[] arr = new Person[5];
		
		Person p1 = new Person("Name1",123,25);
		Person p2 = new Person("Name2",321,27);
		Employee empl1 = new Employee("Name3",345,36,5000);
		arr[0] = p1;
		arr[1] = p2;
		arr[2] = empl1;
		print(arr);
	}
	
	public static void print(Person[] arr) {
		Employee p = (Employee) arr[2];
		System.out.println(arr[0].toString());
		System.out.println(arr[2].toString());
		
	}

}
