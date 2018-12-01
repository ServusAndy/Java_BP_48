package com.telran.data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PersonManager implements IList<Person>, Iterable<Person>{
	private Person[] arr;
	private int count;	

	public PersonManager() {
		super();
		this.arr = new Person[10];
		this.count = 0;
	}

	@Override
	public void add(Person item) {
		if(item == null) {
			return;
		}

		if(count == arr.length) {
			Person[] tmpArr = new Person[arr.length * 2];
			for (int i = 0; i < arr.length; i++) {
				tmpArr[i] = arr[i];
			}
			arr = tmpArr;
		}
		int index = indexOf(item);
		if(index < 0) {
			for (int i = count; i > (- index - 1); i--) {
				arr[i] = arr[i - 1];
			}
			arr[(-index - 1)] = item;
			count++;
		}
	}

	@Override
	public void remove(Person item) {
		if(item == null) {
			return;
		}
		int index = indexOf(item);
		if (index >=0) {
			for (int i = index; i < count - 1; i++) {
				arr[i] = arr[i + 1];
			}
			count--;
		}	
	}

	@Override
	public int indexOf(Person item) {
		return Arrays.binarySearch(arr, 0, count, item);
	}

	@Override
	public int size() {
		return count;
	}
	
	public Person[] find(int minAge, int maxAge) {
		Person[] res = null;
		Person[] tmp = Arrays.copyOfRange(arr, 0, count);
		Comparator<Person> comparator = new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				int res = Integer.compare(o1.getAge(), o2.getAge());
				if (res == 0) {
					res = Integer.compare(o1.getId(), o2.getId());
				}
				return res;
			}
			
		};
		Arrays.sort(tmp, comparator);
		Person left = new Person("", minAge, Integer.MIN_VALUE);
		Person right = new Person("", maxAge, Integer.MAX_VALUE);
		int leftIndx = -Arrays.binarySearch(tmp, left, comparator) - 1;
		int rightIndx = - Arrays.binarySearch(tmp, right, comparator) - 1;
		res = Arrays.copyOfRange(tmp, leftIndx, rightIndx);
		return res;
	}
	@Override
	public Person get(int index ) {
		if(index >= 0 && index < count) {
			return arr[index];
		}
		return null;
	}

	@Override
	public Iterator<Person> iterator() {
		return new Iterator<Person>() {
			int curr = 0;

			@Override
			public boolean hasNext() {
				
				return curr < count;
			}

			@Override
			public Person next() {
				if(hasNext()) {
					return arr[curr++];
				}
				throw new NoSuchElementException();
			}
		};
	}
}

