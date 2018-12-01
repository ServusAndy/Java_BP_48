import java.util.LinkedList;

public class TestLinkedList {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		list.addFirst("Vasya");
		list.addFirst("Petya");
		list.addLast("Sofa");
		list.addLast("Vova");
		list.forEach(System.out::println);
		
		String str = list.getFirst();
		System.out.println(str);
		str = list.getLast();
		System.out.println(str);
		
		str = list.removeFirst();
		System.out.println(str);
		str = list.removeLast();
		System.out.println(str);
		
		
		

	}

}
