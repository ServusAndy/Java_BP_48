package dao;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMyList {
	IList<String> list;
	IList<String> listComp;
	@Before
	public void setUp() {
		list = new MyList<>();
		listComp = new MyList<>(new StringReverseComparator());
	}


}
