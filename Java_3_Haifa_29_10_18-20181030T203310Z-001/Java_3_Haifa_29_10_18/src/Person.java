
public  class Person {
	private String name;
	private int id;
	private int age;
	
	public Person() {
		
	}
	public Person(String name, int id, int age) {
		this.name = name;
		this.age = age;
		this.id = id;
	}
	
	public String toString() {
		return name + " " + id + " " + age;
	}
	
	public final boolean equals(Object obj) {
		if(!(obj instanceof Person)) {
			return false;
		}
		Person other = (Person) obj;
		if(id != other.id) {
			return false;
		}
		return true;
	}
}
