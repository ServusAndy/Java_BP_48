
public class Main {

	public static void main(String[] args) {
		double res = div(10,5);
		System.out.println(res);
		try {
			res = div(10,1);
			System.out.println(res);
		}catch(RuntimeException ex) {
			System.out.println("Error: " + ex.getMessage());
		}finally {
			System.out.println("God code!");
		}
		
		try {
			sum(0,15);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int i = Integer.parseInt("Vasya");
		System.out.println("Finish main!");
	}
	
	public static double div(int a, int b) {
		if(b == 0) {
			throw new RuntimeException("Divide by zero!");
		}
		return a * 1.0 / b;
	}
	
	public static void sum(int a, int b) throws Exception {
		if(a == 0) {
			throw new Exception("Hahaha!");
		}
	}

}
