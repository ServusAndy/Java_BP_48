
public class Employee extends Person{
	private double salary;
	public Employee(String name, 
			int id, 
			int age,
			double salary) {
		super(name, id, age);
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + salary;
	}
	
	public double getSalary() {
		return salary;
	}
	
	
//	public boolean equals(Object obj) {
//		if(!(obj instanceof Employee)) {
//			return false;
//		}
//		Employee other = (Employee) obj;
//		if(salary != other.salary) {
//			return false;
//		}
//		return true;
//	}

}
