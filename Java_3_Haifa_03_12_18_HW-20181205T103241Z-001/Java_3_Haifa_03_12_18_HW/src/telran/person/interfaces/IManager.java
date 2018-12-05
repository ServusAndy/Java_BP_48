package telran.person.interfaces;

import telran.person.model.Person;

public interface IManager {
	boolean add(Person p);
	boolean remove(int id);
	Person find(int id);
	Iterable<Person> find(int minAge, int maxAge);
	Iterable<Person> getAllPersonsById();
	Iterable<Person> getAllPersonsByName();
	Iterable<Person> getAllPersonsByAge();
	int size();
}
