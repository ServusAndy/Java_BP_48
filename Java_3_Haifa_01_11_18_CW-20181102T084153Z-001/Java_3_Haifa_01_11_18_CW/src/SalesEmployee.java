
public class SalesEmployee extends Employee{
	private double salary;

	public SalesEmployee(String name, 
			int id, 
			int age, 
			String phone,
			double salary) {
		super(name, id, age, phone);
		this.salary = salary;
	}

	@Override
	public double calcSalary() {
		return salary;
	}
	
	public String toString() {
		return super.toString() + " " + calcSalary();
	}

}
