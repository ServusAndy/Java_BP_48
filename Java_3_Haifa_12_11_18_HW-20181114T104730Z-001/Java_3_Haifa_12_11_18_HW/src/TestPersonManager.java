import java.util.Arrays;

public class TestPersonManager {
	public static void main(String[] args) {
		PersonManager pm = new PersonManager();
		pm.add(new Person("Vasya",1,23));
		pm.add(new Person("Vasya2",2,23));
		pm.add(new Person("Vasya3",3,21));
		pm.add(new Person("Vasya4",4,25));
		pm.add(new Person("Vasya5",5,25));
		pm.add(new Person("Vasya6",6,25));
		pm.add(new Person("Vasya7",7,18));
		pm.add(new Person("Vasya8",8,37));
		
		Person[] tmp = pm.find(21, 25);
		for(int i = 0; i  < tmp.length;i++) {
			System.out.println(tmp[i]);
		}
	}
}
