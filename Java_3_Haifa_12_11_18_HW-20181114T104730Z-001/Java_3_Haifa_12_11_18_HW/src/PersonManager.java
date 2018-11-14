import java.util.Arrays;

public class PersonManager {
	private Person[] arr;
	private int count;
	
	public PersonManager() {
		arr = new Person[10];
		count = 0;
	}
	public void add(Person p) {
		//check for null
		int indx = indexOf(p);
		if(indx < 0) {
			indx = -indx-1;
			if(count == arr.length) {
				Person[] tmp = new Person[arr.length*2];
				for(int i = 0; i < arr.length; i++) {
					tmp[i] = arr[i];
				}
				arr = tmp;
			}
			for(int i = count; i > indx; i--) {
				arr[i] = arr[i-1];
			}
			arr[indx] = p;
			count++;
		}
	}
	
	public void remove(Person p) {
		int indx = indexOf(p);
		if(indx >= 0) {
			for(int i = indx; i < count-1;i++) {
				arr[i] = arr[i+1];
			}
			count--;
		}
	}
	
	public Person[] find(int minAge, int maxAge) {
		Person[] res = null;
		Person[] tmp = Arrays.copyOfRange(arr, 0, count);
		PersonAgeComparator comparator = new PersonAgeComparator();
		Arrays.sort(tmp,comparator);
		Person left = new Person("",Integer.MIN_VALUE,minAge);
		Person right = new Person("",Integer.MAX_VALUE,maxAge);
		int leftIndx = -Arrays.binarySearch(tmp, left,comparator)-1;
		int rightIndx = -Arrays.binarySearch(tmp, right,comparator)-1;
		res = Arrays.copyOfRange(tmp, leftIndx,rightIndx);
		return res;
	}
	
	private int indexOf(Person p) {
		return Arrays.binarySearch(arr,0,count,p);
	}
	public void display() {
		for(int i = 0; i < count; i++) {
			System.out.println(arr[i]);
		}
	}
}
