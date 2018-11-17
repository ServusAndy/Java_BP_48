import java.util.Iterator;

public class NameManagerIterator implements Iterator<String>{

	private NameManager manager;
	private int cur;
	private int end;
	public NameManagerIterator(NameManager manager, int start, int end) {
		this.manager = manager;
		cur = start;
		this.end = end;
	}
	@Override
	public boolean hasNext() {

		return cur <= end;
	}

	@Override
	public String next() {
		return manager.get(cur++);
	}

}
