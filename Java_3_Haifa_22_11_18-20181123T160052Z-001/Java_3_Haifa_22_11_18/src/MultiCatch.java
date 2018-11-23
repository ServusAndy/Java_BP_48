
public class MultiCatch {

	public static void main(String[] args) {
		try {
		int res = div(1,6);
		}catch(IllegalArgumentException ex) {
			System.out.println("Illegal exception");
		}catch(ArithmeticException ex) {
			System.out.println("ArithmeticException");
		}
		
		try {
			int res1 = div(10,0);
		}catch(IllegalArgumentException | ArithmeticException ex) {
			
		}
		
		try {
			boolean validation = emailValidator("vasya");
		} catch (EmailValidException e) {
			System.out.println("Error! " + e.getMessage());
		}
		

	}
	
	public static int div(int a, int b) {
		if(b == 0) {
			throw new ArithmeticException("Divide by zero!");
		}
		if(a == 0) {
			throw new IllegalArgumentException("a can't be 0!");
		}
		return a / b;
	}
	
	public static boolean emailValidator(String email) throws EmailValidException {
		if(!email.contains("@")) {
			throw new EmailValidException("Email must have @!");
		}
		return true;
	}

}
