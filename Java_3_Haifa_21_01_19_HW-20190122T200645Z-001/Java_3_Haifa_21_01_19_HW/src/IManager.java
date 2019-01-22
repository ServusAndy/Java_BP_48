import java.util.function.Function;
import java.util.function.Predicate;

public interface IManager {
	boolean add(Car c);
	boolean remove(int serialNumber);
	Iterable<Car> find(Predicate<Car> filter);
	<T> Iterable<T> find(Predicate<Car> filter, Function<Car, ? extends T> mapper);
	int size();
}
