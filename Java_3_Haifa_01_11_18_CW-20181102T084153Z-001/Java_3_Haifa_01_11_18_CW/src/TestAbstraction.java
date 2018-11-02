
public class TestAbstraction {

	public static void main(String[] args) {
		Employee empl1 = 
				new SalesEmployee("Vasya", 1234, 33, "0555555", 15000);
		Employee empl2 = 
				new WageEmployee("Sofa", 4321, 25, "056789098", 100, 32.5);
		
//		System.out.println(empl1);
//		System.out.println(empl2);
		
		EmployeeManager manager = new EmployeeManager();
		manager.add(empl1);
		manager.add(empl2);
		manager.display();
		manager.remove(1);
		System.out.println("---------");
		manager.display();
		
		Math.abs(-1);
	}

}
