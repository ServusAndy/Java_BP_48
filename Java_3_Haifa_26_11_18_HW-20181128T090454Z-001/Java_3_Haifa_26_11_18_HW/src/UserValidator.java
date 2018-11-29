
public class UserValidator {
	public static void  main(String[] args) {
		try {
			System.out.println(isPasswordValid("As1234567~"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static boolean isPasswordValid(String password) throws Exception {
		boolean[] arrValid = new boolean[5];
		if(password.length() >= 8) {
			arrValid[0] = true;
		}
		
		char[] arr = password.toCharArray();
		for(int i = 0; i < arr.length; i++) {
			if(Character.isUpperCase(arr[i])) {
				arrValid[1] = true;
			}
			
			if(Character.isLowerCase(arr[i])) {
				arrValid[2] = true;
			}
			
			if(Character.isDigit(arr[i])) {
				arrValid[3] = true;
			}
			
			if(isSpecSymbol(arr[i])) {
				arrValid[4] = true;
			}
		}
		
		for(int i = 0; i < arrValid.length; i++) {
			if(!arrValid[i]) {
				if(i == 0) {
					throw new PasswordLengthException("Password need have min 8 symbols!"); 
				}else if(i == 1) {
					throw new PasswordUppercaseException("Password need contains one or more uppercase symbol!");
				}else if(i == 2){
					throw new PasswordLowercaseException("Password need contains one or more lowercasa symbol!");
				}else if(i == 3) {
					throw new PasswordDigitException("Password need contains one or more digit!");
				}else if(i == 4) {
					throw new PasswordSpecSymbolException("Password need contrains spec symbol $, ~, -, _");
				}
			}
		}
		return true;
	}
	
	private static boolean isSpecSymbol(char c) {
		char[] arr = {'$','~','-','_'};
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == c) {
				return true;
			}
		}
		return false;
	}
}

