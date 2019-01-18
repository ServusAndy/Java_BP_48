import java.util.ArrayList;
import java.util.List;

public class TestPagination {
	private static List<String> list = new ArrayList<>();
	private static int pageSize = 10;
	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			list.add("Name " + i);
		}
		
		List<String> test = pagination(32);
		for(String str : test) {
			System.out.println(str);
		}

	}
	
	public static List<String> pagination(int page){
		int start = (page - 1) * pageSize;
		int end = page * pageSize;
		if(page < 1) {
			start = 0;
			end = pageSize;
			page = 1;
		}
		int realPageCount = list.size()/pageSize;
		if(page > realPageCount) {
			start = realPageCount * pageSize;
			end = list.size();
		}
		return list.subList(start, end);
	}

}
