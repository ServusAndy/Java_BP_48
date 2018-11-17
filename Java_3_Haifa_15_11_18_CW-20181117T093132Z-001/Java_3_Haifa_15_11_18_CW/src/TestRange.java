import java.util.Iterator;

public class TestRange {

	public static void main(String[] args) {
		Range r = new Range(0,10);
		Iterator<Integer> ri = new RangeIterator(r);
		ri = new RangeReverseIterator(r);
		
		while(ri.hasNext()) {
			System.out.println(ri.next());
		}
		
		String[] names = {"Vasya","Petya","Vova"};
		for(String n : names) {
			System.out.println(n);
		}

	}

}
