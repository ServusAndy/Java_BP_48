package comparators;
import java.util.Comparator;

import data.Person;

public class PersonAgeComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		int res = Integer.compare(o1.getAge(), o2.getAge());
		if(res == 0) {
			res = Integer.compare(o1.getId(), o2.getId());
		}
		return res;
	}

}
