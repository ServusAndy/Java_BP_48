package dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import data.Person;

public class TestPersonManager {

	PersonManager manager;
	
	@Before
	public void setUp() throws Exception {
		manager = new PersonManager();
	}
	
	@Test
	public void testAdd() {
		Person dummy = new Person("",1,1);
		manager.add(dummy);
		assertEquals(1, manager.size());
	}
	
	@Test
	public void testAddDuplicate() {
		Person dummy1 = new Person("",1,1);
		Person dummy2 = new Person("",1,1);
		manager.add(dummy1);
		manager.add(dummy2);
		assertEquals(1, manager.size());
	}
	
	@Test
	public void testAddExpandableArray() {
		manager.add(new Person("",1,1));
		manager.add(new Person("",2,1));
		manager.add(new Person("",3,1));
		assertEquals(3, manager.size());
	}
	
	@Test()
	public void testAddFoNull() {
		manager.add(null);
		assertEquals(0, manager.size());
	}

	@Test
	public void testRemoveForExist() {
		manager.add(new Person("",1,1));
		manager.add(new Person("",2,2));
		manager.remove(new Person("",1,1));
		assertEquals(1, manager.size());
	}
	
	@Test
	public void testRemoveForEmptyArray() {
		manager.remove(new Person("",1,1));
		assertEquals(0, manager.size());
	}
	
	@Test
	public void testRemoveForNotExistPerson() {
		manager.add(new Person("",1,1));
		manager.add(new Person("",2,2));
		manager.remove(new Person("",3,4));
		assertEquals(2, manager.size());
	}
	
	@Test
	public void testRemoveForNull() {
		manager.remove(null);
	}
	
}
