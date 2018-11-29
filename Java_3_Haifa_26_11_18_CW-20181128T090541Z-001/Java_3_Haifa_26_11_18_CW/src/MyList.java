import java.util.Iterator;

public class MyList implements Iterable<String>{
	private String[] arr = new String[10];
	private int count = 0;
	
	public void add(String str) {
		if(count < arr.length) {
			arr[count++] = str;
		}
	}

	@Override
	public Iterator<String> iterator() {
//		Object obj = new Object();
		return new Iterator<String>() {
			int curr = 0;
			@Override
			public boolean hasNext() {
//				obj = new Object();
				return curr < count;
			}

			@Override
			public String next() {
				return arr[curr++];
			}
			
		};
	}
}
