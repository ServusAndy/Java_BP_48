
public class SalesEmployee extends Employee{
	private double salary;
	private double sales;
	public SalesEmployee(String name, 
			int age, 
			int id,
			double salary,
			double sales) {
		super(name, age, id);
		this.salary = salary;
		this.sales = sales;
	}

	public double getSales() {
		return sales;
	}
	@Override
	public double calcSalary() {
		return salary + sales * 0.1;
	}
	
	public String toString() {
		return super.toString() + " salary: " + calcSalary();
	}

}
