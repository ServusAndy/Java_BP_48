
public class User {
	private String email;
	private String password;
	
	public User(String email, 
			String password) {
		this.email = email;
		this.password = password;
	}
	
	public boolean isEmailValid() {
		int at = email.indexOf("@");
		if(at < 0) {
			return false;
		}
		
		if(email.lastIndexOf("@") != at) {
			return false;
		}
		
		int dot = email.lastIndexOf(".");
		if(dot < 0 || dot < at) {
			return false;
		}
		
		if(email.length() - 1 - dot <= 1) {
			return false;
		}
		return true;
	}
	
	public boolean isPasswordValid() {
//		boolean[] arrValid = new boolean[5];
//		if(password.length() >= 8) {
//			arrValid[0] = true;
//		}
//		
//		char[] arr = password.toCharArray();
//		for(int i = 0; i < arr.length; i++) {
//			if(Character.isUpperCase(arr[i])) {
//				arrValid[1] = true;
//			}
//			
//			if(Character.isLowerCase(arr[i])) {
//				arrValid[2] = true;
//			}
//			
//			if(Character.isDigit(arr[i])) {
//				arrValid[3] = true;
//			}
//			
//			if(isSpecSymbol(arr[i])) {
//				arrValid[4] = true;
//			}
//		}
//		
//		for(int i = 0; i < arrValid.length; i++) {
//			if(!arrValid[i]) {
//				return false;
//			}
//		}
//		return true;
		return validPassword() == 31;
	}
	
	private int validPassword() {
		int res = 0;
		if(password.length() >= 8) {
			res = res | 1;
		}
		char[] arr = password.toCharArray();
		for(int i = 0; i < arr.length; i++) {
			if(Character.isUpperCase(arr[i])) {
				res = res | 2;
			}
			
			if(Character.isLowerCase(arr[i])) {
				res = res | 4;
			}
			
			if(Character.isDigit(arr[i])) {
				res = res | 8;
			}
			
			if(isSpecSymbol(arr[i])) {
				res = res | 16;
			}
		}
		return res;
	}
	
	private boolean isSpecSymbol(char c) {
		char[] arr = {'$','~','-','_'};
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == c) {
				return true;
			}
		}
		return false;
	}
}
