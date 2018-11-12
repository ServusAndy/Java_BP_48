import java.util.Arrays;

public class TestSort {

	public static void main(String[] args) {
		Person[] arr = new Person[5];
		arr[0] = new Person("Vasya",25,123);
		arr[1] = new Person("Petya",22,321);
		arr[2] = new Person("Sofa",18,654);
		arr[3] = new Person("John",56,567);
		arr[4] = new Person("Anna",18,876);
		
//		sort(arr);
//		ComparatorByName comparator = new ComparatorByName();
		ComparatorById comparator = new ComparatorById();
		sort(arr, comparator);
//		for(int i = 0; i < arr.length;i++) {
//			System.out.println(arr[i]);
//		}
		
		Car[] cars = new Car[10];
		cars[0] = new Car("Civic",2018,435);
		cars[1] = new Car("Accord",2017,123);
		cars[2] = new Car("Corolla",2015,345);
		
//		Arrays.sort(cars,0,2);
		
		CarByModelComarator comparatorCar = new CarByModelComarator();
		Arrays.sort(cars,0,2,comparatorCar);
		for(int i = 0; i < cars.length; i++) {
			System.out.println(cars[i]);
		}

	}

	private static void sort(Person[] arr){
		for(int i = 0; i < arr.length-1;i++) {
			for(int j = 0; j < arr.length-1; j++) {
				if(arr[j].compareTo(arr[j+1]) > 0) {
					Person tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}
	
	private static void sort(Person[] arr, PersonComparator comparator) {
		for(int i = 0; i < arr.length-1;i++) {
			for(int j = 0; j < arr.length-1; j++) {
				if(comparator.compare(arr[j], arr[j+1]) > 0) {
					Person tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}
}
