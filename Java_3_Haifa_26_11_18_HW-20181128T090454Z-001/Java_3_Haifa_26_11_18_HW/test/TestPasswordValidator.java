import static org.junit.Assert.*;

import org.junit.Test;

public class TestPasswordValidator {

	@Test(expected = PasswordLengthException.class)
	public void testPasswordLengthException() throws Exception {
		UserValidator.isPasswordValid("Ad1~");
	}
	
	@Test(expected = PasswordLowercaseException.class)
	public void testPasswordLowercaseException() throws Exception {
		UserValidator.isPasswordValid("AAAAAAAAA1~");
	}
	@Test(expected = PasswordUppercaseException.class)
	public void testPasswordUppercaseException() throws Exception {
		UserValidator.isPasswordValid("aaaaaaad1~");
	}
	@Test(expected = PasswordDigitException.class)
	public void testPasswordDigitException() throws Exception {
		UserValidator.isPasswordValid("Adddddddd~");
	}
	@Test(expected = PasswordSpecSymbolException.class)
	public void testPasswordSpecSymbolException() throws Exception {
		UserValidator.isPasswordValid("As12345678");
	}
	
	@Test
	public void testPasswordValid() throws Exception {
		assertEquals(true,UserValidator.isPasswordValid("As12345~") );
	}

}
