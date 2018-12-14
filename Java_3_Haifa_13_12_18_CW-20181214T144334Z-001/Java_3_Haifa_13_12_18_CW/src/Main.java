import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Car c = new Car("Civic","Honda",CarType.REGULAR);
		Car c1 = new Car("Accord","Honda",CarType.REGULAR);
		System.out.println(c.getType() == c1.getType());
		System.out.println(c.getType() == CarType.REGULAR);
		
		switch(c.getType()) {
		case REGULAR:
			System.out.println(c);
			break;
		}
		
		CarType type = CarType.valueOf("REGULAR");
		System.out.println(type);
		CarType[] arr = CarType.values();
		System.out.println(Arrays.toString(arr));

	}

}
