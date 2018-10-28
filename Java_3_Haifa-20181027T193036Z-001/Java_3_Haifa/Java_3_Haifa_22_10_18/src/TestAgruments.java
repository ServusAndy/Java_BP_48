
public class TestAgruments {

	public static void main(String[] args) {
		
		System.out.println(args.length);
		for(int i = 0; i < args.length; i++) {
			switch(args[i]) {
			case "Integer":
				System.out.println("Integer max: " 
						+ Integer.MAX_VALUE);
				System.out.println("Integer min: " 
						+ Integer.MIN_VALUE);
				break;
			case "Double":
				System.out.println("Double max: " 
						+ Double.MAX_VALUE);
				System.out.println("Double min: " 
						+ Double.MIN_VALUE);
				break;
			case "Float":
				System.out.println("Float max: " 
						+ Float.MAX_VALUE);
				System.out.println("Float min: " 
						+ Float.MIN_VALUE);
				break;
			case "Long":
				System.out.println("Long max: " 
						+ Long.MAX_VALUE);
				System.out.println("Long min: " 
						+ Long.MIN_VALUE);
				break;
			case "Byte":
				System.out.println("Byte max: " 
						+ Byte.MAX_VALUE);
				System.out.println("Byte min: " 
						+ Byte.MIN_VALUE);
				break;
			case "Character":
				System.out.println("Character max: " 
						+ Character.MAX_VALUE);
				System.out.println("Character min: " 
						+ Character.MIN_VALUE);
				break;
				default:
					System.out.println("Wrong format!");
			}
		}

	}

}
