
public class TestManager {

	public static void main(String[] args) {
		NameManager nm = new NameManager();
		nm.add("Vasya");
		nm.add("Petya");
		nm.add("Vitalya");
		
		for(String name : nm) {
			System.out.println(name);
		}

	}

}
