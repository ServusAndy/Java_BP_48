
public class EmployeeManager {
	private Employee[] emploeeys;
	private int count;
	public EmployeeManager() {
		emploeeys = new Employee[10];
		count = 0;
	}
	public void add(Employee empl) {
		if(count < emploeeys.length) {
			emploeeys[count++] = empl;
		}else {
			System.out.println("Manager is full");
		}
	}
	
	public void remove(int index) {
		if(index >= 0 && index < count) {
			for(int i = index; i < count-1; i++) {
				emploeeys[i] = emploeeys[i+1];
			}
			count--;
		}
	}
	
	public void display() {
		for(int i = 0; i < count; i++) {
			System.out.println(emploeeys[i]);
		}
	}
}
