
public class TestInterface {

	public static void main(String[] args) {
		IShape[] arr = new IShape[10];
		arr[0] = new Triangle(10);
		arr[1] = new Circle();
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != null) {
//				System.out.println(arr[i].calcArea());
//				System.out.println(arr[i].calcPerimitr());
//				if(arr[i] instanceof IPrintable) {
//					IPrintable ip = (IPrintable) arr[i];
//					ip.print();
//				}
				arr[i].print();
				System.out.println("=============");
			}
		}

	}

}
