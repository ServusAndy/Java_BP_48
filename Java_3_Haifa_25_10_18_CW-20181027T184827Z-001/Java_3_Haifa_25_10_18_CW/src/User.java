
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
		Character.isAlphabetic('W');
		Character.isDigit('1');
		return true;
	}
}
