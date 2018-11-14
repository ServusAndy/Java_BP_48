package test;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import logic.Calc;
public class TestFirst {
	@Test
	public void testInt() {
		
		assertEquals(5, 6);
	}
	
	@Test
	public void testDouble() {
		assertEquals(3.14, Math.PI,0.01);
	}
	
	@Test
	public void testSort() {
		int[] excepted = {1,2,3,4,5};
		int[] actual = {2,3,4,1,5};
		Arrays.sort(actual);
		assertArrayEquals(excepted, actual);
		Calc c = new Calc();
	}
	
}
