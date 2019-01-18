import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
	
	private int age;
	private String name;
	
	public static void main(String[] args) {
		/*final*/ int a;
		a = 10;
		IntFunction<String> f = (v) -> {
			return a + v + "";
		}; 
		
//		a = 20;
		
		Consumer<Object> c1 = (o) -> System.out.println(o);
		Consumer<Object> c2 = System.out::println;
		System.setOut(null);
		c2.accept("Vasya");
		c1.accept("Vasya");
		
		List<Integer> l = Main.<Integer>factory(10);
		
	}

	public Predicate<String> compareName(){
//		return new Predicate<String>() {
//			@Override
//			public boolean test(String t) {
//				return "Vasya".equals(t);
//			}
//		};
//		return (v) -> "Vasya".equals(v);
		return (v) -> name.equals(v);
	}
	
	public static <T> List<T> factory(int i){
		Supplier<List<T>> com = ArrayList::new;
		IntFunction<List<T>> com1 = ArrayList::new;
		return com1.apply(i);
//		return com.get();
 	}
}
