import static org.junit.Assert.*;

import org.junit.Test;

public class TestValidator {

	@Test(expected=EmailValidException.class)
	public void testEmailContainsAt() throws EmailValidException {
//		try {
//			MultiCatch.emailValidator("vasya@");
//			fail("Fail exception");
//		} catch (EmailValidException e) {
//			
//		}
		MultiCatch.emailValidator("vasya");
	}

}
