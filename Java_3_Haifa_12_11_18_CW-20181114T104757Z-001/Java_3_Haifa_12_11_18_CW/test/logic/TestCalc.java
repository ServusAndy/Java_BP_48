package logic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCalc {
	Calc c;
	@Before
	public void setUp() {
		c = new Calc();
	}
	@Test
	public void testAdd() {
//		Calc c = new Calc();
		assertEquals(4, c.add(2, 2));
//		int excepted = 5;
//		int actual = c.add(2, 2);
//		if(excepted != actual) {
//			fail("All bad!");
//		}
	}
	
	@Test
	public void testDiv() {
//		Calc c = new Calc();
		assertEquals(5.0, c.div(10, 2),0.1);
	}
	
	@Test(expected = ArithmeticException.class)
	public void testDivException() {
		Calc c = new Calc();
		c.div(10, 0);
	}

}
