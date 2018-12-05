package telran.person.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import telran.person.comparators.PersonAgeComparator;
import telran.person.comparators.PersonNameComparator;
import telran.person.interfaces.IManager;
import telran.person.model.Person;

public class PersonManager implements IManager{
	private List<Person> idList;
	private List<Person> nameList;
	private List<Person> ageList;
	private Comparator<Person> nameComparator;
	private Comparator<Person> ageComparator;
	
	public PersonManager() {
		idList = new ArrayList<>();
		nameList = new ArrayList<>();
		ageList = new ArrayList<>();
		nameComparator = new PersonNameComparator();
		ageComparator = new PersonAgeComparator();
	}
	
	public PersonManager(List<Person> list) {
		idList = new ArrayList<>();
		nameList = new ArrayList<>();
		ageList = new ArrayList<>();
		nameComparator = new PersonNameComparator();
		ageComparator = new PersonAgeComparator();
		if(list!=null) {
			for(Person p : list) {
				add(p);
			}
		}
	}
	@Override
	public boolean add(Person p) {
		int indx = Collections.binarySearch(idList, p);
		if(indx < 0) {
			idList.add(-indx-1,p);
			indx = -Collections.binarySearch(ageList, p, ageComparator)-1;
			ageList.add(indx,p);
			indx = -Collections.binarySearch(nameList, p, nameComparator)-1;
			nameList.add(indx,p);
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(int id) {
		Person tmp = new Person("",id,-1);
		int indx = Collections.binarySearch(idList, tmp);
		if(indx >= 0) {
			tmp = idList.remove(indx);
			indx = Collections.binarySearch(ageList, tmp, ageComparator);
			ageList.remove(indx);
			indx = Collections.binarySearch(nameList, tmp, nameComparator);
			nameList.remove(indx);
			return true;
		}
		return false;
	}

	@Override
	public Person find(int id) {
		int indx = Collections.binarySearch(idList, new Person("",Math.abs(id),12));
		if(indx >= 0) {
			return idList.get(indx);
		}
		return null;
	}

	@Override
	public Iterable<Person> find(int minAge, int maxAge) {
		Person left = new Person("", Integer.MIN_VALUE,minAge);
		Person right = new Person("", Integer.MAX_VALUE,maxAge);
		int indxL = -Collections.binarySearch(ageList, left, ageComparator)-1;
		int indxR = -Collections.binarySearch(ageList, right, ageComparator)-1;
		return ageList.subList(indxL, indxR);
	}

	@Override
	public Iterable<Person> getAllPersonsById() {
		return idList;
	}

	@Override
	public Iterable<Person> getAllPersonsByName() {
		return nameList;
	}

	@Override
	public Iterable<Person> getAllPersonsByAge() {
		return ageList;
	}

	@Override
	public int size() {
		return idList.size();
	}

}
