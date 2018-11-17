import java.util.Iterator;

public class NameManager implements Iterable<String>{
	private String[] arr;
	private int count;
	
	public NameManager() {
		arr = new String[10];
		count = 0;
	}
	
	public void add(String name) {
		if(count < arr.length) {
			arr[count++] = name;
		}
	}
	
	public String get(int index) {
		if(index >= 0 && index < count) {
			return arr[index];
		}
		return null;
	}

	@Override
	public Iterator<String> iterator() {
		
		return new NameManagerIterator(this,0,count-1);
	}
}
