
public class Person implements MyComparable{
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
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", id=" + id + "]";
	}
	@Override
	public int compareTo(Object o) {
		Person other = (Person) o;
		return Integer.compare(id, other.id);
	}
	
	
	
}
