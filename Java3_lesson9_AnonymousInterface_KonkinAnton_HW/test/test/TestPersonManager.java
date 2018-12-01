package test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.telran.data.Person;
import com.telran.data.PersonManager;

public class TestPersonManager {
	public PersonManager manager; 
	
	@Before
	public void setUp() {
		manager = new PersonManager();		
	}
	@Test
	public void testAdd() {
		Assert.assertEquals(0, manager.size());
		manager.add(new Person("Vasya", 17, 101));
		manager.add(new Person("Gans", 20, 111));
		manager.add(new Person("Kolya", 22, 105));
		Assert.assertEquals(3, manager.size());
	}
	
	@Test
	public void testAddDuplicate() {
		Assert.assertEquals(0, manager.size());
		manager.add(new Person("Vasya", 17, 101));
		Assert.assertEquals(1, manager.size());
		manager.add(new Person("Vasya", 17, 101));
		Assert.assertEquals(1, manager.size());
		
	}
	
	@Test
	public void testAddExpandableArray() {
		Assert.assertEquals(0, manager.size());
		manager.add(new Person("Vasya1", 17, 100));
		manager.add(new Person("Vasya2", 18, 101));
		manager.add(new Person("Vasya3", 19, 102));
		manager.add(new Person("Vasya4", 22, 103));
		manager.add(new Person("Vasya5", 34, 104));
		manager.add(new Person("Vasya6", 45, 105));
		manager.add(new Person("Vasya7", 43, 106));
		manager.add(new Person("Vasya8", 32, 107));
		manager.add(new Person("Vasya9", 31, 108));
		manager.add(new Person("Vasya10", 20, 109));
		Assert.assertEquals(10, manager.size());
		manager.add(new Person("Vasya11", 21, 111));
		Assert.assertEquals(11, manager.size());
	}
	
	@Test
	public void testAddForNull() {
		Assert.assertEquals(0, manager.size());
		manager.add(null);
		Assert.assertEquals(0, manager.size());
		
	}
	
	@Test
	public void testRemoveForExistPerson() {
		manager.add(new Person("Vasya1", 17, 101));
		manager.add(new Person("Vasya2", 19, 102));
		Assert.assertEquals(2, manager.size());
		manager.remove(new Person("Vasya2", 19, 102));
		Assert.assertEquals(1, manager.size());
		
	}
	
	@Test
	public void testRemoveForNotExistPerson() {
		manager.add(new Person("Vasya1", 17, 101));
		manager.add(new Person("Vasya2", 19, 102));
		Assert.assertEquals(2, manager.size());
		manager.remove(new Person("Vasya3", 19, 103));
		Assert.assertEquals(2, manager.size());
	}
	
	@Test
	public void testRemoveForEmptyArray() {
		Assert.assertEquals(0, manager.size());
		manager.remove(new Person("Vasya3", 19, 103));
		Assert.assertEquals(0, manager.size());
	}
	
	@Test
	public void testRemoveForNull() {
		manager.add(new Person("Vasya1", 17, 101));
		manager.add(new Person("Vasya2", 19, 102));
		Assert.assertEquals(2, manager.size());
		manager.remove(null);
		Assert.assertEquals(2, manager.size());
		
		
	}
	
	@Test
	public void testFind() {
		manager.add(new Person("Vasya1", 17, 100));
		manager.add(new Person("Vasya2", 18, 101));
		manager.add(new Person("Vasya3", 19, 102));
		manager.add(new Person("Vasya4", 22, 103));
		manager.add(new Person("Vasya5", 34, 104));
		manager.add(new Person("Vasya6", 45, 105));
		manager.add(new Person("Vasya7", 43, 106));
		manager.add(new Person("Vasya8", 32, 107));
		manager.add(new Person("Vasya9", 31, 108));
		manager.add(new Person("Vasya10", 20, 109));
		Person[] test = {
				new Person("Vasya3", 19, 102),
				new Person("Vasya10", 20, 109),
				new Person("Vasya4", 22, 103),
				new Person("Vasya9", 31, 108),
				new Person("Vasya8", 32, 107)
				
		};
		Assert.assertArrayEquals(manager.find(19, 32), test);
		
	}
	
	@Test
	public void testHasNext() {
		Iterator<Person> it = manager.iterator();
		it.hasNext();
		Assert.assertEquals(false, it.hasNext());
		manager.add(new Person("Vasya1", 17, 100));
		manager.add(new Person("Vasya2", 18, 101));
		it.next();
		Assert.assertEquals(true, it.hasNext());
		it.next();
		Assert.assertEquals(false, it.hasNext());
	}
	@Test(expected = NoSuchElementException.class)
	public void testNext() {
		Iterator<Person> it = manager.iterator();
		Person p1 = new Person("Vasya1", 17, 100);
		Person p2 = new Person("Vasya2", 18, 101);
		manager.add(p1);
		manager.add(p2);
		Assert.assertEquals(p1, it.next());
		Assert.assertEquals(p2, it.next());
		Assert.assertEquals(null, it.next());
	}
	
	@Test
	public void testForEach() {
		Person p1 = new Person("Vasya1", 17, 100);
		Person p2 = new Person("Vasya2", 18, 101);
		Person[] arr = {p1, p2};
		int i = 0;
		manager.add(p1);
		manager.add(p2);
		for(Person p : manager) {
			if(!arr[i++].equals(p)) {
				fail();
			}
		}
		
	}

}
