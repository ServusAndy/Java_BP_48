
public class TestCalc {

	public static void main(String[] args) {
		if(args.length == 3) {
			switch(args[1]){
			case "+":
				System.out.println(Integer.valueOf(args[0]) + Integer.valueOf(args[2]));
				break;
			case "-":
				System.out.println(Integer.valueOf(args[0]) - Integer.valueOf(args[2]));
				break;
			case "*":
				System.out.println(Integer.valueOf(args[0]) * Integer.valueOf(args[2]));
				break;
			case "/":
				int b = Integer.valueOf(args[2]);
				if(b == 0) {
					System.out.println("Error! Divide by zero!");
				}else {
					System.out.println(Integer.valueOf(args[0]) / Integer.valueOf(args[2]));
				}
				break;
				default:
					System.out.println("Wrong operation!");
			}
		}

	}

}
