
public class Main {

	public static void main(String[] args) {
		Month.DEC.setCurrentDate(1);
		Month res = Month.DEC.plus(365);
		System.out.println(res + " date = " + res.getCurrentDate());

	}

}
