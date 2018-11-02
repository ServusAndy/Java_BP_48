
public abstract class Employee {
	private String name;
	private int id;
	private int age;
	private String phone;
	
	public Employee(String name, 
			int id,
			int age,
			String phone) {
		this.name = name;
		this.id = id;
		this.age = age;
		this.phone = phone;
	}
	
	public String toString() {
		return id + " " + name + " " + age + " " + phone;
	}
	
	public abstract double calcSalary();
}
