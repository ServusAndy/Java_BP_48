import java.util.Iterator;

public class RangeIterator implements Iterator<Integer>{
	private Range r;
	private int cur;
	
	public RangeIterator(Range range) {
		r = range;
		cur = range.getStart();
	}
	
	@Override
	public boolean hasNext() {
		return cur <= r.getEnd();
	}
	
	@Override
	public Integer next() {
		int res = cur;
		cur+=2;
		return res;
	}
}
