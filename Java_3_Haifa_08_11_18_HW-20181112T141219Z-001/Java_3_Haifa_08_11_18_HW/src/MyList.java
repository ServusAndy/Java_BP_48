
public class MyList<T> implements IList<T>  {
	private T[] inner;
	private int count;
	
	public MyList() {
		inner = (T[]) new Object[10];
		count = 0;
	}
	
	public MyList(T[] outer) {
		if(outer != null) {
			this.inner = (T[]) new Object[outer.length];
			for(int i = 0; i < outer.length; i++) {
				add(outer[i]);
			}
		}else {
			this.inner = (T[]) new Object[10];
			count = 0;
		}
	}
	
	@Override
	public void add(T item) {
		if(item != null) {
			if(count == inner.length) {
				T[] tmp = (T[]) new Object[inner.length*2];
				for(int i = 0; i < inner.length; i++) {
					tmp[i] = inner[i];
				}
				inner = tmp;
			}
			int indx = indexOf(item);
			if(indx < 0) {
				inner[count++] = item;
			}
		}
		
	}

	@Override
	public void remove(T item) {
		int indx = indexOf(item);
		if(indx >= 0) {
			for(int i = indx; i < count-1; i++) {
				inner[i] = inner[i+1];
			}
			count--;
		}
		
	}

	@Override
	public int indexOf(T item) {
		for(int i = 0; i < count;i++) {
			if(inner[i].equals(item)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public void display() {
		for(int i = 0; i < count; i++) {
			System.out.println(inner[i]);
		}
		
	}

}
