package com.telran.data;

public interface IList<T> {
	public void add(T item);
	public void remove(T item);
	public int  indexOf(T item);
	public int  size();
	public T get(int index);
	//public void display();

}
