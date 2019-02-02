import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class TestCollectors {

	public static void main(String[] args) {
		getMap(Arrays.asList(new User(123,"Vasya"),new User(123,"Petya")))
		.forEach((key,value) -> System.out.println(key + " " + value.name));
		List<String> names = Arrays.asList("aa","bb","cccc","cc","dddd","eeeeee");
		Map<Integer,List<String>> map1 = names.stream()
				.collect(groupingBy(String::length));
		map1.forEach((v,k) -> System.out.println(v + " " + k));
		Map<Integer, String> map2 = names.stream()
				.collect(groupingBy(String::length,
						joining("+")));
		System.out.println(map2);
	}

	public static List<String> getList(List<String> list) {
//		List<String> res = new ArrayList<>();
		return list.stream()
		.map(String::trim)
		.filter(s -> !s.isEmpty())
		.collect(toList());
//		.forEach(v -> res.add(v));
//		return res;
	}
	
	public static Map<Integer,User> getMap(List<User> users){
		return users.stream()
		.collect(toMap(user -> user.id, 
				user -> user,
				(left,right)->left));
	}
	
	static Map<Employee,List<Department>> departmentByLead(Company company){
		return company.departments().collect(groupingBy(Department::lead));
	}
	
	static Map<Employee,List<String>> departmentNameByLead(Company company){
		return company.departments()
				.collect(groupingBy(Department::lead,
						mapping(Department::title, toList())));
	}
	
	static Map<Employee,Set<Employee>> employeeeByLeader(Company company){
		return company.departments()
				.collect(groupingBy(Department::lead,
						flatMapping(Department::employees, toSet())));
	}
	
	static class User{
		int id;
		String name;
		public User(int id, String name) {
			this.id = id;
			this.name = name;
		}
	}
	
	interface Employee{
		String name();
	}
	
	interface Department{
		String title();
		Employee lead();
		Stream<Employee> employees();
	}
	
	interface Company{
		Stream<Department> departments();
	}
	
	public static <T, U, A, R>
    Collector<T, ?, R> flatMapping(Function<? super T, ? extends Stream<? extends U>> mapper,
                                   Collector<? super U, A, R> downstream) {
        BiConsumer<A, ? super U> downstreamAccumulator = downstream.accumulator();
        return Collector.of(downstream.supplier(),
                (r, t) -> {
                    try (Stream<? extends U> result = mapper.apply(t)) {
                        if (result != null)
                            result.sequential().forEach(u -> downstreamAccumulator.accept(r, u));
                    }
                },
                downstream.combiner(), downstream.finisher(),
                downstream.characteristics().toArray(new Collector.Characteristics[0]));
    }
}
