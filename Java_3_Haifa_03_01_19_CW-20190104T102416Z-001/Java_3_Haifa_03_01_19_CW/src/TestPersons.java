import java.util.Arrays;

public class TestPersons {

	public static void main(String[] args) {
		Person p1 = new Person("Person 1",23, 986);
		Person p2 = new Person("Person 2",18,123);
		Person[] persons = {p1,p2};
		sort(persons);
		System.out.println(Arrays.toString(persons));
		MyComparator comparator = new PersonNameCompareator();
		Utils.sort(persons, comparator);
		System.out.println(Arrays.toString(persons));
		Utils.sort(persons);
		System.out.println(Arrays.toString(persons));
		Arrays.sort(persons);
	}
	
	public static void sort(Person[] arr) {
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = 0; j < arr.length-1;j++) {
				if(compare(arr[j],arr[j+1]) > 0){
					Person tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}
	
	public static int compare(Person p1, Person p2) {
//		return p2.getAge() - p1.getAge();
		return Integer.compare(p1.getAge(), p2.getAge());
	}

}
