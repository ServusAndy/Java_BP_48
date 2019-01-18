import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestFP {

	public static void main(String[] args) {
		BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
		MyInterface sum1 = (a, b) -> "" + a + b;
		Comparator<Integer> sum2 = (a,b) -> a+b;
		System.out.println(sum1.run(10, 15));
		System.out.println(isAlex().test("Vova"));
		Predicate<String> test = new Predicate<String>(){
			@Override
			public boolean test(String t) {
				return "Alex".equals(t);
			}
		};
		
		Supplier<Predicate<String>> test1 = TestFP::isAlex;
		System.out.println(test1.get().test("Vasya"));
		BiFunction<Integer, Integer, Integer> sum3 = TestFP::mySum;
		Function<String,String> trimmer = String::trim;
		trimmer = (str) -> str.trim();
		String str = trimmer.apply("      Vasya     ");
		System.out.println(str.length());
		
		Consumer<Object> printer = (o) -> System.out.println(o);
		Consumer<Object> printer1 = System.out::println;
		
		
		System.setOut(null);
		printer1.accept("Vasya");
		printer.accept("Vasya");
	}
	
	public static int mySum(int a, int b) {
		return a + b;
	}

	public static Predicate<String> isAlex(){
		return (v) -> "Alex".equals(v);
	}
	interface MyInterface{
		String run(int a, int b);
	}
}
