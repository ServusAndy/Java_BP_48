import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestCompany {

	public static void main(String[] args) {
		
//		String str = Stream.<String>empty()
//				.reduce((a, b) -> String.valueOf(a.charAt(0)) + String.valueOf(b.charAt(0))).orElse("");
//		System.out.println(str);
		
		List<List<String>> cities = new ArrayList<>();
		cities.add(Arrays.asList("Tel Aviv","Ashdod","Haifa"));
		cities.add(Arrays.asList("Moscow","St.Peterburg","Vologda"));
		cities.add(Arrays.asList("New Yourk"));
		
		Stream<Stream<String>> stream = cities.stream()
		.map(v -> v.stream());
		Stream<String> stream2 = cities.stream().flatMap(List::stream);
		boolean res = cities.stream()
		.flatMap(List::stream)
		.peek(System.out::println)
		.anyMatch("Moscow"::equals);
		System.out.println(res);
//		.forEach(System.out::println);
		
		res = Stream.<String>empty()
		.filter("Vasya"::equals)
		.findFirst().isPresent();
		
		res = Stream.<String>empty().anyMatch("Vasya"::equals);
		
	}

}
