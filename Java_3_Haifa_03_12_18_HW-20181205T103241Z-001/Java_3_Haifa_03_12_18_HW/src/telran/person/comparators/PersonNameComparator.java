package telran.person.comparators;

import java.util.Comparator;

import telran.person.model.Person;

public class PersonNameComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		int res = o1.getName().compareTo(o2.getName());
		if(res == 0) {
			res = Integer.compare(o1.getId(), o2.getId());
		}
		return res;
	}

}
