

public class Main {

	public static void main(String[] args) {
		Integer number = new Integer(56);
		Integer number2 = 54;
		int res = number + number2;
		System.out.println(res);
		
		Integer a = 56;
		Integer b = 56;
		boolean result = a == number;
		System.out.println(result);
		
		System.out.println(Integer.MAX_VALUE);
		int c = Integer.parseInt("456");
		System.out.println(b + c);
		
		result = Boolean.parseBoolean("true");
		System.out.println(result);
		divide(145,0);
		divide(0,0);
		

	}
	
	public static void divide(double a, double b) {
		double res = a / b;
		System.out.println(res);
		boolean bool = Double.isInfinite(res);
		System.out.println(bool);
		bool = Double.isNaN(res);
		System.out.println(bool);
	}

}