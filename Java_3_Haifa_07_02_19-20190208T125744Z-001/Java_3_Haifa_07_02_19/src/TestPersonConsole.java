import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TestPersonConsole {

	public static void main(String[] args) throws IOException {
		List<Person> list = new ArrayList<>();
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		EXIT:
		while(true) {
			System.out.print("Type command: ");
			String input = br.readLine();
			String[] arr  = input.trim().split(" ");
			if(arr.length == 0) {
				System.out.println("Wrong command!");
				continue;
			}
			switch(arr[0].toLowerCase()) {
			case "add":
				break;
			case "rm":
				break;
			case "show":
				System.out.println("--------------");
				list.forEach(System.out::println);
				break;
			case "exit":
				break EXIT;
				default:
					System.out.println("Wrong command!");
			}
		}
		
		System.out.println("Bye Bye!");
	}
	
	private static class Person{
		private String name;
		private int age;
	}

}
