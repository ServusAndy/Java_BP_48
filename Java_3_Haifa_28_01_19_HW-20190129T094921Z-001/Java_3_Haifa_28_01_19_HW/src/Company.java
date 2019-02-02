import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

public class Company implements ICompany{
	private Set<Employee> list;
	private String name;
	private String city;
	private String phone;
	
	private Company() {
		list = new HashSet<>();
	}

	@Override
	public boolean addEmployee(Employee employee) {
		Objects.requireNonNull(employee);
//		return list.add(employee);
		if(list.add(employee)) {
			return true;
		}
		return false;
	}

	@Override
	public Employee removeEmployee(int id) {
		Employee tmp = getEmployeeById(id);
		if(tmp != null) {
			list.remove(tmp);
		}
		return tmp;
	}

	@Override
	public double totalSalary() {
//		double total = 0;
//		for(Employee empl : list) {
//			total += empl.calcSalary();
//		}
//		return total;
		return list.stream()
				.map(Employee::calcSalary)
				.reduce(0.0, (a, b) -> a + b);
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public double totalSales() {
//		double total = 0.0;
//		for(Employee empl : list) {
//			if(empl instanceof SalesEmployee) {
//				SalesEmployee tmp = (SalesEmployee) empl;
//				total += tmp.getSales();
//			}
//		}
		return list.stream()
				.filter(v -> v instanceof SalesEmployee)
				.map(v -> (SalesEmployee)v)
				.map(v -> v.getSales())
				.reduce(0.0, (a,b) -> a + b);
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		return (Employee) list.stream()
				.filter(empl -> empl.getId() == id)
				.findFirst()
				.orElse(null);
	}

	@Override
	public void printCompany() {
		System.out.println("Company: " + name + " " + city + " " + phone);
		list.forEach(System.out::println);
		
	}
	
	public static class Builder{
		private String n;
		private String c = "NoCity";
		private String p = "NoPhone";
		public Builder(String name) {
			Objects.requireNonNull(name);
			name = name.trim();
			if(name.isEmpty()) {
				throw new IllegalArgumentException("Name can't be empty!");
			}
			n = name;
		}
		
		public Builder city(String city) {
			c = Optional.ofNullable(city).orElse("NoCity");
			return this;
		}
		
		public Builder phone(String phone) {
			p = Optional.ofNullable(phone).orElse("NoPhone");
			return this;
		}
		
		public Company build() {
			Company res  = new Company();
			res.name = n;
			res.city = c;
			res.phone = p;
			return res;
		}
	}
	
}
