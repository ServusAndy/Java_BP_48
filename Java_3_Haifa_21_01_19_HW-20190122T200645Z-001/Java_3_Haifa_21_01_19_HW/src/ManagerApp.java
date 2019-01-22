import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

public class ManagerApp {
	static double total = 0;
	public static void main(String[] args) {
		Function<String,Predicate<Car>> withManufc = manuf -> {return car -> car.getManufc().equals(manuf);};
		Function<String,Predicate<Car>> withModel = model -> car -> car.getModel().equals(model);
		Function<Car, String> toModel = car -> car.getModel();
		Function<Car, String> toManufc = car -> car.getManufc();
		Function<Car,Double> toPrice = car -> car.getPrice();
		IManager manager = new CarManager();
		
		manager.find(withManufc.apply("Honda")).forEach(System.out::println);
		
//		manager.find(withModel.apply("Civic"),toPrice).forEach(price -> total+=price);
//		System.out.println("Total = " + total);
		double total = 0;
		Iterable<Car> cars = manager.find(withModel.apply("Civic"));
		for(Car c : cars) {
			total += c.getPrice();
		}
		System.out.println("Total = " + total);
		
		Set<String> models = new HashSet<>();
		manager.find(withManufc.apply("Honda"),toModel).forEach(models::add);
		
		Map<String, Integer> map = new HashMap<>();
//		Iterable<String> manufcs = manager.find(c -> true, toManufc);
		
//		for(String m : manufcs) {
//			if(map.containsKey(m)) {
//				map.put(m, map.get(m) + 1);
//			}else {
//				map.put(m, 1);
//			}
//		}
//		for(String m : manufcs) {
//			map.merge(m, 1, (a, b) -> a+b );
//		}
		manager.find(c -> true, toManufc).forEach(m -> map.merge(m, 1, (a,b) -> a + b));
		map.forEach((k,v) -> System.out.println(k + " " + v)); 
//		Function<String, String> trimmer = s -> s.trim();
	}

//	private static Predicate<Car> withManufc(String m){
//		return car -> car.getManufc().equals(m);
//	}
}
