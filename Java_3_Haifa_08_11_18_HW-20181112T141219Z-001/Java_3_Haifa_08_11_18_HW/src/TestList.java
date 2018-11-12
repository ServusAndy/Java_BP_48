
public class TestList {

	public static void main(String[] args) {
//		String[] arr = null;
		String[] arr = {"Sofa","Moshe"};
		MyList<String> list = new MyList<>(arr);
		list.add("Vasya");
		list.add("Vasya1");
		list.add("Vasya2");
		list.add("Vasya3");
		list.add("Vasya4");
		list.add("Vasya5");
		list.add("Vasya6");
		list.add("Vasya7");
		list.add("Vasya8");
		list.add("Vasya9");
		list.add("Vasya10");
		list.add("Vasya11");
		list.add("Vasya12");
//		list.display();
		list.add("Petya");
		list.add("Vasya");
		
		list.remove("Vasya");
		list.display();

	}

}
