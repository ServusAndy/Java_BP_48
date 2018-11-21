package dao;

public interface IList<T> extends Iterable<T>{
	public boolean add(T item);
	public boolean remove(T item);
	public T remove(int index);
	public int indexOf(T item);
	public boolean contains(T item);
	public int size();
	
}
