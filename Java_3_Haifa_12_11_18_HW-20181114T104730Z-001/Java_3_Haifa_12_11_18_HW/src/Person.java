
public class Person implements Comparable<Person>{
	private String name;
	private int id;
	private int age;
	public Person(String name, int id, int age) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + ", age=" + age + "]";
	}
	@Override
	public int compareTo(Person o) {
		return Integer.compare(id, o.id);
	}
	
	
}
