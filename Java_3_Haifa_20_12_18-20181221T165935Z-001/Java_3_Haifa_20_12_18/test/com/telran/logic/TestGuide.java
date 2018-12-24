package com.telran.logic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.telran.data.History;
import com.telran.data.Museum;

public class TestGuide {

	IGuide guide;
	History tmpHistory;
	History tmpHistoryClone;
	Museum tmpMuseum;

	@Before
	public void setUp() {
		tmpHistory = new History(1,"Name","City","Address",true);
		tmpMuseum = new Museum(2, 
				"Museum", 
				"City", 
				"Address", 
				new String[] {"SUN","MON","TUE","WED"});
		tmpHistoryClone = new History(1,"Name","City","Address",true);
		
	}
	
	public void testDefaultAdd() {
		assertTrue(guide.add(tmpHistory));
		assertEquals(tmpHistory.id(),guide.get(tmpHistory.id()).id());
	}
	
	public void testUniqueAdd() {
		guide.add(tmpHistory);
		assertFalse(guide.add(tmpHistoryClone));
	}
	@Test
	public void test() {
		assertEquals(8,2+2*2);
	}

}
