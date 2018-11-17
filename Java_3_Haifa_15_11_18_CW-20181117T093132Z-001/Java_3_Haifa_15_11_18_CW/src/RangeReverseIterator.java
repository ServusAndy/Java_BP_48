import java.util.Iterator;

public class RangeReverseIterator implements Iterator<Integer>{

	private Range range;
	private int cur;
	public RangeReverseIterator(Range range) {
		this.range = range;
		cur = range.getEnd();
	}
	@Override
	public boolean hasNext() {
		return cur >= range.getStart();
	}

	@Override
	public Integer next() {
		return cur--;
	}

}
