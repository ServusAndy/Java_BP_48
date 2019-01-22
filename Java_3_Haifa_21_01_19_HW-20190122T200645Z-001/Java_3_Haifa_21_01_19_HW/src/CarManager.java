import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class CarManager implements IManager{
	private List<Car> list;
	@Override
	public boolean add(Car c) {
		Objects.requireNonNull(c);
		int index = Collections.binarySearch(list, c);
		if(index < 0) {
			list.add(~index, c);
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(int serialNumber) {
		Car car = new Car("","",0,serialNumber,0);
		return list.remove(car);
	}

	@Override
	public Iterable<Car> find(Predicate<Car> filter) {
		List<Car> res = new ArrayList<>();
		for(Car c : list) {
			if(filter.test(c)) {
				res.add(c);
			}
		}
		return res;
	}

	@Override
	public <T> Iterable<T> find(Predicate<Car> filter, Function<Car, ? extends T> mapper) {
		List<T> res  = new ArrayList<>();
		for(Car c : list) {
			if(filter.test(c)) {
				T t = mapper.apply(c);
				res.add(t);
			}
		}
		return res;
	}

	@Override
	public int size() {
		return list.size();
	}

}
