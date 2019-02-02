
public class WageEmployee extends Employee{
	private double price;
	private double hours;
	public WageEmployee(String name, 
			int age, 
			int id, 
			double price, 
			double hours) {
		super(name, age, id);
		this.hours = hours;
		this.price = price;
	}

	@Override
	public double calcSalary() {
		return hours * price;
	}
	
	public String toString() {
		return super.toString() + " salary: " + calcSalary(); 
	}

}
