
public class WageEmployee extends Employee{
	private int hours;
	private double price;
	public WageEmployee(String name, 
			int id, 
			int age, 
			String phone,
			int hours,
			double price) {
		super(name, id, age, phone);
		this.hours = hours;
		this.price = price;
	}

	@Override
	public double calcSalary() {
		return hours * price;
	}
	
	public String toString() {
		return super.toString() + " " + calcSalary();
	}
	
}
