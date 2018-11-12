
public class Person {
	private String name;
	private int age;
	private int id;
	public Person(String name, int age, int id) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}


	public int getAge() {
		return age;
	}


	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", id=" + id + "]";
	}
	
	public int compareTo(Person other) {
		return Integer.compare(age, other.age);
	}
}











