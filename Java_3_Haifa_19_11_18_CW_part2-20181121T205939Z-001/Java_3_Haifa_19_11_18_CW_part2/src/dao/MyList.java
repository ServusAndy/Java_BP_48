package dao;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class MyList<T> implements IList<T> {
	private T[] arr;
	private Comparator<T> comparator;
	private int count;
	
	public MyList() {
		arr = (T[]) new Object[10];
		count = 0;
	}
	public MyList(Comparator<T> comparator) {
		arr = (T[]) new Object[10];
		count = 0;
		this.comparator = comparator;
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(T item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(T item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(T item) {
		if(comparator == null) {
			return Arrays.binarySearch(arr, 0, count,item);
		}
		return Arrays.binarySearch(arr,0,count, item,comparator);
	}

	@Override
	public boolean contains(T item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
